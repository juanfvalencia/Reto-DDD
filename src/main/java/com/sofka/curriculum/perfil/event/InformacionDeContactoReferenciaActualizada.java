package com.sofka.curriculum.perfil.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.perfil.value.InformacionDeContacto;
import com.sofka.curriculum.perfil.value.ReferenciaId;

public class InformacionDeContactoReferenciaActualizada extends DomainEvent {

    private final ReferenciaId referenciaId;
    private final InformacionDeContacto informacionDeContacto;

    public InformacionDeContactoReferenciaActualizada(ReferenciaId entityId, InformacionDeContacto informacionDeContacto){
        super("sofka.perfil.informaciondecontactoreferenciaactualizada");
        this.referenciaId = entityId;
        this.informacionDeContacto = informacionDeContacto;
    }

    public ReferenciaId getReferenciaId() {
        return referenciaId;
    }

    public InformacionDeContacto getInformacionDeContacto() {
        return informacionDeContacto;
    }
}
