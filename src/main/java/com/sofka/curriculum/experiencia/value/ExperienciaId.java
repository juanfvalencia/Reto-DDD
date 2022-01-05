package com.sofka.curriculum.experiencia.value;

import co.com.sofka.domain.generic.Identity;

public class ExperienciaId extends Identity {

    public ExperienciaId() {
    }

    public ExperienciaId(String id) {
        super(id);
    }

    public static ExperienciaId of(String id){
        return new ExperienciaId(id);
    }
}
