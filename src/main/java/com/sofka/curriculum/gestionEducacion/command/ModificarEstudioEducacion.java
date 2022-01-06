package com.sofka.curriculum.gestionEducacion.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.curriculum.gestionEducacion.value.EducacionId;
import com.sofka.curriculum.gestionEducacion.value.Estudio;
import com.sofka.curriculum.gestionEducacion.value.GestionEducacionId;

public class ModificarEstudioEducacion extends Command {

    private final GestionEducacionId gestionEducacionId;
    private final EducacionId educacionId;
    private final Estudio estudio;

    public ModificarEstudioEducacion(GestionEducacionId gestionEducacionId, Estudio estudio) {
        this.gestionEducacionId = gestionEducacionId;
        this.educacionId = entityId;
        this.estudio = estudio;
    }

    public GestionEducacionId getGestionEducacionId() {
        return gestionEducacionId;
    }

    public EducacionId getEducacionId() {
        return educacionId;
    }

    public Estudio getEstudio() {
        return estudio;
    }
}
