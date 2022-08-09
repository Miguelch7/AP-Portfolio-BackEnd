package argentinaprograma.portfolioweb.service;

import argentinaprograma.portfolioweb.model.Proyecto;

import java.util.List;

public interface IProyectoService {

    public List<Proyecto> listarProyectos();
    public Proyecto obtenerProyecto(Long id);
    public Proyecto crearProyecto(Proyecto proyecto);
    public Proyecto actualizarProyecto(Long id, String nombre, String descripcion, String imagen, String linkProyecto, String linkRepositorio);
    public void eliminarProyecto(Long id);
}
