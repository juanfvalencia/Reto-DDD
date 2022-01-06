package com.sofka.curriculum.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.curriculum.colaborador.Colaborador;
import com.sofka.curriculum.colaborador.command.ModificarArea;

public class ModificarAreaUseCase extends UseCase<RequestCommand<ModificarArea>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ModificarArea> modificarAreaRequestCommand) {
        var command = modificarAreaRequestCommand.getCommand();
        var colaborador = Colaborador.from(command.getColaboradorId(), retrieveEvents());

        colaborador.modificarArea(
                command.getArea()
        );

        emit().onResponse(new ResponseEvents(colaborador.getUncommittedChanges()));
    }
}
