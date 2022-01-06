package com.sofka.curriculum.hojaDeVida.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.generics.HojaDeVidaId;

public class HojaDeVidaCreada extends DomainEvent {

    private final HojaDeVidaId hojaDeVidaId;

    public HojaDeVidaCreada(HojaDeVidaId entityId){
        super("sofka.hojadevida.hojadevidacreada");
        this.hojaDeVidaId = entityId;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }
}
