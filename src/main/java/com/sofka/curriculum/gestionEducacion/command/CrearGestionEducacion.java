package com.sofka.curriculum.gestionEducacion.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.curriculum.generics.HojaDeVidaId;
import com.sofka.curriculum.gestionEducacion.value.GestionEducacionId;

public class CrearGestionEducacion extends Command {

    private final GestionEducacionId gestionEducacionId;
    private final HojaDeVidaId hojaDeVidaId;

    public CrearGestionEducacion(GestionEducacionId entityId, HojaDeVidaId hojaDeVidaId) {
        this.gestionEducacionId = entityId;
        this.hojaDeVidaId = hojaDeVidaId;
    }

    public GestionEducacionId getGestionEducacionId() {
        return gestionEducacionId;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }
}
