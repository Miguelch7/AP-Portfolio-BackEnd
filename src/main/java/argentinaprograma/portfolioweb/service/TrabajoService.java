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
    public Trabajo actualizarTrabajo(Long id, String puesto, String empresa, String descripcion, String imagen, String fecha_inicio, String fecha_fin) {

        Trabajo trabajoActualizado = obtenerTrabajo(id);

        if (trabajoActualizado != null) {
            trabajoActualizado.setPuesto(puesto);
            trabajoActualizado.setEmpresa(empresa);
            trabajoActualizado.setDescripcion(descripcion);
            trabajoActualizado.setImagen(imagen);
            trabajoActualizado.setFecha_inicio(fecha_inicio);
            trabajoActualizado.setFecha_fin(fecha_fin);

            trabajoRepository.save(trabajoActualizado);
        }

        return trabajoActualizado;
    }

    @Override
    public void eliminarTrabajo(Long id) {
        trabajoRepository.deleteById(id);
    }
}
