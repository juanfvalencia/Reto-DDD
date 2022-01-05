package com.sofka.curriculum.gestionCertficacion;

import co.com.sofka.domain.generic.Entity;
import com.sofka.curriculum.generics.Institucion;
import com.sofka.curriculum.generics.Periodo;
import com.sofka.curriculum.gestionCertficacion.value.CertificacionId;
import com.sofka.curriculum.gestionCertficacion.value.Nombre;

import java.util.Objects;

public class Certificacion extends Entity<CertificacionId> {

    protected Nombre nombre;
    protected Institucion institucion;
    protected Periodo periodo;

    public Certificacion(CertificacionId entityId, Nombre nombre, Institucion institucion, Periodo periodo) {
        super(entityId);
        this.nombre = nombre;
        this.institucion = institucion;
        this.periodo = periodo;
    }

    public void modificarNombre(Nombre nombre){
        this.nombre = Objects.requireNonNull(nombre);
    }

    public void modificarInstitucion(Institucion institucion){
        this.institucion = Objects.requireNonNull(institucion);
    }

    public void modificarPeriodo(Periodo periodo){
        this.periodo = Objects.requireNonNull(periodo);
    }

    public Nombre nombre(){
        return nombre;
    }

    public Institucion institucion(){
        return institucion;
    }

    public Periodo periodo(){
        return periodo;
    }
}

