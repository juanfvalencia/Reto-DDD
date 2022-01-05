package com.sofka.curriculum.experiencia.value;

import co.com.sofka.domain.generic.Identity;

public class ExperienciaLaboralId extends Identity {

    public ExperienciaLaboralId() {
    }

    public ExperienciaLaboralId(String id) {
        super(id);
    }

    public static ExperienciaLaboralId of(String id){
        return new ExperienciaLaboralId(id);
    }
}
