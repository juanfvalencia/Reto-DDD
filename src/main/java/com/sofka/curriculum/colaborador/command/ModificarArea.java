package com.sofka.curriculum.colaborador.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.curriculum.colaborador.value.Area;
import com.sofka.curriculum.colaborador.value.ColaboradorId;


public class ModificarArea extends Command {

    private final ColaboradorId colaboradorId;
    private final Area area;

    public ModificarArea(ColaboradorId colaboradorId, Area area) {
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
