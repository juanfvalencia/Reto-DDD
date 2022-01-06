package com.sofka.curriculum.gestionCertficacion.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.generics.Institucion;
import com.sofka.curriculum.generics.Periodo;
import com.sofka.curriculum.gestionCertficacion.value.CertificacionId;
import com.sofka.curriculum.gestionCertficacion.value.Nombre;

import java.util.Objects;

public class NuevaCertificacionAgregada extends DomainEvent {

    private final CertificacionId certificacionId;
    private final Nombre nombre;
    private final Institucion institucion;
    private final Periodo periodo;

    public NuevaCertificacionAgregada(CertificacionId certificacionID, Nombre nombre, Institucion institucion, Periodo periodo) {
        super("sofka.gestioncertificacion.nuevacertificacionagregada");
        this.certificacionId = certificacionID;
        this.nombre = nombre;
        this.institucion = institucion;
        this.periodo = periodo;
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
