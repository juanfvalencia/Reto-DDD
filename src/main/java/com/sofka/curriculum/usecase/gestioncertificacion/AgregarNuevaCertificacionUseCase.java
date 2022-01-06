package com.sofka.curriculum.usecase.gestioncertificacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.curriculum.gestionCertficacion.GestionCertificacion;
import com.sofka.curriculum.gestionCertficacion.command.AgregarNuevaCertificacion;

public class AgregarNuevaCertificacionUseCase extends UseCase<RequestCommand<AgregarNuevaCertificacion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarNuevaCertificacion> agregarNuevaCertificacionRequestCommand){

        var command = agregarNuevaCertificacionRequestCommand.getCommand();
        var certificacion = GestionCertificacion.from(command.getGestionCertificacionId(), retrieveEvents());

        certificacion.agregarNuevaCertificacion(
                command.getNombre(),
                command.getInstitucion(),
                command.getPeriodo()
        );
        emit().onResponse(new ResponseEvents(certificacion.getUncommittedChanges()));
    }
}
