package argentinaprograma.portfolioweb.service;

import argentinaprograma.portfolioweb.dto.EstudioDTO;

import java.util.List;

public interface IEstudioService {

    public List<EstudioDTO> listarEstudios();
    public EstudioDTO obtenerEstudio(Long id);
    public EstudioDTO crearEstudio(EstudioDTO estudioDTO);
    public EstudioDTO actualizarEstudio(Long id, String titulo, String institucion, String descripcion, String imagen, String fechaInicio, String fechaFin);
    public void eliminarEstudio(Long id);
}
