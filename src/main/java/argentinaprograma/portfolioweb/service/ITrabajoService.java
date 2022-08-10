package argentinaprograma.portfolioweb.service;

import argentinaprograma.portfolioweb.dto.TrabajoDTO;

import java.util.List;

public interface ITrabajoService {

    public List<TrabajoDTO> listarTrabajos();
    public TrabajoDTO obtenerTrabajo(Long id);
    public TrabajoDTO crearTrabajo(TrabajoDTO trabajoDTO);
    public TrabajoDTO actualizarTrabajo(Long id, TrabajoDTO trabajoDTO);
    public void eliminarTrabajo(Long id);
}
