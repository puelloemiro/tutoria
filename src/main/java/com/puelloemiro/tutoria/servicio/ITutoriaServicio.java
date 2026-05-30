package com.puelloemiro.tutoria.servicio;

import java.util.List;
import com.puelloemiro.tutoria.modelo.Tutoria;

public interface ITutoriaServicio {

    public List<Tutoria> listarTutorias();

    public void guardar(Tutoria tutoria);

    public Tutoria localizarTutoria(Tutoria tutoria);

    public void eliminar(Tutoria tutoria);
}
