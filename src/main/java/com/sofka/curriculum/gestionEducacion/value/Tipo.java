package com.sofka.curriculum.gestionEducacion.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Tipo implements ValueObject <String> {

    private final String value;

    public Tipo(String value) {
        this.value = Objects.requireNonNull(value, "El tipo no puede ser null");

        if(this.value.isBlank())
            throw new IllegalArgumentException("El tipo no puede estar vacío");
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tipo tipo = (Tipo) o;
        return Objects.equals(value, tipo.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
