package com.sofka.curriculum.gestionCertficacion.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nombre implements ValueObject<String> {

    private final String value;

    public Nombre(String value) {
        this.value = Objects.requireNonNull(value, "El nombre no puede ser null");

        if (this.value.isBlank())
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        if(this.value.length() > 100){
            throw new IllegalArgumentException("El nombre de la certificación no puede contener más de 100 carácteres");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nombre nombre = (Nombre) o;
        return Objects.equals(value, nombre.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
