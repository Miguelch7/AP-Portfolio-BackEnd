package argentinaprograma.portfolioweb.service;

import argentinaprograma.portfolioweb.model.DetalleUsuario;
import argentinaprograma.portfolioweb.model.Usuario;
import argentinaprograma.portfolioweb.repository.DetalleUsuarioRepository;
import argentinaprograma.portfolioweb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleUsuarioService implements IDetalleUsuarioService {

    @Autowired
    private DetalleUsuarioRepository detalleUsuarioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public DetalleUsuario obtenerDetalleUsuarioPorUsuarioId(Long usuarioId) {
        DetalleUsuario detalleUsuario = detalleUsuarioRepository.findByUsuarioId(usuarioId).orElse(null);

        return detalleUsuario;
    }

    @Override
    public DetalleUsuario crearDetalleUsuario(Long usuarioId, DetalleUsuario detalleUsuario) {

        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);

        if (usuario != null) {

            detalleUsuario.setUsuario(usuario);

            DetalleUsuario detalleUsuarioCreado = detalleUsuarioRepository.save(detalleUsuario);

            return detalleUsuarioCreado;
        }

        return null;
    }

    @Override
    public DetalleUsuario actualizarDetalleUsuario(
        Long usuarioId,
        String nombre,
        String apellido,
        String profesion,
        String descripcion,
        String imagen,
        String direccion,
        String linkCv
    ) {

        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);

        if (usuario == null) {
            return null;
        }

        DetalleUsuario detalleUsuarioBD = detalleUsuarioRepository.findByUsuarioId(usuarioId).orElse(null);

        if (detalleUsuarioBD == null) {
            DetalleUsuario detalleUsuario = new DetalleUsuario();
            detalleUsuario.setNombre(nombre);
            detalleUsuario.setApellido(apellido);
            detalleUsuario.setDescripcion(descripcion);
            detalleUsuario.setProfesion(profesion);
            detalleUsuario.setDireccion(direccion);
            detalleUsuario.setLinkCv(linkCv);
            detalleUsuario.setUsuario(usuario);

            DetalleUsuario detalleUsuarioNuevo = detalleUsuarioRepository.save(detalleUsuario);
            detalleUsuarioNuevo.setUsuario(usuario);

            return detalleUsuarioNuevo;
        }

        detalleUsuarioBD.setNombre(nombre);
        detalleUsuarioBD.setApellido(apellido);
        detalleUsuarioBD.setDescripcion(descripcion);
        detalleUsuarioBD.setProfesion(profesion);
        detalleUsuarioBD.setDireccion(direccion);
        detalleUsuarioBD.setLinkCv(linkCv);

        DetalleUsuario detalleUsuarioActualizado = detalleUsuarioRepository.save(detalleUsuarioBD);

        return detalleUsuarioActualizado;
    }

    @Override
    public void eliminarDetalleUsuario(Long usuarioId) {
        DetalleUsuario detalleUsuario = detalleUsuarioRepository.findByUsuarioId(usuarioId).orElse(null);

        detalleUsuarioRepository.delete(detalleUsuario);
    }
}
