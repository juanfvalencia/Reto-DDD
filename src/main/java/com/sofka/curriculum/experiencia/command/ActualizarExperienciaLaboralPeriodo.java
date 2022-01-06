package com.sofka.curriculum.experiencia.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.curriculum.experiencia.value.ExperienciaId;
import com.sofka.curriculum.experiencia.value.ExperienciaLaboralId;
import com.sofka.curriculum.generics.Periodo;

public class ActualizarExperienciaLaboralPeriodo extends Command {

    private final ExperienciaId experienciaId;
    private final ExperienciaLaboralId experienciaLaboralId;
    private final Periodo periodo;

    public ActualizarExperienciaLaboralPeriodo(ExperienciaId experienciaId, ExperienciaLaboralId entityId, Periodo periodo) {

        this.experienciaId = experienciaId;
        this.experienciaLaboralId = entityId;
        this.periodo = periodo;
    }

    public ExperienciaId getExperienciaId() {
        return experienciaId;
    }

    public ExperienciaLaboralId getExperienciaLaboralId() {
        return experienciaLaboralId;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

}
