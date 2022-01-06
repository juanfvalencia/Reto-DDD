package com.sofka.curriculum.usecase.perfil;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.curriculum.perfil.Perfil;
import com.sofka.curriculum.perfil.command.ActualizarInformacionDeContactoReferencia;

public class ActualizarInformacionDeContactoReferenciaUseCase extends UseCase<RequestCommand<ActualizarInformacionDeContactoReferencia>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarInformacionDeContactoReferencia> actualizarInformacionDeContactoReferenciaRequestCommand){
        var command = actualizarInformacionDeContactoReferenciaRequestCommand.getCommand();
        var perfil = Perfil.from(command.getPerfilId(), retrieveEvents());

        perfil.actualizarInformacionDeContactoReferencia(
                command.getReferenciaId(),
                command.getInformacionDeContacto()
        );
        emit().onResponse(new ResponseEvents(perfil.getUncommittedChanges()));
    }
}
