package com.sofka.curriculum.usecase.service;

import com.sofka.curriculum.perfil.value.PerfilId;

public interface EnviarNotificacionPerfilService {
    Boolean enviarPerfil(String correo, String descripcion, PerfilId perfilId);
}
