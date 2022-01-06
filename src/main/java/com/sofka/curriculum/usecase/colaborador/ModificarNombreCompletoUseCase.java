package com.sofka.curriculum.usecase.colaborador;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.curriculum.colaborador.Colaborador;
import com.sofka.curriculum.colaborador.command.ModificarNombreCompleto;

public class ModificarNombreCompletoUseCase extends UseCase<RequestCommand<ModificarNombreCompleto>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ModificarNombreCompleto> modificarNombreCompletoRequestCommand){

        var command =  modificarNombreCompletoRequestCommand.getCommand();
        var colaborador = Colaborador.from(command.getColaboradorId(), retrieveEvents());

        colaborador.modificarNombreCompleto(
                command.getNombreCompleto()
        );
        emit().onResponse(new ResponseEvents(colaborador.getUncommittedChanges()));
    }
}
