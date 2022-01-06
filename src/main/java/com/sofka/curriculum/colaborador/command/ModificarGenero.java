package com.sofka.curriculum.colaborador.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.curriculum.colaborador.value.ColaboradorId;
import com.sofka.curriculum.colaborador.value.Genero;

import java.util.Objects;

public class ModificarGenero extends Command {

    private final ColaboradorId colaboradorId;
    private final Genero genero;

    public ModificarGenero(ColaboradorId colaboradorId, Genero genero) {
        this.colaboradorId = Objects.requireNonNull(colaboradorId);
        this.genero = Objects.requireNonNull(genero);
    }

    public ColaboradorId getColaboradorId() {
        return colaboradorId;
    }

    public Genero getGenero() {
        return genero;
    }
}
