package com.sofka.curriculum.gestionEducacion.value;

import co.com.sofka.domain.generic.Identity;

public class GestionEducacionId extends Identity {

    public GestionEducacionId() {
    }

    public GestionEducacionId(String id) {
        super(id);
    }

    public static GestionEducacionId of(String id){
        return new GestionEducacionId(id);
    }
}
