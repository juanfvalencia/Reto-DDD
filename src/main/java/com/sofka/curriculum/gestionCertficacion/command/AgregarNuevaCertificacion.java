package com.sofka.curriculum.gestionCertficacion.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.curriculum.generics.Institucion;
import com.sofka.curriculum.generics.Periodo;
import com.sofka.curriculum.gestionCertficacion.value.CertificacionId;
import com.sofka.curriculum.gestionCertficacion.value.GestionCertificacionId;
import com.sofka.curriculum.gestionCertficacion.value.Nombre;

public class AgregarNuevaCertificacion extends Command {

    private final GestionCertificacionId gestionCertificacionId;
    private final CertificacionId certificacionId;
    private final Nombre nombre;
    private final Institucion institucion;
    private final Periodo periodo;

    public AgregarNuevaCertificacion(GestionCertificacionId gestionCertificacionId, CertificacionId entityId, Nombre nombre, Institucion institucion, Periodo periodo) {
        this.gestionCertificacionId = gestionCertificacionId;
        this.certificacionId = entityId;
        this.nombre = nombre;
        this.institucion = institucion;
        this.periodo = periodo;
    }

    public GestionCertificacionId getGestionCertificacionId() {
        return gestionCertificacionId;
    }

    public CertificacionId getCertificacionId() {
        return certificacionId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public Periodo getPeriodo() {
        return periodo;
    }
}
