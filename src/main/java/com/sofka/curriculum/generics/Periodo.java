package com.sofka.curriculum.generics;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDateTime;
import java.util.Objects;

public class Periodo implements ValueObject <Periodo.Properties> {

    private final LocalDateTime fechaInicio;
    private final LocalDateTime fechaFin;

    public Periodo(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        this.fechaInicio = Objects.requireNonNull(fechaInicio, "La fecha de inicio no puede ser null");
        this.fechaFin = Objects.requireNonNull(fechaFin, "La fecha de fin no puede ser null");

        if (this.fechaInicio.isAfter(this.fechaFin))
            throw new IllegalArgumentException("La fecha de inicio no puede estar despues que a fecha final");

        if (this.fechaFin.isBefore(this.fechaInicio))
            throw new IllegalArgumentException("La fecha de fin no puede estar antes que la fecha inicio");
    }


    public interface Properties{
        LocalDateTime fechaInicio();
        LocalDateTime fechaFin();

    }

   @Override
    public Properties value(){
        return new Properties() {
            @Override
            public LocalDateTime fechaInicio() {
                return null;
            }

            @Override
            public LocalDateTime fechaFin() {
                return null;
            }
        };
   }
}
