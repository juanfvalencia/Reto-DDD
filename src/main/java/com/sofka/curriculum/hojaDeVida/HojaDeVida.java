package com.sofka.curriculum.hojaDeVida;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofka.curriculum.generics.HojaDeVidaId;
import com.sofka.curriculum.hojaDeVida.event.HojaDeVidaCreada;

public class HojaDeVida extends AggregateEvent<HojaDeVidaId> {

    public HojaDeVida(HojaDeVidaId entityId) {
        super(entityId);
        appendChange(new HojaDeVidaCreada(entityId)).apply();
    }
}
