package com.sofka.curriculum.experiencia.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.experiencia.value.ExperienciaId;
import com.sofka.curriculum.generics.HojaDeVidaId;

import java.util.Objects;

public class ExperienciaCreada extends DomainEvent {

    private final HojaDeVidaId hojaDeVidaId;

    public ExperienciaCreada(HojaDeVidaId hojaDeVidaId ) {
        super("sofka.experiencia.experienciacreada");
        this.hojaDeVidaId = Objects.requireNonNull(hojaDeVidaId);
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }
}
