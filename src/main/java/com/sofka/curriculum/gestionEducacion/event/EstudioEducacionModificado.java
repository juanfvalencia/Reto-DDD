package com.sofka.curriculum.gestionEducacion.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.gestionEducacion.value.EducacionId;
import com.sofka.curriculum.gestionEducacion.value.Estudio;

public class EstudioEducacionModificado extends DomainEvent {

    private final EducacionId educacionId;
    private final Estudio estudio;

    public EstudioEducacionModificado(EducacionId entityId, Estudio estudio){
        super("sofka.gestioneducacion.estudioeducacionmodificado");
        this.educacionId = entityId;
        this.estudio = estudio;
    }

    public EducacionId getEducacionId() {
        return educacionId;
    }

    public Estudio getEstudio() {
        return estudio;
    }
}
