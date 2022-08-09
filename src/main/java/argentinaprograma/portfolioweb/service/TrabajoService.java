package argentinaprograma.portfolioweb.service;

import argentinaprograma.portfolioweb.exception.ResourceNotFoundException;
import argentinaprograma.portfolioweb.model.Skill;
import argentinaprograma.portfolioweb.model.Trabajo;
import argentinaprograma.portfolioweb.repository.TrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrabajoService implements ITrabajoService {

    @Autowired
    private TrabajoRepository trabajoRepository;

    @Override
    public List<Trabajo> listarTrabajos() {
        List<Trabajo> listadoTrabajos = trabajoRepository.findAll();

        return listadoTrabajos;
    }

    @Override
    public Trabajo obtenerTrabajo(Long id) {
        Trabajo trabajo = trabajoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Trabajo", "id", id));;

        return trabajo;
    }

    @Override
    public Trabajo crearTrabajo(Trabajo trabajo) {
        Trabajo nuevoTrabajo = trabajoRepository.save(trabajo);

        return nuevoTrabajo;
    }

    @Override
    public Trabajo actualizarTrabajo(Long id, String puesto, String empresa, String descripcion, String imagen, String fechaInicio, String fechaFin) {

        Trabajo trabajo = trabajoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Trabajo", "id", id));;

        trabajo.setPuesto(puesto);
        trabajo.setEmpresa(empresa);
        trabajo.setDescripcion(descripcion);
        trabajo.setImagen(imagen);
        trabajo.setFechaInicio(fechaInicio);
        trabajo.setFechaFin(fechaFin);

        Trabajo trabajoActualizado = trabajoRepository.save(trabajo);

        return trabajoActualizado;
    }

    @Override
    public void eliminarTrabajo(Long id) {
        Trabajo trabajo = trabajoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Trabajo", "id", id));;

        trabajoRepository.delete(trabajo);
    }
}
