package com.puelloemiro.tutoria.servicio;

import java.util.List;
import com.puelloemiro.tutoria.dao.UsuarioCrud;
import com.puelloemiro.tutoria.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServicioImp implements IUsuarioServicio {

    @Autowired
    private UsuarioCrud crudUsuario;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listarUsuarios() {
        return (List<Usuario>) crudUsuario.findAll();
    }

    @Override
    @Transactional
    public void guardar(Usuario usuario) {
        crudUsuario.save(usuario); // El método save() lo provee CrudRepository automáticamente
    }
}
