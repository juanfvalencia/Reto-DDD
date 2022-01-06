package com.sofka.curriculum.usecase.gestioneducacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.curriculum.gestionEducacion.Educacion;
import com.sofka.curriculum.gestionEducacion.GestionEducacion;
import com.sofka.curriculum.gestionEducacion.command.AgregarNuevaEducacion;

public class AgregarNuevaEducacionUseCase extends UseCase<RequestCommand<AgregarNuevaEducacion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarNuevaEducacion> agregarNuevaEducacionRequestCommand){

        var command = agregarNuevaEducacionRequestCommand.getCommand();
        var educacion = GestionEducacion.from(command.getGestionEducacionId(), retrieveEvents());

        educacion.agregarNuevaEducacion(
                command.getTipo(),
                command.getEstudio(),
                command.getInstitucion(),
                command.getPeriodo()
        );
        emit().onResponse(new ResponseEvents(educacion.getUncommittedChanges()));
    }
}
