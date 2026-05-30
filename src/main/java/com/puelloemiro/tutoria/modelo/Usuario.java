package com.puelloemiro.tutoria.modelo;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "usuarios") // Nombre exacto de la tabla en MySQL
@Data
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id // Indica que la cédula es la Llave Primaria (Primary Key)
    private String cedula;

    private String clave;
    private String nombre;
    private String email;
}