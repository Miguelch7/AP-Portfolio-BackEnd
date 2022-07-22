package argentinaprograma.portfolioweb.service;

import argentinaprograma.portfolioweb.model.Estudio;

import java.util.List;

public interface IEstudioService {

    public List<Estudio> listarEstudios();
    public Estudio obtenerEstudio(Long id);
    public Estudio crearEstudio(Estudio estudio);
    public Estudio actualizarEstudio(Long id, String titulo, String institucion, String descripcion, String imagen, String fecha_inicio, String fecha_fin);
    public void eliminarEstudio(Long id);
}
