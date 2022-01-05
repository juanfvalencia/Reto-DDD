package com.sofka.curriculum.perfil.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.curriculum.generics.NombreCompleto;
import com.sofka.curriculum.perfil.value.PerfilId;
import com.sofka.curriculum.perfil.value.ReferenciaId;

public class ActualizarNombreCompletoReferencia extends Command {

    private final PerfilId perfilId;
    private final ReferenciaId referenciaId;
    private final NombreCompleto nombreCompleto;

    public ActualizarNombreCompletoReferencia(PerfilId perfilId, ReferenciaId entityId, NombreCompleto nombreCompleto) {
        this.perfilId = perfilId;
        this.referenciaId = entityId;
        this.nombreCompleto = nombreCompleto;
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
}
