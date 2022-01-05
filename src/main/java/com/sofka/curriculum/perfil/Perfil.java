package com.sofka.curriculum.perfil;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.generics.NombreCompleto;
import com.sofka.curriculum.perfil.event.InformacionDeContactoReferenciaActualizada;
import com.sofka.curriculum.perfil.event.NombreCompletoReferenciaActualizado;
import com.sofka.curriculum.perfil.event.NuevaReferenciaAgregada;
import com.sofka.curriculum.perfil.event.PerfilCreado;
import com.sofka.curriculum.perfil.value.FotoDePerfil;
import com.sofka.curriculum.perfil.value.InformacionDeContacto;
import com.sofka.curriculum.perfil.value.PerfilId;
import com.sofka.curriculum.perfil.value.ReferenciaId;

import java.util.List;
import java.util.Objects;

public class Perfil extends AggregateEvent<PerfilId> {

    protected FotoDePerfil fotoDePerfil;
    protected InformacionDeContacto informacionDeContacto;
    protected Referencia referencia;

    public Perfil(PerfilId entityId, FotoDePerfil fotoDePerfil, InformacionDeContacto informacionDeContacto) {
        super(entityId);
        this.fotoDePerfil = fotoDePerfil;
        this.informacionDeContacto = informacionDeContacto;
        appendChange(new PerfilCreado(entityId, fotoDePerfil, informacionDeContacto)).apply();
    }

    private Perfil(PerfilId perfilId){
        super(perfilId);
        subscribe(new PerfilChange(this));
    }

    public static Perfil from(PerfilId perfilId, List<DomainEvent> events){
        var perfil = new Perfil(perfilId);
        events.forEach(perfil::applyEvent);
        return perfil;
    }

    public void agregarNuevaReferencia(NombreCompleto nombreCompleto, InformacionDeContacto informacionDeContacto){
        var id = new ReferenciaId();
        Objects.requireNonNull(nombreCompleto);
        Objects.requireNonNull(informacionDeContacto);
        appendChange(new NuevaReferenciaAgregada(id,nombreCompleto,informacionDeContacto)).apply();
    }

    public void actualizarNombreCompletoReferencia(ReferenciaId entityId, NombreCompleto nombreCompleto){
        appendChange(new NombreCompletoReferenciaActualizado(entityId, nombreCompleto)).apply();
    }

    public void actualizarInformacionDeContactoReferencia(ReferenciaId entityId, InformacionDeContacto informacionDeContacto){
        appendChange(new InformacionDeContactoReferenciaActualizada(entityId, informacionDeContacto)).apply();
    }

    public FotoDePerfil fotoDePerfil(){
        return fotoDePerfil;
    }

    public InformacionDeContacto informacionDeContacto(){
        return informacionDeContacto;
    }

    public Referencia referencia(){
        return referencia;
    }

}
