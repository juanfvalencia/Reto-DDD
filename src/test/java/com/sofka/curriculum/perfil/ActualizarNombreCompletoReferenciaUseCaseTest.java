package com.sofka.curriculum.perfil;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.generics.NombreCompleto;
import com.sofka.curriculum.perfil.command.ActualizarNombreCompletoReferencia;
import com.sofka.curriculum.perfil.event.NombreCompletoReferenciaActualizado;
import com.sofka.curriculum.perfil.event.NuevaReferenciaAgregada;
import com.sofka.curriculum.perfil.value.InformacionDeContacto;
import com.sofka.curriculum.perfil.value.PerfilId;
import com.sofka.curriculum.perfil.value.ReferenciaId;
import com.sofka.curriculum.usecase.perfil.ActualizarNombreCompletoReferenciaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ActualizarNombreCompletoReferenciaUseCaseTest {

    @Mock
    DomainEventRepository domainEventRepository;

    @Test
    void actualizarNombreCompletoReferenciaUseCaseTest(){

        var command = new ActualizarNombreCompletoReferencia(PerfilId.of("xxxx"),
                ReferenciaId.of("1"),
                new NombreCompleto("Juan","Valencia"));

        var useCase = new ActualizarNombreCompletoReferenciaUseCase();

        when(domainEventRepository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(domainEventRepository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        NombreCompletoReferenciaActualizado event = (NombreCompletoReferenciaActualizado) events.getDomainEvents().get(0);
        Assertions.assertEquals("Juan " + "Valencia", event.getNombreCompleto().value());
        Mockito.verify(domainEventRepository).getEventsBy("xxxx");
    }

    private List<DomainEvent> eventList(){
        return List.of(new NuevaReferenciaAgregada(
                new ReferenciaId(),
                new NombreCompleto("Juan","Valencia"),
                new InformacionDeContacto("Union Libre")
        ), new NombreCompletoReferenciaActualizado(
                new ReferenciaId(),
                new NombreCompleto("Juan Felipe","Valencia Renteria")
        ));
    }
}
