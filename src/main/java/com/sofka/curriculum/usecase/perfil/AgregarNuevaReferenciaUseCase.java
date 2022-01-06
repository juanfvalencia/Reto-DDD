package com.sofka.curriculum.usecase.perfil;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.curriculum.perfil.Perfil;
import com.sofka.curriculum.perfil.command.AgregarNuevaReferencia;

public class AgregarNuevaReferenciaUseCase extends UseCase<RequestCommand<AgregarNuevaReferencia>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarNuevaReferencia> agregarNuevaReferenciaRequestCommand){

        var command = agregarNuevaReferenciaRequestCommand.getCommand();
        var perfil = Perfil.from(command.getPerfilId(), retrieveEvents());

        perfil.agregarNuevaReferencia(
                command.getNombreCompleto(),
                command.getInformacionDeContacto()
        );
        emit().onResponse(new ResponseEvents(perfil.getUncommittedChanges()));
    }
}
