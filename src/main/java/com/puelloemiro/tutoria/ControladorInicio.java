package com.puelloemiro.tutoria;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import com.puelloemiro.tutoria.modelo.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorInicio {

    @Value("${index.mensaje}")
    private String dato;

    @GetMapping("/")
    public String inicio(Model modelo) {
        String mensaje = "Saludos desde Spring MVC con paso de información";
        modelo.addAttribute("mensaje", mensaje);
        modelo.addAttribute("dato", dato);

        // --- CREAMOS UNA LISTA DE USUARIOS DE PRUEBA ---
        List<Usuario> listaUsuarios = new ArrayList<>();

        Usuario u1 = new Usuario();
        u1.setCedula("1234");
        u1.setClave("Abcd");
        u1.setNombre("JOHN CARLOS ARRIETA ARRIETA");
        u1.setEmail("jarrieta@hotmail.com");
        listaUsuarios.add(u1);

        Usuario u2 = new Usuario();
        u2.setCedula("777");
        u2.setClave("El mejor");
        u2.setNombre("JESUS DE NAZARET");
        u2.setEmail("jesucristo@iglesia.com");
        listaUsuarios.add(u2);

        Usuario u3 = new Usuario();
        u3.setCedula("4321");
        u3.setClave("xyz");
        u3.setNombre("FULANITO DE TAL");
        u3.setEmail("fulanito@gmail.com");
        listaUsuarios.add(u3);

        // Pasamos la lista completa al modelo con la clave "usuarios"
        modelo.addAttribute("usuarios", listaUsuarios);

        log.info("Ejecutando el controlador Inicio MVC con intercambio de LISTA de objetos");
        return "index";
    }
}