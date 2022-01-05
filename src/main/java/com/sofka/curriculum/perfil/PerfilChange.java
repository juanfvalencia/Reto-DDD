package com.sofka.curriculum.perfil;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.curriculum.perfil.event.InformacionDeContactoReferenciaActualizada;
import com.sofka.curriculum.perfil.event.NombreCompletoReferenciaActualizado;
import com.sofka.curriculum.perfil.event.NuevaReferenciaAgregada;
import com.sofka.curriculum.perfil.event.PerfilCreado;

public class PerfilChange extends EventChange {

    public PerfilChange(Perfil perfil){

        apply((PerfilCreado event) -> {
            perfil.informacionDeContacto = event.getInformacionDeContacto();
            perfil.fotoDePerfil = event.getFotoDePerfil();
        });

        apply((NuevaReferenciaAgregada event) -> {
            perfil.referencia = new Referencia(
                    event.getReferenciaId(),
                    event.getInformacionDeContacto(),
                    event.getNombreCompleto()
            );
        });

        apply((InformacionDeContactoReferenciaActualizada event) -> {
            perfil.referencia.informacionDeContacto = event.getInformacionDeContacto();
        });

        apply((NombreCompletoReferenciaActualizado event) -> {
            perfil.referencia.nombreCompleto = event.getNombreCompleto();
        });
    }

}
