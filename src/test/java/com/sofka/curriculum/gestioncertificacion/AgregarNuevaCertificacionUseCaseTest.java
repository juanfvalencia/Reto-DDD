package com.sofka.curriculum.gestioncertificacion;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.generics.HojaDeVidaId;
import com.sofka.curriculum.generics.Institucion;
import com.sofka.curriculum.generics.Periodo;
import com.sofka.curriculum.gestionCertficacion.command.AgregarNuevaCertificacion;
import com.sofka.curriculum.gestionCertficacion.event.GestionCertifiacionCreada;
import com.sofka.curriculum.gestionCertficacion.event.NuevaCertificacionAgregada;
import com.sofka.curriculum.gestionCertficacion.value.CertificacionId;
import com.sofka.curriculum.gestionCertficacion.value.GestionCertificacionId;
import com.sofka.curriculum.gestionCertficacion.value.Nombre;
import com.sofka.curriculum.gestionEducacion.value.GestionEducacionId;
import com.sofka.curriculum.usecase.gestioncertificacion.AgregarNuevaCertificacionUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AgregarNuevaCertificacionUseCaseTest {

    @Mock
    DomainEventRepository domainEventRepository;

    @Test
    void agregarNuevaCertificacionUseCaseTest(){

        var command = new AgregarNuevaCertificacion(GestionCertificacionId.of("xxxx"),
                        CertificacionId.of("1"),
                        new Nombre("Ingenieria"),
                        new Institucion("ITM"),
                        new Periodo(LocalDateTime.now(), LocalDateTime.now().plusDays(5)));

        var useCase = new AgregarNuevaCertificacionUseCase();

        Mockito.when(domainEventRepository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(domainEventRepository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        NuevaCertificacionAgregada event = (NuevaCertificacionAgregada) events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("Ingenieria", event.getNombre().value());
        Assertions.assertEquals("ITM", event.getInstitucion().value());
        Mockito.verify(domainEventRepository).getEventsBy("xxxx");
    }

    private List<DomainEvent> eventList(){
        return List.of(new GestionCertifiacionCreada(
                new GestionCertificacionId(),
                new HojaDeVidaId()
        ), new NuevaCertificacionAgregada(
                new CertificacionId("1"),
                new Nombre("Biomedica"),
                new Institucion("ITM"),
                new Periodo(LocalDateTime.now(), LocalDateTime.now())
        ));
    }

}
