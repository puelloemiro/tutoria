package com.puelloemiro.tutoria;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import com.puelloemiro.tutoria.dao.UsuarioCrud;
import com.puelloemiro.tutoria.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired // Inyección de dependencias: Spring busca la interfaz y la instancia automáticamente
    private UsuarioCrud crudUsuario;

    @GetMapping("/")
    public String inicio(Model modelo) {

        // Obtenemos todos los registros de la base de datos y los casteamos a una lista de Usuarios
        List<Usuario> listaUsuarios = (List<Usuario>) crudUsuario.findAll();

        // Pasamos la lista real a la vista index.html
        modelo.addAttribute("usuarios", listaUsuarios);

        log.info("Ejecutando el controlador Inicio con listado desde la BD");
        return "index";
    }
}