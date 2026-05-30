package com.puelloemiro.tutoria.servicio;

import java.util.List;
import com.puelloemiro.tutoria.dao.TutoriaCrud;
import com.puelloemiro.tutoria.modelo.Tutoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TutoriaServicioImp implements ITutoriaServicio {

    @Autowired
    private TutoriaCrud crudTutoria;

    @Override
    @Transactional(readOnly = true)
    public List<Tutoria> listarTutorias() {
        return (List<Tutoria>) crudTutoria.findAll();
    }

    @Override
    @Transactional
    public void guardar(Tutoria tutoria) {
        crudTutoria.save(tutoria);
    }

    @Override
    @Transactional(readOnly = true)
    public Tutoria localizarTutoria(Tutoria tutoria) {
        // Buscamos por el ID numérico (Long)
        return crudTutoria.findById(tutoria.getId()).orElse(null);
    }

    @Override
    @Transactional
    public void eliminar(Tutoria tutoria) {
        crudTutoria.delete(tutoria);
    }
}
