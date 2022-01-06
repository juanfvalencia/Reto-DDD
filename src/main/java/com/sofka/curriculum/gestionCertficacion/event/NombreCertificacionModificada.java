package com.sofka.curriculum.gestionCertficacion.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.gestionCertficacion.value.CertificacionId;
import com.sofka.curriculum.gestionCertficacion.value.Nombre;

import java.util.Objects;

public class NombreCertificacionModificada extends DomainEvent {

    private final CertificacionId certificacionId;
    private final Nombre nombre;

    public NombreCertificacionModificada(CertificacionId entityId, Nombre nombre) {
        super("sofka.gestioncertificacion.nombrecertificacionmodificada");
        this.certificacionId = Objects.requireNonNull(entityId);
        this.nombre = Objects.requireNonNull(nombre);
    }

    public CertificacionId getcertificacionId() {
        return certificacionId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
