package com.sofka.curriculum.perfil.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class FotoDePerfil implements ValueObject <String> {

    private final String value;

    public FotoDePerfil(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank())
            throw new IllegalArgumentException("La foto de perfil no puede estar vacía");
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FotoDePerfil that = (FotoDePerfil) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
