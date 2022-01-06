package com.sofka.curriculum.gestioneducacion;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.generics.Institucion;
import com.sofka.curriculum.generics.Periodo;
import com.sofka.curriculum.gestionEducacion.command.ModificarEstudioEducacion;
import com.sofka.curriculum.gestionEducacion.event.EstudioEducacionModificado;
import com.sofka.curriculum.gestionEducacion.event.NuevaEducacionAgregada;
import com.sofka.curriculum.gestionEducacion.value.EducacionId;
import com.sofka.curriculum.gestionEducacion.value.Estudio;
import com.sofka.curriculum.gestionEducacion.value.GestionEducacionId;
import com.sofka.curriculum.gestionEducacion.value.Tipo;
import com.sofka.curriculum.usecase.gestioneducacion.ModificarEstudioEducacionUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ModificarEstudioEducacionUseCaseTest {

    @Mock
    DomainEventRepository domainEventRepository;

    @Test
    void modificarEstudioEducacionUseCaseTest(){

        var command = new ModificarEstudioEducacion(GestionEducacionId.of("xxxx"),
                new EducacionId(),
                new Estudio("Automatizacion Electronica"));

        var useCase =  new ModificarEstudioEducacionUseCase();

        Mockito.when(domainEventRepository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(domainEventRepository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        EstudioEducacionModificado event = (EstudioEducacionModificado) events.getDomainEvents().get(0);
        Assertions.assertEquals("Automatizacion Electronica", event.getEstudio().value());
        Mockito.verify(domainEventRepository).getEventsBy("xxxx");
    }

    private List<DomainEvent> eventList(){
        return List.of(new NuevaEducacionAgregada(
                new EducacionId(),
                new Tipo("Materia"),
                new Estudio("Electronica Industrial"),
                new Institucion("ITM"),
                new Periodo(LocalDateTime.now(),LocalDateTime.now().plusDays(20))
        ), new EstudioEducacionModificado(
                new EducacionId(),
                new Estudio("Control Industrial")
        ));
    }
}
