package com.sofka.curriculum.gestionEducacion.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.generics.HojaDeVidaId;

public class GestionEducacionCreado extends DomainEvent {

    private final HojaDeVidaId hojaDeVidaId;

    public GestionEducacionCreado(HojaDeVidaId hojaDeVidaId){
        super("sofka.gestioneducacion.gestioneducacioncreado");
        this.hojaDeVidaId = hojaDeVidaId;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }

}
