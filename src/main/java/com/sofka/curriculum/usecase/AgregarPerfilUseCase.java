package com.sofka.curriculum.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.curriculum.colaborador.Colaborador;
import com.sofka.curriculum.colaborador.command.AgregarPerfil;

public class AgregarPerfilUseCase extends UseCase<RequestCommand<AgregarPerfil>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarPerfil> agregarPerfilRequestCommand) {
        var command = agregarPerfilRequestCommand.getCommand();
        var colaborador = Colaborador.from(command.getColaboradorId(), retrieveEvents());

        colaborador.agregarPerfil(
                command.getPerfilId()
        );
        emit().onResponse(new ResponseEvents(colaborador.getUncommittedChanges()));
    }
}
