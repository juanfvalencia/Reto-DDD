package com.sofka.curriculum.experiencia.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.experiencia.value.ConocimientoAdquirido;
import com.sofka.curriculum.experiencia.value.ExperienciaLaboralId;

import java.util.Objects;

public class ConocimientoAdquiridoExperienciaLaboralModificada extends DomainEvent {

    private final ExperienciaLaboralId experienciaLaboralId;
    private final ConocimientoAdquirido conocimientoAdquirido;

    public ConocimientoAdquiridoExperienciaLaboralModificada(ExperienciaLaboralId entityId, ConocimientoAdquirido conocimientoAdquirido) {
        super("sofka.experiencia.conocimientoadquiridoexperiencialaboralmodificada");
        this.experienciaLaboralId = entityId;
        this.conocimientoAdquirido = conocimientoAdquirido;
    }

    public ExperienciaLaboralId getexperienciaLaboralId() {
        return experienciaLaboralId;
    }

    public ConocimientoAdquirido getConocimientoAdquirido() {
        return conocimientoAdquirido;
    }
}
