package com.sofka.curriculum.gestionEducacion.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Estudio implements ValueObject<String> {

    private final String value;

    public Estudio(String value) {
        this.value = Objects.requireNonNull(value, "El Estudio no puede ser null");

        if(this.value.isBlank())
            throw new IllegalArgumentException("El estudio no puede estar vacío");
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estudio estudio = (Estudio) o;
        return Objects.equals(value, estudio.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
