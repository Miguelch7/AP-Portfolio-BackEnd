package argentinaprograma.portfolioweb.service;

import argentinaprograma.portfolioweb.dto.ProyectoDTO;
import argentinaprograma.portfolioweb.exception.ResourceNotFoundException;
import argentinaprograma.portfolioweb.model.Proyecto;
import argentinaprograma.portfolioweb.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProyectoService implements IProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;

    // Convertir Entity a DTO
    private ProyectoDTO mapToDTO(Proyecto proyecto) {
        ProyectoDTO proyectoDTO = new ProyectoDTO();

        proyectoDTO.setId(proyecto.getId());
        proyectoDTO.setNombre(proyecto.getNombre());
        proyectoDTO.setDescripcion(proyecto.getDescripcion());
        proyectoDTO.setImagen(proyecto.getImagen());
        proyectoDTO.setLinkProyecto(proyecto.getLinkProyecto());
        proyectoDTO.setLinkRepositorio(proyecto.getLinkRepositorio());

        return proyectoDTO;
    }

    // Convertir DTO a Entity
    private Proyecto mapToEntity(ProyectoDTO proyectoDTO) {
        Proyecto proyecto = new Proyecto();

        proyecto.setNombre(proyectoDTO.getNombre());
        proyecto.setDescripcion(proyectoDTO.getDescripcion());
        proyecto.setImagen(proyectoDTO.getImagen());
        proyecto.setLinkProyecto(proyectoDTO.getLinkProyecto());
        proyecto.setLinkRepositorio(proyectoDTO.getLinkRepositorio());

        return proyecto;
    }

    @Override
    public List<ProyectoDTO> listarProyectos() {
        List <Proyecto> listadoProyectos = proyectoRepository.findAll();

        List<ProyectoDTO> listadoProyectosDTO = listadoProyectos.stream().map(proyecto -> mapToDTO(proyecto)).collect(Collectors.toList());

        return listadoProyectosDTO;
    }

    @Override
    public ProyectoDTO obtenerProyecto(Long id) {
        Proyecto proyecto = proyectoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Proyecto", "id", id));

        return mapToDTO(proyecto);
    }

    @Override
    public ProyectoDTO crearProyecto(ProyectoDTO proyectoDTO) {
        Proyecto proyecto = mapToEntity(proyectoDTO);

        Proyecto nuevoProyecto = proyectoRepository.save(proyecto);

        return mapToDTO(nuevoProyecto);
    }

    @Override
    public ProyectoDTO actualizarProyecto(Long id, String nombre, String descripcion, String imagen, String linkProyecto, String linkRepositorio) {
        Proyecto proyecto = proyectoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Proyecto", "id", id));;

        proyecto.setNombre(nombre);
        proyecto.setDescripcion(descripcion);
        proyecto.setImagen(imagen);
        proyecto.setLinkProyecto(linkProyecto);
        proyecto.setLinkRepositorio(linkRepositorio);

        Proyecto proyectoActualizado = proyectoRepository.save(proyecto);

        return mapToDTO(proyectoActualizado);
    }

    @Override
    public void eliminarProyecto(Long id) {
        Proyecto proyecto = proyectoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Proyecto", "id", id));;

        proyectoRepository.delete(proyecto);
    }
}
