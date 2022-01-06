package com.sofka.curriculum.usecase.gestioncertificacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.curriculum.gestionCertficacion.GestionCertificacion;
import com.sofka.curriculum.gestionCertficacion.command.ModificarPeriodoCertificacion;

public class ModificarPeriodoCertificacionUseCase extends UseCase<RequestCommand<ModificarPeriodoCertificacion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ModificarPeriodoCertificacion> modificarPeriodoCertificacionRequestCommand){

        var command = modificarPeriodoCertificacionRequestCommand.getCommand();
        var certificacion = GestionCertificacion.from(command.getGestionCertificacionId(), retrieveEvents());

        certificacion.modificarPeriodoCertificacion(
                command.getCertificacionId(),
                command.getPeriodo()
        );
        emit().onResponse(new ResponseEvents(certificacion.getUncommittedChanges()));
    }
}
