package com.sofka.curriculum.perfil.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class FotoDePerfil implements ValueObject <String> {

    private final String value;

    public FotoDePerfil(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return null;
    }
}
