package com.sofka.curriculum.colaborador.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Area implements ValueObject <String> {

    private final String value;

    public Area(String value) {
        this.value = Objects.requireNonNull(value);

        if(this.value.isBlank())
            throw new IllegalArgumentException("El area no puede estar vacía");
        if(this.value.length()<4 || this.value.length()>25)
            throw new IllegalArgumentException("El area no puede tener menos de 4 caracteres o más de 25 caracteres");
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area = (Area) o;
        return Objects.equals(value, area.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
