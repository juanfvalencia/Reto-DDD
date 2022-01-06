package com.sofka.curriculum.usecase.gestioncertificacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.curriculum.gestionCertficacion.GestionCertificacion;
import com.sofka.curriculum.gestionCertficacion.command.ModificarNombreCertificacion;

public class ModificarNombreCertificacionUseCase extends UseCase<RequestCommand<ModificarNombreCertificacion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ModificarNombreCertificacion> modificarNombreCertificacionRequestCommand){

        var command = modificarNombreCertificacionRequestCommand.getCommand();
        var certificacion = GestionCertificacion.from(command.getGestionCertificacionId(), retrieveEvents());

        certificacion.modificarNombreCertificacion(
                command.getCertificacionId(),
                command.getNombre()
        );
        emit().onResponse(new ResponseEvents(certificacion.getUncommittedChanges()));
    }
}
