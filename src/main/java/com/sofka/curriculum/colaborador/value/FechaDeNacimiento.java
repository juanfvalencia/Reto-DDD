package com.sofka.curriculum.colaborador.value;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class FechaDeNacimiento implements ValueObject <LocalDate> {

    private final LocalDate value;

    public FechaDeNacimiento(String value) {
        this.value = Objects.requireNonNull(formatoFecha(value), "Fecha de nacimiento null");

        if (this.value.isAfter(getfechaActual()))
            throw new IllegalArgumentException("La fecha no es válida");
    }

    protected LocalDate formatoFecha(String fecha) {
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(fecha, formateador);
    }

    protected LocalDate getfechaActual() {
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaActual = LocalDate.now();
        String fechaActualStr = fechaActual.format(formateador);
        return formatoFecha(fechaActualStr);

    }

    @Override
    public LocalDate value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FechaDeNacimiento that = (FechaDeNacimiento) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
