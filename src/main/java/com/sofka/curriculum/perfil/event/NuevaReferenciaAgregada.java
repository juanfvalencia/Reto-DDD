package com.sofka.curriculum.perfil.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.generics.NombreCompleto;
import com.sofka.curriculum.perfil.value.InformacionDeContacto;
import com.sofka.curriculum.perfil.value.ReferenciaId;

public class NuevaReferenciaAgregada extends DomainEvent {

    private final ReferenciaId referenciaId;
    private final NombreCompleto nombreCompleto;
    private final InformacionDeContacto informacionDeContacto;

    public NuevaReferenciaAgregada(ReferenciaId entityId, NombreCompleto nombreCompleto, InformacionDeContacto informacionDeContacto){
        super("sofka.perfil.nuevareferenciaagregada");
        this.referenciaId = entityId;
        this.nombreCompleto = nombreCompleto;
        this.informacionDeContacto = informacionDeContacto;
    }

    public ReferenciaId getReferenciaId() {
        return referenciaId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public InformacionDeContacto getInformacionDeContacto() {
        return informacionDeContacto;
    }
}
