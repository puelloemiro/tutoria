package com.puelloemiro.tutoria;

import java.util.List;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import com.puelloemiro.tutoria.modelo.Tutoria;
import com.puelloemiro.tutoria.servicio.ITutoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorTutoria {

    @Autowired
    private ITutoriaServicio tutoriaServicio;

    @GetMapping("/tutorias")
    public String listarTutorias(Model modelo) {
        List<Tutoria> lista = tutoriaServicio.listarTutorias();
        modelo.addAttribute("tutorias", lista);
        log.info("Ejecutando listado de tutorías");
        return "index_tutoria"; // Apunta a index_tutoria.html
    }

    @GetMapping("/tutorias/agregar")
    public String agregar(Tutoria tutoria) {
        return "modificar_tutoria";
    }

    @PostMapping("/tutorias/guardar")
    public String guardar(@Valid Tutoria tutoria, BindingResult resultado) {
        if (resultado.hasErrors()) {
            log.info("Errores de validación encontrados en el formulario de tutoría");
            return "modificar_tutoria";
        }
        tutoriaServicio.guardar(tutoria);
        log.info("Tutoría guardada exitosamente");
        return "redirect:/tutorias";
    }

    @GetMapping("/tutorias/editar/{id}")
    public String editar(Tutoria tutoria, Model modelo) {
        tutoria = tutoriaServicio.localizarTutoria(tutoria);
        modelo.addAttribute("tutoria", tutoria);
        return "modificar_tutoria";
    }

    @GetMapping("/tutorias/eliminar/{id}")
    public String eliminar(Tutoria tutoria) {
        tutoriaServicio.eliminar(tutoria);
        log.info("Tutoría eliminada");
        return "redirect:/tutorias";
    }
}