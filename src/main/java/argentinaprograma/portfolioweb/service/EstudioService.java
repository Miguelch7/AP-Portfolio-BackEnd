package argentinaprograma.portfolioweb.service;

import argentinaprograma.portfolioweb.model.Estudio;
import argentinaprograma.portfolioweb.repository.EstudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudioService implements IEstudioService {

    @Autowired
    private EstudioRepository estudioRepository;

    @Override
    public List<Estudio> listarEstudios() {
        List<Estudio> listadoEstudios = estudioRepository.findAll();

        return listadoEstudios;
    }

    @Override
    public Estudio obtenerEstudio(Long id) {
        Estudio estudio = estudioRepository.findById(id).orElse(null);

        return estudio;
    }

    @Override
    public Estudio crearEstudio(Estudio estudio) {
        Estudio nuevoEstudio = estudioRepository.save(estudio);

        return nuevoEstudio;
    }

    @Override
    public Estudio actualizarEstudio(Long id, String titulo, String institucion, String descripcion, String imagen, String fechaInicio, String fechaFin) {

        Estudio estudioActualizado = obtenerEstudio(id);

        if (estudioActualizado != null) {
            estudioActualizado.setTitulo(titulo);
            estudioActualizado.setInstitucion(institucion);
            estudioActualizado.setDescripcion(descripcion);
            estudioActualizado.setImagen(imagen);
            estudioActualizado.setFechaInicio(fechaInicio);
            estudioActualizado.setFechaFin(fechaFin);

            estudioRepository.save(estudioActualizado);
        }

        return estudioActualizado;
    }

    @Override
    public void eliminarEstudio(Long id) {
        estudioRepository.deleteById(id);
    }

}
