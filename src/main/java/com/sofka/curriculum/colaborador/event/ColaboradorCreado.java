package com.sofka.curriculum.colaborador.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.colaborador.value.*;
import com.sofka.curriculum.generics.HojaDeVidaId;
import com.sofka.curriculum.generics.NombreCompleto;

import java.util.Objects;

public class ColaboradorCreado extends DomainEvent {

    private final ColaboradorId colaboradorId;
    private final HojaDeVidaId hojaDeVidaId;
    private final FechaDeNacimiento fechaDeNacimiento;
    private final NombreCompleto nombreCompleto;
    private final Cedula cedula;
    private final Genero genero;
    private final Area area;

    public ColaboradorCreado(ColaboradorId entityId, HojaDeVidaId hojaDeVidaId, FechaDeNacimiento fechaDeNacimiento,
                             NombreCompleto nombreCompleto, Cedula cedula, Genero genero, Area area) {
        super("sofka.colaborador.colaboradorcreado");
        this.colaboradorId = Objects.requireNonNull(entityId);
        this.hojaDeVidaId = Objects.requireNonNull(hojaDeVidaId);
        this.fechaDeNacimiento = Objects.requireNonNull(fechaDeNacimiento);
        this.nombreCompleto = Objects.requireNonNull(nombreCompleto);
        this.cedula = Objects.requireNonNull(cedula);
        this.genero = Objects.requireNonNull(genero);
        this.area = Objects.requireNonNull(area);
    }

    public ColaboradorId getColaboradorId() {
        return colaboradorId;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }

    public FechaDeNacimiento getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public Cedula getCedula() {
        return cedula;
    }

    public Genero getGenero() {
        return genero;
    }

    public Area getArea() {
        return area;
    }
}
