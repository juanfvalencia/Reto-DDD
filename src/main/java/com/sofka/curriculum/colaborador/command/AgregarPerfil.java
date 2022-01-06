package com.sofka.curriculum.colaborador.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.curriculum.colaborador.value.ColaboradorId;
import com.sofka.curriculum.perfil.value.PerfilId;

import java.util.Objects;

public class AgregarPerfil extends Command {

    private final ColaboradorId colaboradorId;
    private final PerfilId perfilId;

    public AgregarPerfil(ColaboradorId colaboradorID, PerfilId perfilId) {
        this.colaboradorId = Objects.requireNonNull(colaboradorID);
        this.perfilId = Objects.requireNonNull(perfilId);
    }

    public ColaboradorId getColaboradorId() {
        return colaboradorId;
    }

    public PerfilId getPerfilId() {
        return perfilId;
    }
}
