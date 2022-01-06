package com.sofka.curriculum.usecase.service;

import com.sofka.curriculum.experiencia.value.ExperienciaId;
import com.sofka.curriculum.generics.Periodo;

public interface CalcularPeriodoService {
    Integer calcularPeriodo(ExperienciaId experienciaId, Periodo periodo);
}
