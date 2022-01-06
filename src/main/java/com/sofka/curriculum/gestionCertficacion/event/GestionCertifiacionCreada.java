package com.sofka.curriculum.gestionCertficacion.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.generics.HojaDeVidaId;
import com.sofka.curriculum.gestionCertficacion.value.GestionCertificacionId;

public class GestionCertifiacionCreada extends DomainEvent {

    private final HojaDeVidaId hojaDeVidaId;

    public GestionCertifiacionCreada(GestionCertificacionId gestionCertificacionId, HojaDeVidaId hojaDeVidaId) {
        super("sofka.gestioncertificacion.gestioncertificacioncreada");
        this.hojaDeVidaId = hojaDeVidaId;
    }

    public HojaDeVidaId getHojaDeVidaID() {
        return hojaDeVidaId;
    }
}
