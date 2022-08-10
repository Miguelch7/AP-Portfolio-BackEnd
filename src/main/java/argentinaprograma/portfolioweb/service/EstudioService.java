package argentinaprograma.portfolioweb.service;

import argentinaprograma.portfolioweb.dto.EstudioDTO;
import argentinaprograma.portfolioweb.exception.ResourceNotFoundException;
import argentinaprograma.portfolioweb.model.Estudio;
import argentinaprograma.portfolioweb.repository.EstudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudioService implements IEstudioService {

    @Autowired
    private EstudioRepository estudioRepository;

    // Convertir Entity a DTO
    private EstudioDTO mapToDTO(Estudio estudio) {
        EstudioDTO estudioDTO = new EstudioDTO();

        estudioDTO.setId(estudio.getId());
        estudioDTO.setTitulo(estudio.getTitulo());
        estudioDTO.setInstitucion(estudio.getInstitucion());
        estudioDTO.setDescripcion(estudio.getDescripcion());
        estudioDTO.setImagen(estudio.getImagen());
        estudioDTO.setFechaInicio(estudio.getFechaInicio());
        estudioDTO.setFechaFin(estudio.getFechaFin());

        return estudioDTO;
    }

    // Convertir DTO a Entity
    private Estudio mapToEntity(EstudioDTO estudioDTO) {
        Estudio estudio = new Estudio();

        estudio.setTitulo(estudioDTO.getTitulo());
        estudio.setInstitucion(estudioDTO.getInstitucion());
        estudio.setDescripcion(estudioDTO.getDescripcion());
        estudio.setImagen(estudioDTO.getImagen());
        estudio.setFechaInicio(estudioDTO.getFechaInicio());
        estudio.setFechaFin(estudioDTO.getFechaFin());

        return estudio;
    }

    @Override
    public List<EstudioDTO> listarEstudios() {
        List<Estudio> listadoEstudios = estudioRepository.findAll();

        List<EstudioDTO> listadoEstudiosDTO = listadoEstudios.stream().map(estudio -> mapToDTO(estudio)).collect(Collectors.toList());

        return listadoEstudiosDTO;
    }

    @Override
    public EstudioDTO obtenerEstudio(Long id) {
        Estudio estudio = estudioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Estudio", "id", id));

        return mapToDTO(estudio);
    }

    @Override
    public EstudioDTO crearEstudio(EstudioDTO estudioDTO) {
        Estudio estudio = mapToEntity(estudioDTO);

        Estudio nuevoEstudio = estudioRepository.save(estudio);

        return mapToDTO(nuevoEstudio);
    }

    @Override
    public EstudioDTO actualizarEstudio(Long id, EstudioDTO estudioDTO) {

        Estudio estudio = estudioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Estudio", "id", id));

        estudio.setTitulo(estudioDTO.getTitulo());
        estudio.setInstitucion(estudioDTO.getInstitucion());
        estudio.setDescripcion(estudioDTO.getDescripcion());
        estudio.setImagen(estudioDTO.getImagen());
        estudio.setFechaInicio(estudioDTO.getFechaInicio());
        estudio.setFechaFin(estudioDTO.getFechaFin());

        Estudio estudioActualizado = estudioRepository.save(estudio);

        return mapToDTO(estudioActualizado);
    }

    @Override
    public void eliminarEstudio(Long id) {
        Estudio estudio = estudioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Estudio", "id", id));
        estudioRepository.delete(estudio);
    }

}
