package com.sofka.curriculum.colaborador.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.curriculum.colaborador.value.ColaboradorId;
import com.sofka.curriculum.generics.NombreCompleto;


public class ModificarNombreCompleto extends Command {

    private final ColaboradorId colaboradorId;
    private final NombreCompleto nombreCompleto;

    public ModificarNombreCompleto(ColaboradorId colaboradorId, NombreCompleto nombreCompleto) {
        this.colaboradorId = colaboradorId;
        this.nombreCompleto = nombreCompleto;
    }

    public ColaboradorId getColaboradorId() {
        return colaboradorId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
