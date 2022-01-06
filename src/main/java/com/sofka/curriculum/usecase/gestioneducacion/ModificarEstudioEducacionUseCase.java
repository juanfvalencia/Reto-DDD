package com.sofka.curriculum.usecase.gestioneducacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.curriculum.gestionEducacion.GestionEducacion;
import com.sofka.curriculum.gestionEducacion.command.ModificarEstudioEducacion;

public class ModificarEstudioEducacionUseCase extends UseCase<RequestCommand<ModificarEstudioEducacion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ModificarEstudioEducacion> modificarEstudioEducacionRequestCommand){

        var command = modificarEstudioEducacionRequestCommand.getCommand();
        var educacion = GestionEducacion.from(command.getGestionEducacionId(), retrieveEvents());

        educacion.modificarEstudioEducacion(
                command.getEducacionId(),
                command.getEstudio()
        );
        emit().onResponse(new ResponseEvents(educacion.getUncommittedChanges()));
    }
}
