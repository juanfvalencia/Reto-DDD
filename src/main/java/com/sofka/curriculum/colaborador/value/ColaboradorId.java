package com.sofka.curriculum.colaborador.value;

import co.com.sofka.domain.generic.Identity;

public class ColaboradorId extends Identity {

    public ColaboradorId() {
    }

    public ColaboradorId(String id) {
        super(id);
    }

    public static ColaboradorId of(String id){
        return new ColaboradorId(id);
    }
}
