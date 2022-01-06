package com.sofka.curriculum.hojaDeVida.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.curriculum.generics.HojaDeVidaId;

public class CrearHojaDeVida extends Command {

    private final HojaDeVidaId hojaDeVidaId;

    public CrearHojaDeVida(HojaDeVidaId hojaDeVidaId) {
        this.hojaDeVidaId = hojaDeVidaId;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }
}
