package com.sofka.curriculum.usecase.gestioneducacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.curriculum.gestionEducacion.GestionEducacion;
import com.sofka.curriculum.gestionEducacion.command.ModificarTipoEducacion;

public class ModificarTipoEducacionUseCase extends UseCase<RequestCommand<ModificarTipoEducacion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ModificarTipoEducacion> modificarTipoEducacionRequestCommand){
        var command = modificarTipoEducacionRequestCommand.getCommand();
        var educacion = GestionEducacion.from(command.getGestionEducacionId(), retrieveEvents());

        educacion.modificarTipoEducacion(
                command.getEducacionId(),
                command.getTipo()
        );
        emit().onResponse(new ResponseEvents(educacion.getUncommittedChanges()));
    }
}
