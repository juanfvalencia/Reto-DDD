package com.sofka.curriculum;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.generics.NombreCompleto;
import com.sofka.curriculum.perfil.command.AgregarNuevaReferencia;
import com.sofka.curriculum.perfil.event.NuevaReferenciaAgregada;
import com.sofka.curriculum.perfil.value.InformacionDeContacto;
import com.sofka.curriculum.perfil.value.PerfilId;
import com.sofka.curriculum.perfil.value.ReferenciaId;
import com.sofka.curriculum.usecase.perfil.AgregarNuevaReferenciaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AgregarNuevaReferenciaUseCaseTest {

    @Mock
    DomainEventRepository domainEventRepository;

    @Test
    void agregarNuevaReferenciaUseCaseTest(){

        var command = new AgregarNuevaReferencia(PerfilId.of("xxxx"), ReferenciaId.of("1"),
                new NombreCompleto("Juan Felipe","Valencia"),
                new InformacionDeContacto("Union Libre"));

        var useCase = new AgregarNuevaReferenciaUseCase();

        when(domainEventRepository.getEventsBy("xxxx")).thenReturn(eventlist());
        useCase.addRepository(domainEventRepository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        NuevaReferenciaAgregada event = (NuevaReferenciaAgregada) events.getDomainEvents().get(0);
        Assertions.assertEquals("Juan Felipe"+"Valencia", event.getNombreCompleto().value());
        Assertions.assertEquals("Union Libre", event.getInformacionDeContacto().value());
    }

    private List<DomainEvent> eventlist(){
        return List.of(new NuevaReferenciaAgregada(
                new ReferenciaId(),
                new NombreCompleto("Juan Felipe","Valencia"),
                new InformacionDeContacto("Union Libre")
        ));
    }
}
