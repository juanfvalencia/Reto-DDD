package com.sofka.curriculum.generics;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreCompleto implements ValueObject <NombreCompleto.Properties> {

    private final String nombre;
    private final String apellido;

    public NombreCompleto(String nombre, String apellido) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser nulo");
        this.apellido = Objects.requireNonNull(apellido, "El apellido no puede ser nulo");

        if (this.nombre.isBlank())
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        if (this.apellido.isBlank())
            throw new IllegalArgumentException("El apellido no puede estar vacio");
        if (this.nombre.length()<3 && this.apellido.length()<3)
            throw new IllegalArgumentException("El nombre y el apellido deben tener minino 3 caracteres");
    }

    public interface Properties {
        String nombre();
        String apellido();
    }

    @Override
    public Properties value() {
        return new Properties() {
            @Override
            public String nombre() {
                return nombre   ;
            }

            @Override
            public String apellido() {
                return apellido;
            }
        };
    }
}
