package com.sofka.curriculum.experiencia.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.curriculum.experiencia.value.ConocimientoAdquirido;
import com.sofka.curriculum.experiencia.value.ExperienciaId;

import java.util.Objects;

public class ModificarExperienciaLaboralConocimientoAdquirido extends Command {

    private final ExperienciaId experienciaId;
    private final ConocimientoAdquirido conocimientoAdquirido;

    public ModificarExperienciaLaboralConocimientoAdquirido(ExperienciaId entityId, ConocimientoAdquirido conocimientoAdquirido) {
        this.experienciaId = Objects.requireNonNull(entityId);
        this.conocimientoAdquirido = Objects.requireNonNull(conocimientoAdquirido);
    }

    public ExperienciaId getExperienciaId() {
        return experienciaId;
    }

    public ConocimientoAdquirido getConocimientoAdquirido() {
        return conocimientoAdquirido;
    }
}
