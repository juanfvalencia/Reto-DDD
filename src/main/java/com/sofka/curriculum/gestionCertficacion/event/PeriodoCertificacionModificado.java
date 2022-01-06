package com.sofka.curriculum.gestionCertficacion.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.generics.Periodo;
import com.sofka.curriculum.gestionCertficacion.value.CertificacionId;

import java.util.Objects;

public class PeriodoCertificacionModificado extends DomainEvent {

    private final CertificacionId certificacionId;
    private final Periodo periodo;

    public PeriodoCertificacionModificado(CertificacionId entityId, Periodo periodo) {
        super("sofka.gestioncertificacion.periodocertificacionmodificado");
        this.certificacionId = entityId;
        this.periodo = periodo;
    }

    public CertificacionId getcertificacionId() {
        return certificacionId;
    }

    public Periodo getPeriodo() {
        return periodo;
    }
}
