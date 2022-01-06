package com.sofka.curriculum.colaborador.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.generics.NombreCompleto;

import java.util.Objects;

public class NombreCompletoModificado extends DomainEvent {

    private final NombreCompleto nombreCompleto;

    public NombreCompletoModificado(NombreCompleto nombreCompleto) {
        super("sofka.colaborador.nombrecompletomodificado");
        this.nombreCompleto = Objects.requireNonNull(nombreCompleto);
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
