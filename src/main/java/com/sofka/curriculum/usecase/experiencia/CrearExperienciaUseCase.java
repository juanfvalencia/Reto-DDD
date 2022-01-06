package com.sofka.curriculum.usecase.experiencia;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.curriculum.experiencia.Experiencia;
import com.sofka.curriculum.experiencia.command.CrearExperiencia;

public class CrearExperienciaUseCase extends UseCase<RequestCommand<CrearExperiencia>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearExperiencia> requestCommand){

        var command = requestCommand.getCommand();
        Experiencia experiencia;

        experiencia = new Experiencia(
                command.getIdExperiencia(),
                command.getHojaDeVidaId()
        );
        emit().onResponse(new ResponseEvents(experiencia.getUncommittedChanges()));
    }
}
