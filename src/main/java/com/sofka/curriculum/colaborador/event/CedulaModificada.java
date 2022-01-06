package com.sofka.curriculum.colaborador.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.colaborador.value.Cedula;

import java.util.Objects;

public class CedulaModificada extends DomainEvent {

    private final Cedula cedula;

    public CedulaModificada(Cedula cedula) {
        super("sofka.colaborador.cedulamodificada");
        this.cedula = Objects.requireNonNull(cedula);
    }

    public Cedula getCedula() {
        return cedula;
    }
}
