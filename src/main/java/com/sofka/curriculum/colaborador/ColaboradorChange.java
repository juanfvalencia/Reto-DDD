package com.sofka.curriculum.colaborador;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.curriculum.colaborador.event.*;

public class ColaboradorChange extends EventChange {

    public ColaboradorChange(Colaborador colaborador){

        apply((ColaboradorCreado event) -> {
            colaborador.colaboradorId = event.getColaboradorId();
            colaborador.hojaDeVidaId = event.getHojaDeVidaId();
            colaborador.fechaDeNacimiento = event.getFechaDeNacimiento();
            colaborador.nombreCompleto = event.getNombreCompleto();
            colaborador.cedula = event.getCedula();
            colaborador.genero = event.getGenero();
            colaborador.area = event.getArea();
        });

        apply((PerfilAgregado event) -> {
            colaborador.perfilId = event.getPerfilId();
        });

        apply((FechaDeNacimientoModificada event) -> {
            colaborador.fechaDeNacimiento = event.getFechaDeNacimiento();
        });

        apply((NombreCompletoModificado event) -> {
            colaborador.nombreCompleto = event.getNombreCompleto();
        });

        apply((CedulaModificada event) -> {
            colaborador.cedula = event.getCedula();
        });

        apply((GeneroModificado event) -> {
            colaborador.genero = event.getGenero();
        });

        apply((AreaModificada event) -> {
            colaborador.area = event.getArea();
        });
    }
}
