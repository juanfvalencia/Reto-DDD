package com.sofka.curriculum.colaborador.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.curriculum.colaborador.value.ColaboradorId;
import com.sofka.curriculum.colaborador.value.Genero;


public class ModificarGenero extends Command {

    private final ColaboradorId colaboradorId;
    private final Genero genero;

    public ModificarGenero(ColaboradorId colaboradorId, Genero genero) {
        this.colaboradorId = colaboradorId;
        this.genero = genero;
    }

    public ColaboradorId getColaboradorId() {
        return colaboradorId;
    }

    public Genero getGenero() {
        return genero;
    }
}
