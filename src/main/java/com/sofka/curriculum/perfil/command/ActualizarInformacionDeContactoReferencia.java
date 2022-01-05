package com.sofka.curriculum.perfil.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.curriculum.perfil.value.InformacionDeContacto;
import com.sofka.curriculum.perfil.value.PerfilId;
import com.sofka.curriculum.perfil.value.ReferenciaId;

public class ActualizarInformacionDeContactoReferencia extends Command {

    private final PerfilId perfilId;
    private final ReferenciaId referenciaId;
    private final InformacionDeContacto informacionDeContacto;

    public ActualizarInformacionDeContactoReferencia(PerfilId perfilId, ReferenciaId entityId, InformacionDeContacto informacionDeContacto) {
        this.perfilId = perfilId;
        this.referenciaId = entityId;
        this.informacionDeContacto = informacionDeContacto;
    }

    public PerfilId getPerfilId() {
        return perfilId;
    }

    public ReferenciaId getReferenciaId() {
        return referenciaId;
    }

    public InformacionDeContacto getInformacionDeContacto() {
        return informacionDeContacto;
    }
}
