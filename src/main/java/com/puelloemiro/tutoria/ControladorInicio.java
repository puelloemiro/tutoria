package com.puelloemiro.tutoria;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value; // <-- Para leer el properties
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // <-- Importante para el intercambio de datos
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorInicio {

    // Inyectamos el valor configurado en application.properties dentro de la variable 'dato'
    @Value("${index.mensaje}")
    private String dato;

    @GetMapping("/")
    public String inicio(Model modelo) { // <-- Pasamos el objeto 'modelo' como parámetro

        String mensaje = "Saludos desde Spring MVC con paso de información";

        // Agregamos los atributos al modelo (Clave, Valor)
        modelo.addAttribute("mensaje", mensaje);
        modelo.addAttribute("dato", dato);

        log.info("Ejecutando el controlador Inicio MVC con intercambio de datos");
        return "index";
    }
}