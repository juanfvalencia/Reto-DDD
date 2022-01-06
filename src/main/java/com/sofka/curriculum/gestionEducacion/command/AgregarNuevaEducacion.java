package com.sofka.curriculum.gestionEducacion.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.curriculum.generics.Institucion;
import com.sofka.curriculum.generics.Periodo;
import com.sofka.curriculum.gestionEducacion.value.EducacionId;
import com.sofka.curriculum.gestionEducacion.value.Estudio;
import com.sofka.curriculum.gestionEducacion.value.GestionEducacionId;
import com.sofka.curriculum.gestionEducacion.value.Tipo;

public class AgregarNuevaEducacion extends Command {

    private final GestionEducacionId gestionEducacionId;
    private final EducacionId educacionId;
    private final Tipo tipo;
    private final Estudio estudio;
    private final Institucion institucion;
    private final Periodo periodo;

    public AgregarNuevaEducacion(GestionEducacionId gestionEducacionId,
                                 EducacionId entityId, Tipo tipo, Estudio estudio, Institucion institucion, Periodo periodo) {
        this.gestionEducacionId = gestionEducacionId;
        this.educacionId = entityId;
        this.tipo = tipo;
        this.estudio = estudio;
        this.institucion = institucion;
        this.periodo = periodo;
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

    public Estudio getEstudio() {
        return estudio;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public Periodo getPeriodo() {
        return periodo;
    }
}
