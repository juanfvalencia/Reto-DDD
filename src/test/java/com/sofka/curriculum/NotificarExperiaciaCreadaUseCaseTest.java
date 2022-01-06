package com.sofka.curriculum;


import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.curriculum.experiencia.event.ExperienciaCreada;
import com.sofka.curriculum.experiencia.value.ExperienciaId;
import com.sofka.curriculum.generics.HojaDeVidaId;
import com.sofka.curriculum.usecase.poreventos.NotificarExperienciaCreadaUseCase;
import com.sofka.curriculum.usecase.service.EnviarNotificacionExperienciaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NotificarExperiaciaCreadaUseCaseTest {

    @Mock
    EnviarNotificacionExperienciaService enviarNotificacionExperienciaService;

    @Test
    void notificarExperienciaCreadaUseCaseTest(){

        ExperienciaId experienciaId = ExperienciaId.of("xxxx");
        HojaDeVidaId hojaDeVidaId = new HojaDeVidaId("cvxxx");

        var event = new ExperienciaCreada(hojaDeVidaId);
        event.setAggregateRootId(experienciaId.value());
        var useCase = new NotificarExperienciaCreadaUseCase();

        when(enviarNotificacionExperienciaService.enviarExperiencia(
                "soporteservice@experienciasofka.com",
                "Experiencia creada",
                experienciaId
        )).thenReturn(true);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(enviarNotificacionExperienciaService);
        useCase.addServiceBuilder(builder);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow();

        verify(enviarNotificacionExperienciaService).enviarExperiencia(
                "soporteservice@experienciasofka.com",
                "Experiencia creada",
                experienciaId
        );
    }

    @Test
    void notificacionExperienciaCreadaError(){
        ExperienciaId experienciaId = ExperienciaId.of("xxxx");
        HojaDeVidaId hojaDeVidaId = new HojaDeVidaId("cvxxx");

        var event = new ExperienciaCreada(hojaDeVidaId);
        event.setAggregateRootId(experienciaId.value());
        var useCase = new NotificarExperienciaCreadaUseCase();

        when(enviarNotificacionExperienciaService.enviarExperiencia(
                "soporteservice@experienciasofka.com",
                "Experiencia creada",
                experienciaId
        )).thenReturn(false);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(enviarNotificacionExperienciaService);
        useCase.addServiceBuilder(builder);

        Assertions.assertThrows(BusinessException.class, () -> {
           UseCaseHandler.getInstance()
                   .syncExecutor(useCase, new TriggeredEvent<>(event))
                   .orElseThrow();
        });
    }
}
