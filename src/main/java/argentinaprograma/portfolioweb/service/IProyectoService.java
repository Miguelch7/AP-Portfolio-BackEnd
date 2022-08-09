package argentinaprograma.portfolioweb.service;

import argentinaprograma.portfolioweb.dto.ProyectoDTO;

import java.util.List;

public interface IProyectoService {

    public List<ProyectoDTO> listarProyectos();
    public ProyectoDTO obtenerProyecto(Long id);
    public ProyectoDTO crearProyecto(ProyectoDTO proyectoDTO);
    public ProyectoDTO actualizarProyecto(Long id, String nombre, String descripcion, String imagen, String linkProyecto, String linkRepositorio);
    public void eliminarProyecto(Long id);
}
