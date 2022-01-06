package com.sofka.curriculum;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.curriculum.generics.HojaDeVidaId;
import com.sofka.curriculum.perfil.event.PerfilCreado;
import com.sofka.curriculum.perfil.value.FotoDePerfil;
import com.sofka.curriculum.perfil.value.InformacionDeContacto;
import com.sofka.curriculum.perfil.value.PerfilId;
import com.sofka.curriculum.usecase.poreventos.NotificarPerfilCreadoUseCase;
import com.sofka.curriculum.usecase.service.EnviarNotificacionPerfilService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NotificarPerfilCreadoUseCaseTest {

    @Mock
    EnviarNotificacionPerfilService enviarNotificacionPerfilService;

    @Test
    void notificarPerfilCreadoUseCaseTest(){

        PerfilId perfilId = PerfilId.of("xxxx");
        HojaDeVidaId hojaDeVidaId = HojaDeVidaId.of("cvxxx");
        FotoDePerfil fotoDePerfil = new FotoDePerfil("https://mydrive.com");
        InformacionDeContacto informacionDeContacto = new InformacionDeContacto("3125772501");

        var event = new PerfilCreado(perfilId,hojaDeVidaId,fotoDePerfil,informacionDeContacto);
        event.setAggregateRootId(perfilId.value());
        var useCase = new NotificarPerfilCreadoUseCase();

        when(enviarNotificacionPerfilService.enviarPerfil(
                "soporteservice@perfilsofka.com",
                "Perfil creado",perfilId)).thenReturn(true);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(enviarNotificacionPerfilService);
        useCase.addServiceBuilder(builder);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow();

        verify(enviarNotificacionPerfilService).enviarPerfil(
                "soporteservice@perfilsofka.com",
                "Perfil creado",perfilId
        );
    }

    @Test
    void notificarPerfilError(){

        PerfilId perfilId = PerfilId.of("xxxx");
        HojaDeVidaId hojaDeVidaId = HojaDeVidaId.of("cvxxx");
        FotoDePerfil fotoDePerfil = new FotoDePerfil("https://mydrive.com");
        InformacionDeContacto informacionDeContacto = new InformacionDeContacto("3125772501");

        var event = new PerfilCreado(perfilId,hojaDeVidaId,fotoDePerfil,informacionDeContacto);
        event.setAggregateRootId(perfilId.value());
        var useCase = new NotificarPerfilCreadoUseCase();

        when(enviarNotificacionPerfilService.enviarPerfil(
                "soporteservice@perfilsofka.com",
                "Perfil creado",perfilId)).thenReturn(false);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(enviarNotificacionPerfilService);
        useCase.addServiceBuilder(builder);

        Assertions.assertThrows(BusinessException.class, () ->{
            UseCaseHandler.getInstance()
                    .syncExecutor(useCase, new TriggeredEvent<>(event))
                    .orElseThrow();
        });
    }
}
