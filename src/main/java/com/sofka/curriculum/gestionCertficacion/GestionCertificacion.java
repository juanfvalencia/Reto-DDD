package com.sofka.curriculum.gestionCertficacion;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.generics.HojaDeVidaId;
import com.sofka.curriculum.generics.Institucion;
import com.sofka.curriculum.generics.Periodo;
import com.sofka.curriculum.gestionCertficacion.event.GestionCertifiacionCreada;
import com.sofka.curriculum.gestionCertficacion.event.NombreCertificacionModificada;
import com.sofka.curriculum.gestionCertficacion.event.NuevaCertificacionAgregada;
import com.sofka.curriculum.gestionCertficacion.event.PeriodoCertificacionModificado;
import com.sofka.curriculum.gestionCertficacion.value.CertificacionId;
import com.sofka.curriculum.gestionCertficacion.value.GestionCertificacionId;
import com.sofka.curriculum.gestionCertficacion.value.Nombre;

import java.util.List;
import java.util.Objects;

public class GestionCertificacion extends AggregateEvent<GestionCertificacionId> {

    protected HojaDeVidaId hojaDeVidaId;
    protected Certificacion certificacion;

    public GestionCertificacion(GestionCertificacionId entityId, HojaDeVidaId hojaDeVidaId) {
        super(entityId);
        appendChange(new GestionCertifiacionCreada(hojaDeVidaId)).apply();
    }

    private GestionCertificacion(GestionCertificacionId gestionCertificacionId) {
        super(gestionCertificacionId);
        subscribe(new GestionCertificacionChange(this));
    }

    public static GestionCertificacion from(GestionCertificacionId gestionCertificacionId, List<DomainEvent> events){
        var gestionCertificacion = new GestionCertificacion(gestionCertificacionId);
        events.forEach(gestionCertificacion::applyEvent);
        return gestionCertificacion;
    }

    public void agregarNuevaCertificacion(Nombre nombre, Institucion institucion, Periodo periodo){
        var id = new CertificacionId();
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(institucion);
        Objects.requireNonNull(periodo);
        appendChange(new NuevaCertificacionAgregada(id, nombre, institucion, periodo)).apply();
    }

    public void modificarNombreCertificacion(CertificacionId entityId, Nombre nombre){
        appendChange(new NombreCertificacionModificada(entityId, nombre)).apply();
    }

    public void modificarPeriodoCertificacion(CertificacionId entityId, Periodo periodo){
        appendChange(new PeriodoCertificacionModificado(entityId, periodo)).apply();
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }

    public Certificacion getCertificacion() {
        return certificacion;
    }
}
