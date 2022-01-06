package com.sofka.curriculum.experiencia;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.curriculum.experiencia.event.ConocimientoAdquiridoExperienciaLaboralModificada;
import com.sofka.curriculum.experiencia.event.ExperienciaCreada;
import com.sofka.curriculum.experiencia.event.NuevaExperienciaLaboralAgregada;
import com.sofka.curriculum.experiencia.event.PeriodoExperinciaLaboralActualizado;

public class ExperienciaChange extends EventChange {

    public ExperienciaChange(Experiencia experiencia){

        apply((ExperienciaCreada event) -> {
            experiencia.hojaDeVidaId = event.getHojaDeVidaId();
        });

        apply((NuevaExperienciaLaboralAgregada event)->{
            experiencia.experienciaLaboral = new ExperienciaLaboral(
                    event.getExperienciaLaboralId(),
                    event.getInstitucion(),
                    event.getPeriodo(),
                    event.getConocimientoAdquirido()
            );
        });

        apply((PeriodoExperinciaLaboralActualizado event)->{
            experiencia.experienciaLaboral.periodo = event.getPeriodo();
        });

        apply((ConocimientoAdquiridoExperienciaLaboralModificada event) -> {
                experiencia.experienciaLaboral.conocimientoAdquirido = event.getConocimientoAdquirido();
        });
    }
}
