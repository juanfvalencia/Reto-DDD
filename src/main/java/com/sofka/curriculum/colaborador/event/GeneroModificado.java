package com.sofka.curriculum.colaborador.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.colaborador.value.Genero;

import java.util.Objects;

public class GeneroModificado extends DomainEvent {

    private final Genero genero;

    public GeneroModificado(Genero genero) {
        super("sofka.colaborador.generomodificado");
        this.genero = Objects.requireNonNull(genero);
    }

    public Genero getGenero() {
        return genero;
    }
}
