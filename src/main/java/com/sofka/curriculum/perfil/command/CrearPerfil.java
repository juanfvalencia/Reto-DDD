package com.sofka.curriculum.perfil.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.curriculum.generics.HojaDeVidaId;
import com.sofka.curriculum.generics.NombreCompleto;
import com.sofka.curriculum.perfil.value.InformacionDeContacto;
import com.sofka.curriculum.perfil.value.PerfilId;

public class CrearPerfil extends Command {

    private final PerfilId perfilId;
    private final HojaDeVidaId hojaDeVidaId;
    private final NombreCompleto nombreCompleto;
    private final InformacionDeContacto informacionDeContacto;

    public CrearPerfil(PerfilId entityId, HojaDeVidaId hojaDeVidaId, NombreCompleto nombreCompleto, InformacionDeContacto informacionDeContacto) {

        this.perfilId = entityId;
        this.hojaDeVidaId = hojaDeVidaId;
        this.nombreCompleto = nombreCompleto;
        this.informacionDeContacto = informacionDeContacto;
    }

    public PerfilId getPerfilId() {
        return perfilId;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public InformacionDeContacto getInformacionDeContacto() {
        return informacionDeContacto;
    }
}
