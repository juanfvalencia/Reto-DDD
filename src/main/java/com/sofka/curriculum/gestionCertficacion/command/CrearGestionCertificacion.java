package com.sofka.curriculum.gestionCertficacion.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.curriculum.generics.HojaDeVidaId;
import com.sofka.curriculum.gestionCertficacion.value.GestionCertificacionId;

public class CrearGestionCertificacion extends Command {

    private final GestionCertificacionId gestionCertificacionId;
    private final HojaDeVidaId hojaDeVidaId;

    public CrearGestionCertificacion(GestionCertificacionId entityId, HojaDeVidaId hojaDeVidaId) {
        this.gestionCertificacionId = entityId;
        this.hojaDeVidaId = hojaDeVidaId;
    }

    public GestionCertificacionId getGestionCertificacionId() {
        return gestionCertificacionId;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }
}
