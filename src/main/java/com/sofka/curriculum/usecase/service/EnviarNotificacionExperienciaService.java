package com.sofka.curriculum.usecase.service;

import com.sofka.curriculum.experiencia.value.ExperienciaId;

public interface EnviarNotificacionExperienciaService {
    Boolean enviarExperiencia(String correo, String descripcion, ExperienciaId experienciaId);
}
