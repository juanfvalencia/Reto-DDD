package com.sofka.curriculum.usecase.experiencia;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.curriculum.experiencia.Experiencia;
import com.sofka.curriculum.experiencia.command.ActualizarExperienciaLaboralPeriodo;

public class ActualizarExperienciaLaboralPeriodoUseCase extends UseCase<RequestCommand<ActualizarExperienciaLaboralPeriodo>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarExperienciaLaboralPeriodo> actualizarExperienciaLaboralPeriodoRequestCommand){

        var command = actualizarExperienciaLaboralPeriodoRequestCommand.getCommand();
        var experiencia = Experiencia.from(command.getExperienciaId(), retrieveEvents());

        experiencia.actualizarExperienciaLaboralPeriodo(
                command.getExperienciaLaboralId(),
                command.getPeriodo()
        );
        emit().onResponse(new ResponseEvents(experiencia.getUncommittedChanges()));
    }
}
