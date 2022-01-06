package com.sofka.curriculum.gestioneducacion;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.generics.HojaDeVidaId;
import com.sofka.curriculum.generics.Institucion;
import com.sofka.curriculum.generics.Periodo;
import com.sofka.curriculum.gestionEducacion.command.AgregarNuevaEducacion;
import com.sofka.curriculum.gestionEducacion.event.GestionEducacionCreado;
import com.sofka.curriculum.gestionEducacion.event.NuevaEducacionAgregada;
import com.sofka.curriculum.gestionEducacion.value.EducacionId;
import com.sofka.curriculum.gestionEducacion.value.Estudio;
import com.sofka.curriculum.gestionEducacion.value.GestionEducacionId;
import com.sofka.curriculum.gestionEducacion.value.Tipo;
import com.sofka.curriculum.usecase.gestioneducacion.AgregarNuevaEducacionUseCase;
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
public class AgregarNuevaEducacionUseCaseTest {

    @Mock
    DomainEventRepository domainEventRepository;

    @Test
    void agregarNuevaEducacionUseCaseTest(){

        var command = new AgregarNuevaEducacion(GestionEducacionId.of("xxxx"),
                        EducacionId.of("1"),
                        new Tipo("Materia"),
                        new Estudio("Control Digital"),
                        new Institucion("ITM"),
                        new Periodo(LocalDateTime.now(), LocalDateTime.now()));

        var useCase = new AgregarNuevaEducacionUseCase();

        Mockito.when(domainEventRepository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(domainEventRepository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        NuevaEducacionAgregada event = (NuevaEducacionAgregada) events.getDomainEvents().get(0);
        Assertions.assertEquals("Materia", event.getTipo().value());
        Assertions.assertEquals("Control Digital", event.getEstudio().value());
        Assertions.assertEquals("ITM", event.getInstitucion().value());
        Mockito.verify(domainEventRepository).getEventsBy("xxxx");
    }

    private List<DomainEvent> eventList(){
        return List.of(new GestionEducacionCreado(
                new HojaDeVidaId()
        ), new NuevaEducacionAgregada(
                new EducacionId(),
                new Tipo("Diplomado"),
                new Estudio("Control de Microcontroladores"),
                new Institucion("ITM"),
                new Periodo(LocalDateTime.now(), LocalDateTime.now().plusDays(20))
        ));
    }
}
