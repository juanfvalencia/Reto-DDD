package com.sofka.curriculum.colaborador.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Cedula implements ValueObject <String> {

    private final String value;

    public Cedula(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("La cedula no puede estar vacía");
        }
        if(this.value.length()>10){
            throw new IllegalArgumentException("La cedula no puede tener más de 10 cartacteres  ");
        }
        if (!this.value.matches("[0-9]*")){
            throw new IllegalArgumentException("La cedula sólo puede incluir números");
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
        Cedula cedula = (Cedula) o;
        return Objects.equals(value, cedula.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
