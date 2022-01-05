package com.sofka.curriculum.experiencia.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ConocimientoAdquirido implements ValueObject <String> {

    private final String value;

    public ConocimientoAdquirido(String value) {
        this.value = Objects.requireNonNull(value, "El conocimiento adquirido no puden ser null");

        if(this.value.isBlank())
            throw new IllegalArgumentException("El conocimiento adquirido no puede estar vacío");
        if(this.value.length()>50)
            throw new IllegalArgumentException("El conocimiento adquirido no puede tener más de 50 caracteres");
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConocimientoAdquirido that = (ConocimientoAdquirido) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
