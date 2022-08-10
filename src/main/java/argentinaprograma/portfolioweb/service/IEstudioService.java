package argentinaprograma.portfolioweb.service;

import argentinaprograma.portfolioweb.dto.EstudioDTO;

import java.util.List;

public interface IEstudioService {

    public List<EstudioDTO> listarEstudios();
    public EstudioDTO obtenerEstudio(Long id);
    public EstudioDTO crearEstudio(EstudioDTO estudioDTO);
    public EstudioDTO actualizarEstudio(Long id, EstudioDTO estudioDTO);
    public void eliminarEstudio(Long id);
}
