package com.sofka.curriculum.usecase.perfil;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.curriculum.perfil.Perfil;
import com.sofka.curriculum.perfil.command.ActualizarNombreCompletoReferencia;

public class ActualizarNombreCompletoReferenciaUseCase extends UseCase<RequestCommand<ActualizarNombreCompletoReferencia>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreCompletoReferencia> actualizarNombreCompletoReferenciaRequestCommand){

        var command = actualizarNombreCompletoReferenciaRequestCommand.getCommand();
        var perfil = Perfil.from(command.getPerfilId(), retrieveEvents());

        perfil.actualizarNombreCompletoReferencia(
                command.getReferenciaId(),
                command.getNombreCompleto()
        );
        emit().onResponse(new ResponseEvents(perfil.getUncommittedChanges()));
    }
}
