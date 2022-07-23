package argentinaprograma.portfolioweb.service;

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
        Proyecto proyecto = proyectoRepository.findById(id).orElse(null);

        return proyecto;
    }

    @Override
    public Proyecto crearProyecto(Proyecto proyecto) {
        Proyecto nuevoProyecto = proyectoRepository.save(proyecto);

        return nuevoProyecto;
    }

    @Override
    public Proyecto actualizarProyecto(Long id, String nombre, String descripcion, String imagen, String link_proyecto, String link_repositorio) {
        Proyecto proyectoActualizado = obtenerProyecto(id);

        if (proyectoActualizado != null) {
            proyectoActualizado.setNombre(nombre);
            proyectoActualizado.setDescripcion(descripcion);
            proyectoActualizado.setImagen(imagen);
            proyectoActualizado.setLink_proyecto(link_proyecto);
            proyectoActualizado.setLink_repositorio(link_repositorio);

            proyectoRepository.save(proyectoActualizado);
        }

        return proyectoActualizado;
    }

    @Override
    public void eliminarProyecto(Long id) {
        proyectoRepository.deleteById(id);
    }
}
