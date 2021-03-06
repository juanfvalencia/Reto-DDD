package com.sofka.curriculum.colaborador.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.perfil.value.PerfilId;


public class PerfilAgregado extends DomainEvent {

    private final PerfilId perfilId;

    public PerfilAgregado(PerfilId perfilId) {
        super("sofka.colaborador.perfilagregado");
        this.perfilId = perfilId;
    }

    public PerfilId getPerfilId() {
        return perfilId;
    }
}
