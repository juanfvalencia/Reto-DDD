package com.sofka.curriculum.perfil.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.generics.NombreCompleto;
import com.sofka.curriculum.perfil.value.ReferenciaId;

public class NombreCompletoReferenciaActualizado extends DomainEvent {

    private final ReferenciaId referenciaId;
    private final NombreCompleto nombreCompleto;

    public NombreCompletoReferenciaActualizado(ReferenciaId entityId, NombreCompleto nombreCompleto){
        super("sofka.perfil.nombrecompletoreferenciaactualizado");
        this.referenciaId = entityId;
        this.nombreCompleto = nombreCompleto;
    }

    public ReferenciaId getReferenciaId() {
        return referenciaId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
