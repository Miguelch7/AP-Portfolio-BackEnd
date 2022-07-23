package argentinaprograma.portfolioweb.service;

import argentinaprograma.portfolioweb.model.Proyecto;

import java.util.List;

public interface IProyectoService {

    public List<Proyecto> listarProyectos();
    public Proyecto obtenerProyecto(Long id);
    public Proyecto crearProyecto(Proyecto proyecto);
    public Proyecto actualizarProyecto(Long id, String nombre, String descripcion, String imagen, String link_proyecto, String link_repositorio);
    public void eliminarProyecto(Long id);
}
