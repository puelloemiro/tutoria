package com.puelloemiro.tutoria.dao;

import com.puelloemiro.tutoria.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;

// Heredamos de CrudRepository especificando <Clase_Modelo, Tipo_de_Dato_de_la_Llave_Primaria>
public interface UsuarioCrud extends CrudRepository<Usuario, String> {
}
