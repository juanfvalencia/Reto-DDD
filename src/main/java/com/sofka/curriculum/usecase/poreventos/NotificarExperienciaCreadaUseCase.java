package com.sofka.curriculum.usecase.poreventos;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.curriculum.experiencia.event.ExperienciaCreada;
import com.sofka.curriculum.experiencia.value.ExperienciaId;
import com.sofka.curriculum.usecase.service.EnviarNotificacionExperienciaService;

import java.util.List;

public class NotificarExperienciaCreadaUseCase extends UseCase<TriggeredEvent<ExperienciaCreada>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<ExperienciaCreada> triggeredEvent){

        var event = triggeredEvent.getDomainEvent();
        var service = getService(EnviarNotificacionExperienciaService.class).orElseThrow();

        Boolean valido = service.enviarExperiencia(
                "soporteservice@experienciasofka.com",
                "Experiencia creada",
                ExperienciaId.of(event.aggregateRootId())
        );
        if(!valido){
            throw new BusinessException(event.aggregateRootId(), "No fue posible notificar la creacion de la experiencia");
        }
        emit().onResponse(new ResponseEvents(List.of()));
    }
}
