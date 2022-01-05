package com.sofka.curriculum.generics;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Institucion implements ValueObject <String> {

    private final String nombre;

    public Institucion(String nombre) {
        this.nombre = Objects.requireNonNull(nombre);

        if(this.nombre.isBlank())
            throw new IllegalArgumentException("El nombre de la institución no puede estar vacío");
        if(this.nombre.length()>35)
            throw new IllegalArgumentException("El nombre de la institución no puede tener más de 35 caracteres");
        if (this.nombre.matches("^[\\p{L} .'-]+$"))
            throw new IllegalArgumentException("El nombre de la institución no puede tener caracteres especiales, ni numeros");
    }

    @Override
    public String value() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Institucion that = (Institucion) o;
        return Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
