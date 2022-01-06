package com.sofka.curriculum.gestionCertficacion.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.curriculum.gestionCertficacion.value.CertificacionId;
import com.sofka.curriculum.gestionCertficacion.value.GestionCertificacionId;
import com.sofka.curriculum.gestionCertficacion.value.Nombre;

public class ModificarNombreCertificacion extends Command {

    private final GestionCertificacionId gestionCertificacionId;
    private final CertificacionId certificacionId;
    private final Nombre nombre;

    public ModificarNombreCertificacion(GestionCertificacionId gestionCertificacionId, CertificacionId entityId, Nombre nombre) {
        this.gestionCertificacionId = gestionCertificacionId;
        this.certificacionId = entityId;
        this.nombre = nombre;
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
}
