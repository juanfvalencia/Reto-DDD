package com.sofka.curriculum.usecase.poreventos;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.curriculum.perfil.event.PerfilCreado;
import com.sofka.curriculum.perfil.value.PerfilId;
import com.sofka.curriculum.usecase.service.EnviarNotificacionPerfilService;

import java.util.List;

public class NotificarPerfilCreadoUseCase extends UseCase<TriggeredEvent<PerfilCreado>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<PerfilCreado> triggeredEvent){

        var event = triggeredEvent.getDomainEvent();
        var service = getService(EnviarNotificacionPerfilService.class).orElseThrow();

        Boolean valido = service.enviarPerfil(
                "soporteservice@perfilsofka.com",
                "Perfil creado",
                PerfilId.of(event.aggregateRootId())
        );
        if(!valido){
            throw new BusinessException(event.aggregateRootId(), "No fue posible notificar la creacion del perfil");
        }
        emit().onResponse(new ResponseEvents(List.of()));
    }
}
