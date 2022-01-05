package com.sofka.curriculum.perfil.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.curriculum.generics.NombreCompleto;
import com.sofka.curriculum.perfil.value.InformacionDeContacto;
import com.sofka.curriculum.perfil.value.PerfilId;
import com.sofka.curriculum.perfil.value.ReferenciaId;

public class AgregarNuevaReferencia extends Command {

    private final PerfilId perfilId;
    private final ReferenciaId referenciaId;
    private final NombreCompleto nombreCompleto;
    private final InformacionDeContacto informacionDeContacto;

    public AgregarNuevaReferencia(PerfilId perfilId, ReferenciaId entityId,
                                  NombreCompleto nombreCompleto, InformacionDeContacto informacionDeContacto) {

        this.perfilId = perfilId;
        this.referenciaId = entityId;
        this.nombreCompleto = nombreCompleto;
        this.informacionDeContacto = informacionDeContacto;
    }

    public PerfilId getPerfilId() {
        return perfilId;
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
