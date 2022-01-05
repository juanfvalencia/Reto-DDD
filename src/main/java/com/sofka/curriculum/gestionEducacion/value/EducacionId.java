package com.sofka.curriculum.gestionEducacion.value;

import co.com.sofka.domain.generic.Identity;

public class EducacionId extends Identity {

    public EducacionId() {
    }

    public EducacionId(String id) {
        super(id);
    }

    public static EducacionId of(String id){
        return new EducacionId(id);
    }
}
