package argentinaprograma.portfolioweb.service;

import argentinaprograma.portfolioweb.exception.ResourceNotFoundException;
import argentinaprograma.portfolioweb.model.Proyecto;
import argentinaprograma.portfolioweb.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoService implements IProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Override
    public List<Proyecto> listarProyectos() {
        List <Proyecto> listadoProyectos = proyectoRepository.findAll();

        return listadoProyectos;
    }

    @Override
    public Proyecto obtenerProyecto(Long id) {
        Proyecto proyecto = proyectoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Proyecto", "id", id));

        return proyecto;
    }

    @Override
    public Proyecto crearProyecto(Proyecto proyecto) {
        Proyecto nuevoProyecto = proyectoRepository.save(proyecto);

        return nuevoProyecto;
    }

    @Override
    public Proyecto actualizarProyecto(Long id, String nombre, String descripcion, String imagen, String linkProyecto, String linkRepositorio) {
        Proyecto proyecto = proyectoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Proyecto", "id", id));;

        proyecto.setNombre(nombre);
        proyecto.setDescripcion(descripcion);
        proyecto.setImagen(imagen);
        proyecto.setLinkProyecto(linkProyecto);
        proyecto.setLinkRepositorio(linkRepositorio);

        Proyecto proyectoActualizado = proyectoRepository.save(proyecto);

        return proyectoActualizado;
    }

    @Override
    public void eliminarProyecto(Long id) {
        Proyecto proyecto = proyectoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Proyecto", "id", id));;

        proyectoRepository.delete(proyecto);
    }
}
