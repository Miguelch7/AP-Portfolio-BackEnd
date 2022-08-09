package argentinaprograma.portfolioweb.service;

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
        Trabajo trabajo = trabajoRepository.findById(id).orElse(null);

        return trabajo;
    }

    @Override
    public Trabajo crearTrabajo(Trabajo trabajo) {
        Trabajo nuevoTrabajo = trabajoRepository.save(trabajo);

        return nuevoTrabajo;
    }

    @Override
    public Trabajo actualizarTrabajo(Long id, String puesto, String empresa, String descripcion, String imagen, String fechaInicio, String fechaFin) {

        Trabajo trabajoActualizado = obtenerTrabajo(id);

        if (trabajoActualizado != null) {
            trabajoActualizado.setPuesto(puesto);
            trabajoActualizado.setEmpresa(empresa);
            trabajoActualizado.setDescripcion(descripcion);
            trabajoActualizado.setImagen(imagen);
            trabajoActualizado.setFechaInicio(fechaInicio);
            trabajoActualizado.setFechaFin(fechaFin);

            trabajoRepository.save(trabajoActualizado);
        }

        return trabajoActualizado;
    }

    @Override
    public void eliminarTrabajo(Long id) {
        trabajoRepository.deleteById(id);
    }
}
