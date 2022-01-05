package com.sofka.curriculum.experiencia;

import co.com.sofka.domain.generic.Entity;
import com.sofka.curriculum.experiencia.value.ConocimientoAdquirido;
import com.sofka.curriculum.experiencia.value.ExperienciaLaboralId;
import com.sofka.curriculum.generics.Institucion;
import com.sofka.curriculum.generics.Periodo;

import java.util.Objects;

public class ExperienciaLaboral extends Entity<ExperienciaLaboralId> {

    protected Institucion institucion;
    protected Periodo periodo;
    protected ConocimientoAdquirido conocimientoAdquirido;

    public ExperienciaLaboral(ExperienciaLaboralId entityId, Institucion institucion, Periodo periodo, ConocimientoAdquirido conocimientoAdquirido) {
        super(entityId);
        this.institucion = institucion;
        this.periodo = periodo;
        this.conocimientoAdquirido = conocimientoAdquirido;
    }

    public void modificarInstitucion(Institucion institucion){
        this.institucion = Objects.requireNonNull(institucion);
    }

    public void modificarPeriodo(Periodo periodo){
        this.periodo = Objects.requireNonNull(periodo);
    }

    public void modificarConocimientoAdquirido(ConocimientoAdquirido conocimientoAdquirido){
        this.conocimientoAdquirido = Objects.requireNonNull(conocimientoAdquirido);
    }

    public Institucion institucion(){
        return institucion;
    }

    public Periodo periodo(){
        return periodo;
    }

    public ConocimientoAdquirido conocimientoAdquirido(){
        return conocimientoAdquirido;
    }
}
