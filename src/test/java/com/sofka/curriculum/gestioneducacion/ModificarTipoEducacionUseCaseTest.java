package com.sofka.curriculum.gestioneducacion;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.generics.Institucion;
import com.sofka.curriculum.generics.Periodo;
import com.sofka.curriculum.gestionEducacion.command.ModificarTipoEducacion;
import com.sofka.curriculum.gestionEducacion.event.NuevaEducacionAgregada;
import com.sofka.curriculum.gestionEducacion.event.TipoEducacionModificado;
import com.sofka.curriculum.gestionEducacion.value.EducacionId;
import com.sofka.curriculum.gestionEducacion.value.Estudio;
import com.sofka.curriculum.gestionEducacion.value.GestionEducacionId;
import com.sofka.curriculum.gestionEducacion.value.Tipo;
import com.sofka.curriculum.usecase.gestioneducacion.ModificarTipoEducacionUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ModificarTipoEducacionUseCaseTest {

    @Mock
    DomainEventRepository domainEventRepository;

    @Test
    void modificarTipoEducacionUseCaseTest(){

        var command = new ModificarTipoEducacion(GestionEducacionId.of("xxxx"),
                new EducacionId(),
                new Tipo("Materia"));

        var useCase = new ModificarTipoEducacionUseCase();

        Mockito.when(domainEventRepository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(domainEventRepository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        TipoEducacionModificado event = (TipoEducacionModificado) events.getDomainEvents().get(0);
        Assertions.assertEquals("Materia", event.getTipo().value());
        Mockito.verify(domainEventRepository).getEventsBy("xxxx");
    }

    private List<DomainEvent> eventList(){
        return List.of(new NuevaEducacionAgregada(
                new EducacionId(),
                new Tipo("Materia"),
                new Estudio("PLC"),
                new Institucion("ITM"),
                new Periodo(LocalDateTime.now(), LocalDateTime.now().plusDays(30))
        ), new TipoEducacionModificado(
                new EducacionId(),
                new Tipo("Diplomado")
        ));
    }
}
