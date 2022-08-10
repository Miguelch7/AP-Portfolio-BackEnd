package argentinaprograma.portfolioweb.service;

import argentinaprograma.portfolioweb.dto.ProyectoDTO;

import java.util.List;

public interface IProyectoService {

    public List<ProyectoDTO> listarProyectos();
    public ProyectoDTO obtenerProyecto(Long id);
    public ProyectoDTO crearProyecto(ProyectoDTO proyectoDTO);
    public ProyectoDTO actualizarProyecto(Long id, ProyectoDTO proyectoDTO);
    public void eliminarProyecto(Long id);
}
