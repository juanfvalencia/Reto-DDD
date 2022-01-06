package com.sofka.curriculum.colaborador.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.colaborador.value.FechaDeNacimiento;


public class FechaDeNacimientoModificada extends DomainEvent {

    private final FechaDeNacimiento fechaDeNacimiento;

    public FechaDeNacimientoModificada(FechaDeNacimiento fechaDeNacimiento) {
        super("sofka.colaborador.fechadenacimientomodificada");
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public FechaDeNacimiento getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }
}
