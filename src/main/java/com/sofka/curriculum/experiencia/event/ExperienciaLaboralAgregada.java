package com.sofka.curriculum.experiencia.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.experiencia.value.ConocimientoAdquirido;
import com.sofka.curriculum.experiencia.value.ExperienciaLaboralId;
import com.sofka.curriculum.generics.Institucion;
import com.sofka.curriculum.generics.Periodo;

public class ExperienciaLaboralAgregada extends DomainEvent {

    private final ExperienciaLaboralId experienciaLaboralId;
    private final Institucion institucion;
    private final Periodo periodo;
    private final ConocimientoAdquirido conocimientoAdquirido;

    public ExperienciaLaboralAgregada(ExperienciaLaboralId entityId, Institucion institucion, Periodo periodo, ConocimientoAdquirido conocimientoAdquirido) {
        super("sofka.experiencia.experiencialaboralagregada");
        this.experienciaLaboralId = entityId;
        this.institucion = institucion;
        this.periodo = periodo;
        this.conocimientoAdquirido = conocimientoAdquirido;
    }

    public ExperienciaLaboralId getExperienciaLaboralId() {
        return experienciaLaboralId;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public ConocimientoAdquirido getConocimientoAdquirido() {
        return conocimientoAdquirido;
    }
}
