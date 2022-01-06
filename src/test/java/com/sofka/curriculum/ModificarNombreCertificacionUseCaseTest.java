package com.sofka.curriculum;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.generics.Institucion;
import com.sofka.curriculum.generics.Periodo;
import com.sofka.curriculum.gestionCertficacion.command.ModificarNombreCertificacion;
import com.sofka.curriculum.gestionCertficacion.event.NombreCertificacionModificada;
import com.sofka.curriculum.gestionCertficacion.event.NuevaCertificacionAgregada;
import com.sofka.curriculum.gestionCertficacion.value.CertificacionId;
import com.sofka.curriculum.gestionCertficacion.value.GestionCertificacionId;
import com.sofka.curriculum.gestionCertficacion.value.Nombre;
import com.sofka.curriculum.usecase.gestioncertificacion.ModificarNombreCertificacionUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ModificarNombreCertificacionUseCaseTest {

    @Mock
    DomainEventRepository domainEventRepository;

    @Test
    void modificarNombreCertificacionUseCaseTest(){

        var command = new ModificarNombreCertificacion(GestionCertificacionId.of("xxxx"),
                new CertificacionId(),
                new Nombre("Diplomado"));

        var useCase = new ModificarNombreCertificacionUseCase();

        Mockito.when(domainEventRepository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(domainEventRepository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        NombreCertificacionModificada event = (NombreCertificacionModificada) events.getDomainEvents().get(0);
        Assertions.assertEquals("Diplomado", event.getNombre().value());
        Mockito.verify(domainEventRepository).getEventsBy("xxxx");
    }

    private List<DomainEvent> eventList(){
        return List.of(new NuevaCertificacionAgregada(
                new CertificacionId(),
                new Nombre("Biomedica"),
                new Institucion("udea"),
                new Periodo(LocalDateTime.now(), LocalDateTime.now())
        ), new NombreCertificacionModificada(
                new CertificacionId(),
                new Nombre("Curso")
        ));
    }
}
