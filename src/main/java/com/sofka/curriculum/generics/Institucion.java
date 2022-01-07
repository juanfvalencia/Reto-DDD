package com.sofka.curriculum.generics;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Institucion implements ValueObject <String> {

    private final String nombre;

    public Institucion(String nombre) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser nulo");

        if(this.nombre.isBlank())
            throw new IllegalArgumentException("El nombre de la institución no puede estar vacío");
        if(this.nombre.length()==0 || this.nombre.length()>50)
            throw new IllegalArgumentException("El nombre de la institución no puede tener menos de 5 caracteres o más de 50 caracteres");
    }

    @Override
    public String value() {
        return nombre;
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
