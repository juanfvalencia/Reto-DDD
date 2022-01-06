package com.sofka.curriculum.usecase.experiencia;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.curriculum.experiencia.Experiencia;
import com.sofka.curriculum.experiencia.command.AgregarExpericiaLaboral;

public class AgregarExperienciaLaboralUseCase extends UseCase<RequestCommand<AgregarExpericiaLaboral>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarExpericiaLaboral> agregarExpericiaLaboralRequestCommand){
        var command = agregarExpericiaLaboralRequestCommand.getCommand();
        var experiencia = Experiencia.from(command.getExperienciaId(), retrieveEvents());

        experiencia.agregarExperienciaLaboral(
                command.getInstitucion(),
                command.getPeriodo(),
                command.getConocimientoAdquirido()
        );
        emit().onResponse(new ResponseEvents(experiencia.getUncommittedChanges()));
    }
}
