package com.puelloemiro.tutoria;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j // Esta anotación de Lombok nos permite usar el objeto 'log' automáticamente
public class ControladorInicio {

    @GetMapping("/") // Indica que este método responderá a la raíz de la aplicación (http://localhost:8080)
    public String inicio() {
        log.info("Ejecutando el controlador Inicio"); // Esto imprimirá un mensaje en la consola de NetBeans
        return "index";    }
}