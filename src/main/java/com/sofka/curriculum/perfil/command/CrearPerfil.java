package com.sofka.curriculum.perfil.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.curriculum.generics.NombreCompleto;
import com.sofka.curriculum.perfil.value.InformacionDeContacto;
import com.sofka.curriculum.perfil.value.PerfilId;

public class CrearPerfil extends Command {

    private final PerfilId perfilId;
    private final NombreCompleto nombreCompleto;
    private final InformacionDeContacto informacionDeContacto;

    public CrearPerfil(PerfilId perfilId, NombreCompleto nombreCompleto, InformacionDeContacto informacionDeContacto) {

        this.perfilId = perfilId;
        this.nombreCompleto = nombreCompleto;
        this.informacionDeContacto = informacionDeContacto;
    }

    public PerfilId getPerfilId() {
        return perfilId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public InformacionDeContacto getInformacionDeContacto() {
        return informacionDeContacto;
    }
}
