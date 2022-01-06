package com.sofka.curriculum.experiencia.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.generics.HojaDeVidaId;


public class ExperienciaCreada extends DomainEvent {

    private final HojaDeVidaId hojaDeVidaId;

    public ExperienciaCreada(HojaDeVidaId hojaDeVidaId ) {
        super("sofka.experiencia.experienciacreada");
        this.hojaDeVidaId = hojaDeVidaId;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }
}
