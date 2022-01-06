package com.sofka.curriculum.gestionEducacion.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.generics.Institucion;
import com.sofka.curriculum.generics.Periodo;
import com.sofka.curriculum.gestionEducacion.value.EducacionId;
import com.sofka.curriculum.gestionEducacion.value.Estudio;
import com.sofka.curriculum.gestionEducacion.value.Tipo;


public class NuevaEducacionAgregada extends DomainEvent {

    private final EducacionId educacionId;
    private final Tipo tipo;
    private final Estudio estudio;
    private final Institucion institucion;
    private final Periodo periodo;

    public NuevaEducacionAgregada(EducacionId entityId, Tipo tipo, Estudio estudio, Institucion institucion, Periodo periodo) {
        super("sofka.gestioneducacion.nuevaeducacionagregada");
        this.educacionId = entityId;
        this.tipo = tipo;
        this.estudio = estudio;
        this.institucion = institucion;
        this.periodo = periodo;
    }

    public EducacionId getEducacionId() {
        return educacionId;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Estudio getEstudio() {
        return estudio;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public Periodo getPeriodo() {
        return periodo;
    }
}
