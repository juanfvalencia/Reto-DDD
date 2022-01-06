package com.sofka.curriculum.experiencia.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.curriculum.experiencia.value.ExperienciaId;
import com.sofka.curriculum.generics.HojaDeVidaId;

public class CrearExperiencia extends Command {

    private final ExperienciaId experienciaId;
    private final HojaDeVidaId hojaDeVidaId;

    public CrearExperiencia(ExperienciaId experienciaId, HojaDeVidaId hojaDeVidaId) {
        this.experienciaId = experienciaId;
        this.hojaDeVidaId = hojaDeVidaId;
    }

    public ExperienciaId getIdExperiencia() {
        return experienciaId;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }
}
