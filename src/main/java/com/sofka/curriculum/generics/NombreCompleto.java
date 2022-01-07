package com.sofka.curriculum.generics;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreCompleto implements ValueObject <String> {

    private final String nombre;
    private final String apellido;

    public NombreCompleto(String nombre, String apellido) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser nulo");
        this.apellido = Objects.requireNonNull(apellido, "El apellido no puede ser nulo");

        if (this.nombre.isBlank() || this.apellido.isBlank())
            throw new IllegalArgumentException("El campo no puede estar vacio");

        if (this.nombre.length()<=3 || this.apellido.length()<=3)
            throw new IllegalArgumentException("El nombre o el apellido deben tener minino 3 caracteres");

        if (this.nombre.length()>=50 || this.apellido.length()>=50)
            throw new IllegalArgumentException("El nombre o el apellido deben tener maximo 50 caracteres");
    }

    @Override
    public String value(){
        return nombre + " " + apellido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NombreCompleto that = (NombreCompleto) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido);
    }
}
