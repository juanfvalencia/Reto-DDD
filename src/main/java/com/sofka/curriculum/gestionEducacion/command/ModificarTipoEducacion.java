package com.sofka.curriculum.gestionEducacion.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.curriculum.gestionEducacion.value.EducacionId;
import com.sofka.curriculum.gestionEducacion.value.GestionEducacionId;
import com.sofka.curriculum.gestionEducacion.value.Tipo;

public class ModificarTipoEducacion extends Command {

    private final GestionEducacionId gestionEducacionId;
    private final EducacionId educacionId;
    private final Tipo tipo;

    public ModificarTipoEducacion(GestionEducacionId gestionEducacionId, EducacionId entityId,Tipo tipo) {
        this.gestionEducacionId = gestionEducacionId;
        this.educacionId = entityId;
        this.tipo = tipo;
    }

    public GestionEducacionId getGestionEducacionId() {
        return gestionEducacionId;
    }

    public EducacionId getEducacionId() {
        return educacionId;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
