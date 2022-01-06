package com.sofka.curriculum.colaborador.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.colaborador.value.FechaDeNacimiento;

import java.util.Objects;

public class FechaDeNacimientoModificada extends DomainEvent {

    private final FechaDeNacimiento fechaDeNacimiento;

    public FechaDeNacimientoModificada(FechaDeNacimiento fechaDeNacimiento) {
        super("sofka.colaborador.fechadenacimientomodificada");
        this.fechaDeNacimiento = Objects.requireNonNull(fechaDeNacimiento);
    }

    public FechaDeNacimiento getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }
}
