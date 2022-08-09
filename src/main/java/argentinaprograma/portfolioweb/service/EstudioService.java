package argentinaprograma.portfolioweb.service;

import argentinaprograma.portfolioweb.exception.ResourceNotFoundException;
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
        Estudio estudio = estudioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Estudio", "id", id));

        return estudio;
    }

    @Override
    public Estudio crearEstudio(Estudio estudio) {
        Estudio nuevoEstudio = estudioRepository.save(estudio);

        return nuevoEstudio;
    }

    @Override
    public Estudio actualizarEstudio(Long id, String titulo, String institucion, String descripcion, String imagen, String fechaInicio, String fechaFin) {

        Estudio estudio = estudioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Estudio", "id", id));

        estudio.setTitulo(titulo);
        estudio.setInstitucion(institucion);
        estudio.setDescripcion(descripcion);
        estudio.setImagen(imagen);
        estudio.setFechaInicio(fechaInicio);
        estudio.setFechaFin(fechaFin);

        Estudio estudioActualizado = estudioRepository.save(estudio);

        return estudioActualizado;
    }

    @Override
    public void eliminarEstudio(Long id) {
        Estudio estudio = estudioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Estudio", "id", id));
        estudioRepository.delete(estudio);
    }

}
