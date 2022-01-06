package com.sofka.curriculum.gestionEducacion;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.curriculum.gestionEducacion.event.EstudioEducacionModificado;
import com.sofka.curriculum.gestionEducacion.event.GestionEducacionCreado;
import com.sofka.curriculum.gestionEducacion.event.NuevaEducacionAgregada;
import com.sofka.curriculum.gestionEducacion.event.TipoEducacionModificado;

public class GestionEducacionChange extends EventChange {

    public GestionEducacionChange(GestionEducacion gestionEducacion){

        apply((GestionEducacionCreado event) -> {
            gestionEducacion.hojaDeVidaId = event.getHojaDeVidaId();
        });

        apply((NuevaEducacionAgregada event) -> {
            gestionEducacion.educacion = new Educacion(
                    event.getEducacionId(),
                    event.getTipo(),
                    event.getEstudio(),
                    event.getInstitucion(),
                    event.getPeriodo()
            );
        });
        apply((TipoEducacionModificado event) -> {
            gestionEducacion.educacion.tipo = event.getTipo();
        });

        apply((EstudioEducacionModificado event) -> {
            gestionEducacion.educacion.estudio = event.getEstudio();
        });
    }
}
