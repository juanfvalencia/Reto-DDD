package com.sofka.curriculum.usecase.perfil;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.curriculum.perfil.Perfil;
import com.sofka.curriculum.perfil.command.CrearPerfil;

public class CrearPerfilUseCase extends UseCase<RequestCommand<CrearPerfil>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearPerfil> requestCommand){

        var command = requestCommand.getCommand();
        Perfil perfil;

        perfil = new Perfil(
                command.getPerfilId(),
                command.getHojaDeVidaId(),
                command.getFotoDePerfil(),
                command.getInformacionDeContacto()
        );
        if(!perfil.fotoDePerfil().value().contains("https://")){
            throw new BusinessException(command.getPerfilId().value(), "La ruta de debe iniciar con https:// y la foto debe estar en la nube");
        }
        emit().onResponse(new ResponseEvents(perfil.getUncommittedChanges()));
    }
}
