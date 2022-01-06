package com.sofka.curriculum.colaborador;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.colaborador.command.AgregarPerfil;
import com.sofka.curriculum.colaborador.event.ColaboradorCreado;
import com.sofka.curriculum.colaborador.event.PerfilAgregado;
import com.sofka.curriculum.colaborador.value.*;
import com.sofka.curriculum.generics.HojaDeVidaId;
import com.sofka.curriculum.generics.NombreCompleto;
import com.sofka.curriculum.perfil.value.PerfilId;
import com.sofka.curriculum.usecase.colaborador.AgregarPerfilUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AgregarPerfilUseCaseTest {

    @Mock
    DomainEventRepository domainEventRepository;

    @Test
    void agregarPerfilUseCaseTest(){

        ColaboradorId colaboradorId = ColaboradorId.of("xxxx");
        PerfilId perfilId = PerfilId.of("1");

        var command = new AgregarPerfil(colaboradorId, perfilId);
        var useCase = new AgregarPerfilUseCase();

        Mockito.when(domainEventRepository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(domainEventRepository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        PerfilAgregado event = (PerfilAgregado) events.getDomainEvents().get(0);
        Assertions.assertEquals("1", event.getPerfilId().value());
        Mockito.verify(domainEventRepository).getEventsBy("xxxx");
    }

    private List<DomainEvent> eventList(){
        return List.of(new ColaboradorCreado(
                new ColaboradorId(),
                new HojaDeVidaId(),
                new FechaDeNacimiento(28,2,1994),
                new NombreCompleto("Sergio","Suarez"),
                new Cedula("1152111255"),
                new Genero("M"),
                new Area("Redes")
        ), new PerfilAgregado(
                new PerfilId()
        ));
    }
}
