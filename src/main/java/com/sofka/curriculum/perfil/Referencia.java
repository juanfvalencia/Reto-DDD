package com.sofka.curriculum.perfil;

import co.com.sofka.domain.generic.Entity;
import com.sofka.curriculum.generics.NombreCompleto;
import com.sofka.curriculum.perfil.value.InformacionDeContacto;
import com.sofka.curriculum.perfil.value.ReferenciaId;

import java.util.Objects;

public class Referencia extends Entity<ReferenciaId> {

    protected InformacionDeContacto informacionDeContacto;
    protected NombreCompleto nombreCompleto;

    public Referencia(ReferenciaId entityId, InformacionDeContacto informacionDeContacto, NombreCompleto nombreCompleto) {
        super(entityId);
        this.informacionDeContacto = Objects.requireNonNull(informacionDeContacto);
        this.nombreCompleto = Objects.requireNonNull(nombreCompleto);
    }

    public void actualizarInformacionDeContacto(InformacionDeContacto informacionDeContacto){
        this.informacionDeContacto = Objects.requireNonNull(informacionDeContacto);
    }

    public void actualizarNombreCompleto(NombreCompleto nombreCompleto){
        this.nombreCompleto = Objects.requireNonNull(nombreCompleto);
    }

    public InformacionDeContacto informacionDeContacto() {
        return informacionDeContacto;
    }

    public NombreCompleto nombreCompleto() {
        return nombreCompleto;
    }
}
