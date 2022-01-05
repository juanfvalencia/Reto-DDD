package com.sofka.curriculum.perfil.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class InformacionDeContacto implements ValueObject <String> {

    private final String value;

    public InformacionDeContacto(String value) {
        this.value = Objects.requireNonNull(value);

        if(this.value.isBlank())
            throw new IllegalArgumentException("La información de contacto no pueden estar vacía");
        if(this.value.length()>35)
            throw new IllegalArgumentException("La información de contacto no puede tener más de 35 caracteres");
        if(this.value.length()<10)
            throw new IllegalArgumentException("La información de contacto no puede tener menos de 10 caracteres");
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InformacionDeContacto that = (InformacionDeContacto) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
