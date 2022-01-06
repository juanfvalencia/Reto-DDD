package com.sofka.curriculum.gestionEducacion;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.generics.HojaDeVidaId;
import com.sofka.curriculum.generics.Institucion;
import com.sofka.curriculum.generics.Periodo;
import com.sofka.curriculum.gestionEducacion.event.EstudioEducacionModificado;
import com.sofka.curriculum.gestionEducacion.event.GestionEducacionCreado;
import com.sofka.curriculum.gestionEducacion.event.NuevaEducacionAgregada;
import com.sofka.curriculum.gestionEducacion.event.TipoEducacionModificado;
import com.sofka.curriculum.gestionEducacion.value.EducacionId;
import com.sofka.curriculum.gestionEducacion.value.Estudio;
import com.sofka.curriculum.gestionEducacion.value.GestionEducacionId;
import com.sofka.curriculum.gestionEducacion.value.Tipo;

import java.util.List;
import java.util.Objects;

public class GestionEducacion extends AggregateEvent<GestionEducacionId> {

    protected HojaDeVidaId hojaDeVidaId;
    protected Educacion educacion;

    public GestionEducacion(GestionEducacionId entityId, HojaDeVidaId hojaDeVidaId) {
        super(entityId);
        this.hojaDeVidaId = hojaDeVidaId;
        appendChange(new GestionEducacionCreado(hojaDeVidaId)).apply();
    }

    private GestionEducacion(GestionEducacionId gestionEducacionId){
        super(gestionEducacionId);
        subscribe(new GestionEducacionChange(this));
    }

    public static GestionEducacion from(GestionEducacionId gestionEducacionId, List<DomainEvent> events){
        var gestionEducacion = new GestionEducacion(gestionEducacionId);
        events.forEach(gestionEducacion::applyEvent);
        return gestionEducacion;
    }

    public void agregarNuevaEducacion(Tipo tipo, Estudio estudio, Institucion institucion, Periodo periodo){
        var id = new EducacionId();
        Objects.requireNonNull(tipo);
        Objects.requireNonNull(estudio);
        Objects.requireNonNull(institucion);
        Objects.requireNonNull(periodo);
        appendChange(new NuevaEducacionAgregada(id, tipo, estudio, institucion, periodo)).apply();
    }

    public void modificarEstudioEducacion(EducacionId entityId, Estudio estudio){
        appendChange(new EstudioEducacionModificado(entityId,estudio)).apply();
    }

    public void modificarTipoEducacion(EducacionId entityId, Tipo tipo){
        appendChange(new TipoEducacionModificado(entityId, tipo)).apply();
    }

    public HojaDeVidaId hojaDeVidaId(){
        return hojaDeVidaId;
    }
    public Educacion getEducacion() {
        return educacion;
    }
}
