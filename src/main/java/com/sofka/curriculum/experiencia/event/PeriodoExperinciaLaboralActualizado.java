package com.sofka.curriculum.experiencia.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.experiencia.value.ExperienciaLaboralId;
import com.sofka.curriculum.generics.Periodo;

import java.util.Objects;

public class PeriodoExperinciaLaboralActualizado extends DomainEvent {

    private final ExperienciaLaboralId experienciaLaboralId;
    private final Periodo periodo;

    public PeriodoExperinciaLaboralActualizado(ExperienciaLaboralId entityId, Periodo periodo) {
        super("sofka.experiencia.periodoexperiencialaboralactualizada");
        this.experienciaLaboralId = Objects.requireNonNull(entityId);
        this.periodo = periodo;
    }

    public ExperienciaLaboralId getexperienciaLaboralId() {
        return experienciaLaboralId;
    }

    public Periodo getPeriodo() {
        return periodo;
    }
}
