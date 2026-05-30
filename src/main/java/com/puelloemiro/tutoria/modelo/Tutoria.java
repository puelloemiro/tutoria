package com.puelloemiro.tutoria.modelo;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Table(name = "tutorias_registradas") // Nombre de la tabla en MySQL
@Data
public class Tutoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID Autoincremental en MySQL
    private Long id;

    @NotEmpty(message = "La fecha de registro es obligatoria")
    private String fecha;

    @NotEmpty(message = "La fecha programada es obligatoria")
    private String fechaProgramada;

    @NotEmpty(message = "La hora de inicio es obligatoria")
    private String horaInicio;

    @NotEmpty(message = "La hora de fin es obligatoria")
    private String horaFin;

    @NotEmpty(message = "El nombre del docente es obligatorio")
    private String docente;

    @NotEmpty(message = "El nombre del estudiante es obligatorio")
    private String estudiante;

    @NotEmpty(message = "La universidad es obligatoria")
    private String universidad;

    @NotEmpty(message = "La carrera es obligatoria")
    private String carrera;

    @NotEmpty(message = "La asignatura es obligatoria")
    private String asignatura;

    @NotEmpty(message = "La temática es obligatoria")
    private String tematica;

    private String compromisos; // Opcional, por eso no lleva @NotEmpty

    @NotEmpty(message = "Debe especificar si es Grupal o Individual")
    private String esGrupalOIndividual;

    @NotEmpty(message = "El lugar es obligatorio")
    private String lugar;
}
