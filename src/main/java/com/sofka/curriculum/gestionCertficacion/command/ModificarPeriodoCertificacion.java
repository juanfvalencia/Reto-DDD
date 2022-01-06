package com.sofka.curriculum.gestionCertficacion.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.curriculum.generics.Periodo;
import com.sofka.curriculum.gestionCertficacion.value.CertificacionId;
import com.sofka.curriculum.gestionCertficacion.value.GestionCertificacionId;

public class ModificarPeriodoCertificacion extends Command {

    private final GestionCertificacionId gestionCertificacionId;
    private final CertificacionId certificacionId;
    private final Periodo periodo;

    public ModificarPeriodoCertificacion(GestionCertificacionId gestionCertificacionId, CertificacionId entityId, Periodo periodo) {
        this.gestionCertificacionId = gestionCertificacionId;
        this.certificacionId = entityId;
        this.periodo = periodo;
    }

    public GestionCertificacionId getGestionCertificacionId() {
        return gestionCertificacionId;
    }

    public CertificacionId getCertificacionId() {
        return certificacionId;
    }

    public Periodo getPeriodo() {
        return periodo;
    }
}
