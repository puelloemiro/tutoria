package com.puelloemiro.tutoria.modelo;
import lombok.Data;

@Data
public class Usuario {
    private String cedula;
    private String clave;
    private String nombre;
    private String email;
}
