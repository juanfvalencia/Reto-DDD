package com.sofka.curriculum.experiencia.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.curriculum.experiencia.value.ConocimientoAdquirido;
import com.sofka.curriculum.experiencia.value.ExperienciaId;
import com.sofka.curriculum.experiencia.value.ExperienciaLaboralId;
import com.sofka.curriculum.generics.Institucion;
import com.sofka.curriculum.generics.Periodo;

public class AgregarNuevaExpericiaLaboral extends Command {

    private final ExperienciaId experienciaId;
    private final ExperienciaLaboralId experienciaLaboralId;
    private final Periodo periodo;
    private final Institucion institucion;
    private final ConocimientoAdquirido conocimientoAdquirido;

    public AgregarNuevaExpericiaLaboral(ExperienciaId experienciaId, ExperienciaLaboralId entityId, Periodo periodo, Institucion institucion, ConocimientoAdquirido conocimientoAdquirido) {
        this.experienciaId = experienciaId;
        this.experienciaLaboralId = entityId;
        this.periodo = periodo;
        this.institucion = institucion;
        this.conocimientoAdquirido = conocimientoAdquirido;
    }

    public ConocimientoAdquirido getConocimientoAdquirido() {
        return conocimientoAdquirido;
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

    public Institucion getInstitucion() {
        return institucion;
    }

}
