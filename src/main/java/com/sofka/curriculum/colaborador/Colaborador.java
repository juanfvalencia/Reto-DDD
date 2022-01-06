package com.sofka.curriculum.colaborador;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.colaborador.event.*;
import com.sofka.curriculum.colaborador.value.*;
import com.sofka.curriculum.generics.HojaDeVidaId;
import com.sofka.curriculum.generics.NombreCompleto;
import com.sofka.curriculum.perfil.value.PerfilId;

import java.util.List;
import java.util.Objects;

public class Colaborador extends AggregateEvent<ColaboradorId> {

    protected ColaboradorId colaboradorId;
    protected HojaDeVidaId hojaDeVidaId;
    protected FechaDeNacimiento fechaDeNacimiento;
    protected NombreCompleto nombreCompleto;
    protected Cedula cedula;
    protected Genero genero;
    protected Area area;
    protected PerfilId perfilId;

    public Colaborador(ColaboradorId entityId, ColaboradorId colaboradorId, HojaDeVidaId hojaDeVidaId,
                       FechaDeNacimiento fechaDeNacimiento, NombreCompleto nombreCompleto, Cedula cedula, Genero genero, Area area) {
        super(entityId);
        this.colaboradorId = colaboradorId;
        this.hojaDeVidaId = hojaDeVidaId;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
        this.genero = genero;
        this.area = area;
        appendChange(new ColaboradorCreado(entityId, hojaDeVidaId, fechaDeNacimiento, nombreCompleto, cedula,
                genero, area)).apply();
    }

    private Colaborador(ColaboradorId colaboradorId) {
        super(colaboradorId);
        subscribe(new ColaboradorChange(this));
    }

    public static Colaborador from(ColaboradorId colaboradorId, List<DomainEvent> events){
        var colaborador = new Colaborador(colaboradorId);
        events.forEach(colaborador::applyEvent);
        return colaborador;
    }

    public void agregarPerfil(PerfilId perfilId){
        Objects.requireNonNull(perfilId);
        appendChange(new PerfilAgregado(perfilId)).apply();
    }

    public void modificarFechaDeNacimiento(FechaDeNacimiento fechaDeNacimiento){
        Objects.requireNonNull(fechaDeNacimiento);
        appendChange(new FechaDeNacimientoModificada(fechaDeNacimiento)).apply();
    }
    public void modificarNombreCompleto(NombreCompleto nombreCompleto){
        Objects.requireNonNull(nombreCompleto);
        appendChange(new NombreCompletoModificado(nombreCompleto)).apply();
    }

    public void modificarCedula(Cedula cedula){
        Objects.requireNonNull(cedula);
        appendChange(new CedulaModificada(cedula)).apply();
    }

    public void modificarGenero(Genero genero){
        Objects.requireNonNull(genero);
        appendChange(new GeneroModificado(genero)).apply();
    }

    public void modificarArea(Area area){
        var id = new ColaboradorId();
        Objects.requireNonNull(area);
        appendChange(new AreaModificada(id, area)).apply();
    }

    public HojaDeVidaId hojaDeVidaId() {
        return hojaDeVidaId;
    }

    public FechaDeNacimiento FechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public NombreCompleto NombreCompleto() {
        return nombreCompleto;
    }

    public Cedula Cedula() {
        return cedula;
    }

    public Genero Genero() {
        return genero;
    }

    public Area Area() {
        return area;
    }

    public PerfilId perfilId() {
        return perfilId;
    }
}
