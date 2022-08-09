package argentinaprograma.portfolioweb.service;

import argentinaprograma.portfolioweb.dto.TrabajoDTO;
import argentinaprograma.portfolioweb.exception.ResourceNotFoundException;
import argentinaprograma.portfolioweb.model.Trabajo;
import argentinaprograma.portfolioweb.repository.TrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrabajoService implements ITrabajoService {

    @Autowired
    private TrabajoRepository trabajoRepository;

    // Convertir Entity a DTO
    private TrabajoDTO mapToDTO(Trabajo trabajo) {
        TrabajoDTO trabajoDTO = new TrabajoDTO();

        trabajoDTO.setId(trabajo.getId());
        trabajoDTO.setPuesto(trabajo.getPuesto());
        trabajoDTO.setEmpresa(trabajo.getEmpresa());
        trabajoDTO.setDescripcion(trabajo.getDescripcion());
        trabajoDTO.setImagen(trabajo.getImagen());
        trabajoDTO.setFechaInicio(trabajo.getFechaInicio());
        trabajoDTO.setFechaFin(trabajo.getFechaFin());

        return trabajoDTO;
    }

    // Convertir DTO a Entity
    private Trabajo mapToEntity(TrabajoDTO trabajoDTO) {
        Trabajo trabajo = new Trabajo();

        trabajo.setPuesto(trabajoDTO.getPuesto());
        trabajo.setEmpresa(trabajoDTO.getEmpresa());
        trabajo.setDescripcion(trabajoDTO.getDescripcion());
        trabajo.setImagen(trabajoDTO.getImagen());
        trabajo.setFechaInicio(trabajoDTO.getFechaInicio());
        trabajo.setFechaFin(trabajoDTO.getFechaFin());

        return trabajo;
    }

    @Override
    public List<TrabajoDTO> listarTrabajos() {
        List<Trabajo> listadoTrabajos = trabajoRepository.findAll();

        List<TrabajoDTO> listadoTrabajosDTO = listadoTrabajos.stream().map(trabajo -> mapToDTO(trabajo)).collect(Collectors.toList());

        return listadoTrabajosDTO;
    }

    @Override
    public TrabajoDTO obtenerTrabajo(Long id) {
        Trabajo trabajo = trabajoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Trabajo", "id", id));;

        return mapToDTO(trabajo);
    }

    @Override
    public TrabajoDTO crearTrabajo(TrabajoDTO trabajoDTO) {
        Trabajo trabajo = mapToEntity(trabajoDTO);

        Trabajo nuevoTrabajo = trabajoRepository.save(trabajo);

        return mapToDTO(nuevoTrabajo);
    }

    @Override
    public TrabajoDTO actualizarTrabajo(Long id, String puesto, String empresa, String descripcion, String imagen, String fechaInicio, String fechaFin) {

        Trabajo trabajo = trabajoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Trabajo", "id", id));;

        trabajo.setPuesto(puesto);
        trabajo.setEmpresa(empresa);
        trabajo.setDescripcion(descripcion);
        trabajo.setImagen(imagen);
        trabajo.setFechaInicio(fechaInicio);
        trabajo.setFechaFin(fechaFin);

        Trabajo trabajoActualizado = trabajoRepository.save(trabajo);

        return mapToDTO(trabajoActualizado);
    }

    @Override
    public void eliminarTrabajo(Long id) {
        Trabajo trabajo = trabajoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Trabajo", "id", id));;

        trabajoRepository.delete(trabajo);
    }
}
