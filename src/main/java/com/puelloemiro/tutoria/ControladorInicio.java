package com.puelloemiro.tutoria;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import com.puelloemiro.tutoria.modelo.Usuario;
import com.puelloemiro.tutoria.servicio.IUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private IUsuarioServicio userServicio;

    @GetMapping("/")
    public String inicio(Model modelo) {
        List<Usuario> listaUsuarios = (List<Usuario>) userServicio.listarUsuarios();
        modelo.addAttribute("usuarios", listaUsuarios);
        log.info("Ejecutando el controlador Inicio MVC");
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Usuario usuario) {
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Usuario usuario, BindingResult resultado) {
        if (resultado.hasErrors()) {
            log.info("El formulario contiene errores de validación");
            return "modificar"; // Detiene el proceso y devuelve al usuario al formulario
        }

        // Si no hay errores, procede a guardar normalmente
        userServicio.guardar(usuario);
        log.info("Usuario guardado con éxito");
        return "redirect:/";
    }

    @GetMapping("/editar/{cedula}")
    public String editar(Usuario usuario, Model modelo) {
        usuario = userServicio.localizarUsuario(usuario);
        modelo.addAttribute("usuario", usuario);
        return "modificar";
    }

    @GetMapping("/eliminar/{cedula}")
    public String eliminar(Usuario usuario) {
        userServicio.eliminar(usuario);
        log.info("Usuario eliminado correctamente");
        return "redirect:/";
    }
}