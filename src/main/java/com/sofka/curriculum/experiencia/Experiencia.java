package com.sofka.curriculum.experiencia;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.experiencia.event.ConocimientoAdquiridoExperienciaLaboralModificada;
import com.sofka.curriculum.experiencia.event.ExperienciaCreada;
import com.sofka.curriculum.experiencia.event.NuevaExperienciaLaboralAgregada;
import com.sofka.curriculum.experiencia.event.PeriodoExperinciaLaboralActualizado;
import com.sofka.curriculum.experiencia.value.ConocimientoAdquirido;
import com.sofka.curriculum.experiencia.value.ExperienciaId;
import com.sofka.curriculum.experiencia.value.ExperienciaLaboralId;
import com.sofka.curriculum.generics.HojaDeVidaId;
import com.sofka.curriculum.generics.Institucion;
import com.sofka.curriculum.generics.Periodo;

import java.util.List;
import java.util.Objects;

public class Experiencia extends AggregateEvent<ExperienciaId> {

    protected HojaDeVidaId hojaDeVidaId;
    protected ExperienciaLaboral experienciaLaboral;

    public Experiencia(ExperienciaId entityId, HojaDeVidaId hojaDeVidaId) {
        super(entityId);
        appendChange(new ExperienciaCreada(hojaDeVidaId)).apply();
    }

    public Experiencia(ExperienciaId experienciaId) {
        super(experienciaId);
        subscribe(new ExperienciaChange(this));
    }

    public static Experiencia from(ExperienciaId entityId, List<DomainEvent> events){
        var experiencia = new Experiencia(entityId);
        events.forEach(experiencia::applyEvent);
        return experiencia;
    }

    public void agregarExperienciaLaboral(Institucion institucion, Periodo periodo, ConocimientoAdquirido conocimientoAdquirido) {
        var id = new ExperienciaLaboralId();
        Objects.requireNonNull(id);
        Objects.requireNonNull(institucion);
        Objects.requireNonNull(periodo);
        Objects.requireNonNull(conocimientoAdquirido);
        appendChange(new NuevaExperienciaLaboralAgregada(id, institucion, periodo, conocimientoAdquirido)).apply();
    }
    public void modificarExperienciaLaboralConocimientoAdquirido(ExperienciaLaboralId entityId,ConocimientoAdquirido conocimientoAdquirido) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(conocimientoAdquirido);
        appendChange(new ConocimientoAdquiridoExperienciaLaboralModificada(entityId, conocimientoAdquirido)).apply();
    }

    public void actualizarExperienciaLaboralPeriodo(ExperienciaLaboralId entityId, Periodo periodo){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(periodo);
        appendChange(new PeriodoExperinciaLaboralActualizado(entityId, periodo)).apply();
    }

    public HojaDeVidaId hojaDeVidaId(){
        return hojaDeVidaId;
    }

    public ExperienciaLaboral experienciaLaboral(){
        return experienciaLaboral;
    }
}

