package com.sofka.curriculum.colaborador.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.curriculum.colaborador.value.Area;
import com.sofka.curriculum.colaborador.value.ColaboradorId;


public class AreaModificada extends DomainEvent {

    private final ColaboradorId colaboradorId;
    private final Area area;

    public AreaModificada(ColaboradorId colaboradorId, Area area) {
        super("sofka.colaborador.areamodificada");
        this.colaboradorId = colaboradorId;
        this.area = area;
    }

    public ColaboradorId getColaboradorId() {
        return colaboradorId;
    }

    public Area getArea() {
        return area;
    }
}
