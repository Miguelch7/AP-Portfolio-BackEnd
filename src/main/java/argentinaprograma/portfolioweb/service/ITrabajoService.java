package argentinaprograma.portfolioweb.service;

import argentinaprograma.portfolioweb.model.Trabajo;

import java.util.List;

public interface ITrabajoService {

    public List<Trabajo> listarTrabajos();
    public Trabajo obtenerTrabajo(Long id);
    public Trabajo crearTrabajo(Trabajo trabajo);
    public Trabajo actualizarTrabajo(Long id, String puesto, String empresa, String descripcion, String imagen, String fechaInicio, String fechaFin);
    public void eliminarTrabajo(Long id);
}
