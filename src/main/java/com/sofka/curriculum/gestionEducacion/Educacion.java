package com.sofka.curriculum.gestionEducacion;

import co.com.sofka.domain.generic.Entity;
import com.sofka.curriculum.generics.Institucion;
import com.sofka.curriculum.generics.Periodo;
import com.sofka.curriculum.gestionEducacion.value.EducacionId;
import com.sofka.curriculum.gestionEducacion.value.Estudio;
import com.sofka.curriculum.gestionEducacion.value.Tipo;

import java.util.Objects;

public class Educacion extends Entity<EducacionId> {

    protected Tipo tipo;
    protected Estudio estudio;
    protected Institucion institucion;
    protected Periodo periodo;

    public Educacion(EducacionId entityId, Tipo tipo, Estudio estudio, Institucion institucion, Periodo periodo) {
        super(entityId);
        this.tipo = tipo;
        this.estudio = estudio;
        this.institucion = institucion;
        this.periodo = periodo;
    }

    public void modificarTipo(Tipo tipo){
      this.tipo = Objects.requireNonNull(tipo);
    }

    public void modificarEstudio(Estudio estudio){
        this.estudio = Objects.requireNonNull(estudio);
    }

    public void modificarInstitucion(Institucion institucion){
        this.institucion = Objects.requireNonNull(institucion);
    }

    public void actualizarPeriodo(Periodo periodo){
        this.periodo = Objects.requireNonNull(periodo);
    }

    public Tipo tipo(){
        return tipo;
    }

    public Estudio estudio(){
        return estudio;
    }

    public Institucion institucion(){
        return institucion;
    }

    public Periodo periodo(){
        return periodo;
    }
}
