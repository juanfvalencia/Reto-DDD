package com.sofka.curriculum.perfil;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.generics.NombreCompleto;
import com.sofka.curriculum.perfil.command.ActualizarInformacionDeContactoReferencia;
import com.sofka.curriculum.perfil.event.InformacionDeContactoReferenciaActualizada;
import com.sofka.curriculum.perfil.event.NuevaReferenciaAgregada;
import com.sofka.curriculum.perfil.value.InformacionDeContacto;
import com.sofka.curriculum.perfil.value.PerfilId;
import com.sofka.curriculum.perfil.value.ReferenciaId;
import com.sofka.curriculum.usecase.perfil.ActualizarInformacionDeContactoReferenciaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ActualizarInformacionDeContactoReferenciaUseCaseTest {

    @Mock
    DomainEventRepository domainEventRepository;

    @Test
    void actualizarInformacionDeContactoReferenciaUseCaseTest(){

        var command = new ActualizarInformacionDeContactoReferencia(PerfilId.of("xxxx"),
                ReferenciaId.of("1"),
                new InformacionDeContacto("Union Libre"));

        var useCase = new ActualizarInformacionDeContactoReferenciaUseCase();

        when(domainEventRepository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(domainEventRepository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        InformacionDeContactoReferenciaActualizada event = (InformacionDeContactoReferenciaActualizada) events.getDomainEvents().get(0);
        Assertions.assertEquals("Union Libre", event.getInformacionDeContacto().value());
        Mockito.verify(domainEventRepository).getEventsBy("xxxx");
    }

    private List<DomainEvent> eventList(){
        return List.of(new NuevaReferenciaAgregada(
                new ReferenciaId(),
                new NombreCompleto("Juan Felipe","Valencia"),
                new InformacionDeContacto("Union Libre")
        ),new InformacionDeContactoReferenciaActualizada(
                        new ReferenciaId(),
                        new InformacionDeContacto("Union Libre")
        ));
    }
}
