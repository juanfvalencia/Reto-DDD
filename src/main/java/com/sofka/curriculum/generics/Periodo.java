package com.sofka.curriculum.generics;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.util.Objects;

public class Periodo implements ValueObject <Periodo.Properties> {

    private final LocalDate fechaInicio;
    private final LocalDate fechaFin;

    public Periodo(LocalDate fechaInicio, LocalDate fechaFin) {
        this.fechaInicio = Objects.requireNonNull(fechaInicio, "La fecha de inicio no puede ser null");
        this.fechaFin = Objects.requireNonNull(fechaFin, "La fecha de fin no puede ser null");

        if (this.fechaInicio.isAfter(this.fechaFin))
            throw new IllegalArgumentException("La fecha de inicio no puede estar despues que a fecha final");
    }

    public interface Properties{
        LocalDate fechaInicio();
        LocalDate fechaFin();

    }

   @Override
    public Properties value(){
        return new Properties() {
            @Override
            public LocalDate fechaInicio() {
                return null;
            }

            @Override
            public LocalDate fechaFin() {
                return null;
            }
        };
   }
}
