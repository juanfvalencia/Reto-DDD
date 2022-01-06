package com.sofka.curriculum.gestionEducacion.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.gestionEducacion.value.EducacionId;
import com.sofka.curriculum.gestionEducacion.value.Tipo;

public class TipoEducacionModificado extends DomainEvent {

    private final EducacionId educacionId;
    private final Tipo tipo;

    public TipoEducacionModificado(EducacionId entityId, Tipo tipo){
        super("sofka.gestioneducacion.tipoeducacionmodificado");
        this.educacionId = entityId;
        this.tipo = tipo;
    }

    public EducacionId getEducacionId() {
        return educacionId;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
