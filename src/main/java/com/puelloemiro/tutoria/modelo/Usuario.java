package com.puelloemiro.tutoria.modelo;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotEmpty(message = "La cédula no puede estar vacía")
    private String cedula;

    @NotEmpty(message = "La clave no puede estar vacía")
    @Size(min = 4, message = "La clave debe tener al menos 4 caracteres")
    private String clave;

    @NotEmpty(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotEmpty(message = "El correo no puede estar vacío")
    @Email(message = "Por favor, introduce un correo electrónico válido")
    private String email;
}