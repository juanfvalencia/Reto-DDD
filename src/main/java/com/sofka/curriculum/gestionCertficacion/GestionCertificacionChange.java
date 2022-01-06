package com.sofka.curriculum.gestionCertficacion;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.curriculum.gestionCertficacion.event.GestionCertifiacionCreada;
import com.sofka.curriculum.gestionCertficacion.event.NombreCertificacionModificada;
import com.sofka.curriculum.gestionCertficacion.event.NuevaCertificacionAgregada;
import com.sofka.curriculum.gestionCertficacion.event.PeriodoCertificacionModificado;

public class GestionCertificacionChange extends EventChange {

    public GestionCertificacionChange(GestionCertificacion gestionCertificacion){

        apply((GestionCertifiacionCreada event) -> {
            gestionCertificacion.hojaDeVidaId = event.getHojaDeVidaID();
        });

        apply((NuevaCertificacionAgregada event) ->{
            gestionCertificacion.certificacion = new Certificacion(
                    event.getCertificacionId(),
                    event.getNombre(),
                    event.getInstitucion(),
                    event.getPeriodo()
            );
        });

        apply((NombreCertificacionModificada event) -> {
            gestionCertificacion.certificacion.nombre = event.getNombre();
        });

        apply((PeriodoCertificacionModificado event) ->{
            gestionCertificacion.certificacion.periodo = event.getPeriodo();
        });
    }
}
