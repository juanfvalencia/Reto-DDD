package com.sofka.curriculum.colaborador.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Genero implements ValueObject <String> {

    private final String value;

    public Genero(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank())
            throw new IllegalArgumentException("El genero no puede estar vacio");
        if (!this.value.equals("M")&&!this.value.equals("F"))
            throw new IllegalArgumentException("El genero no puede ser diferente de M o F");
        if (this.value.matches("^[\\p{L} .'-]+$"))
            throw new IllegalArgumentException("El genero no puede tener caracteres especiales, ni numeros");
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genero genero = (Genero) o;
        return Objects.equals(value, genero.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
