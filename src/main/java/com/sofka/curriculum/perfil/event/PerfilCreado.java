package com.sofka.curriculum.perfil.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.perfil.Perfil;
import com.sofka.curriculum.perfil.value.FotoDePerfil;
import com.sofka.curriculum.perfil.value.InformacionDeContacto;
import com.sofka.curriculum.perfil.value.PerfilId;

import java.util.Objects;

public class PerfilCreado extends DomainEvent {

    private final PerfilId perfilId;
    private final FotoDePerfil fotoDePerfil;
    private final InformacionDeContacto informacionDeContacto;

    public PerfilCreado(PerfilId entityId, FotoDePerfil fotoDePerfil, InformacionDeContacto informacionDeContacto){
        super("sofka.perfil.perfilcreado");
        this.perfilId = entityId;
        this.fotoDePerfil = Objects.requireNonNull(fotoDePerfil);
        this.informacionDeContacto = Objects.requireNonNull(informacionDeContacto);
    }

    public PerfilId getPerfilId() {
        return perfilId;
    }

    public FotoDePerfil getFotoDePerfil() {
        return fotoDePerfil;
    }

    public InformacionDeContacto getInformacionDeContacto() {
        return informacionDeContacto;
    }
}
