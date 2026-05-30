package com.puelloemiro.tutoria.servicio;

import java.util.List;
import com.puelloemiro.tutoria.modelo.Usuario;

public interface IUsuarioServicio {

    public List<Usuario> listarUsuarios();
    public void guardar(Usuario usuario);
}