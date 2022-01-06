package com.sofka.curriculum.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.curriculum.colaborador.Colaborador;
import com.sofka.curriculum.colaborador.command.ModificarGenero;

public class ModificarGeneroUseCase extends UseCase<RequestCommand<ModificarGenero>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ModificarGenero> modificarGeneroRequestCommand){

        var command = modificarGeneroRequestCommand.getCommand();
        var colaborador = Colaborador.from(command.getColaboradorId(), retrieveEvents());

        colaborador.modificarGenero(command.getGenero());
        emit().onResponse(new ResponseEvents(colaborador.getUncommittedChanges()));
    }
}
