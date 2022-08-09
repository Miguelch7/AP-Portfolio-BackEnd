package argentinaprograma.portfolioweb.service;

import argentinaprograma.portfolioweb.dto.DetalleUsuarioDTO;
import argentinaprograma.portfolioweb.exception.ResourceNotFoundException;
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

    // Convertir Entity a DTO
    private DetalleUsuarioDTO mapToDTO(DetalleUsuario detalleUsuario) {
        DetalleUsuarioDTO detalleUsuarioDTO = new DetalleUsuarioDTO();

        detalleUsuarioDTO.setId(detalleUsuario.getId());
        detalleUsuarioDTO.setNombre(detalleUsuario.getNombre());
        detalleUsuarioDTO.setApellido(detalleUsuario.getApellido());
        detalleUsuarioDTO.setProfesion(detalleUsuario.getProfesion());
        detalleUsuarioDTO.setDescripcion(detalleUsuario.getDescripcion());
        detalleUsuarioDTO.setImagen(detalleUsuario.getImagen());
        detalleUsuarioDTO.setDireccion(detalleUsuario.getDireccion());
        detalleUsuarioDTO.setLinkCv(detalleUsuario.getLinkCv());

        return detalleUsuarioDTO;
    }

    // Convertir DTO a Entity
    private DetalleUsuario mapToEntity(DetalleUsuarioDTO detalleUsuarioDTO) {
        DetalleUsuario detalleUsuario = new DetalleUsuario();

        detalleUsuario.setNombre(detalleUsuarioDTO.getNombre());
        detalleUsuario.setApellido(detalleUsuarioDTO.getApellido());
        detalleUsuario.setProfesion(detalleUsuarioDTO.getProfesion());
        detalleUsuario.setDescripcion(detalleUsuarioDTO.getDescripcion());
        detalleUsuario.setImagen(detalleUsuarioDTO.getImagen());
        detalleUsuario.setDireccion(detalleUsuarioDTO.getDireccion());
        detalleUsuario.setLinkCv(detalleUsuarioDTO.getLinkCv());

        return detalleUsuario;
    }

    @Override
    public DetalleUsuarioDTO obtenerDetalleUsuarioPorUsuarioId(Long usuarioId) {
        DetalleUsuario detalleUsuario = detalleUsuarioRepository.findByUsuarioId(usuarioId).orElseThrow(() -> new ResourceNotFoundException("Detalle Usuario", "usuario_id", usuarioId));

        return mapToDTO(detalleUsuario);
    }

    @Override
    public DetalleUsuarioDTO crearDetalleUsuario(Long usuarioId, DetalleUsuarioDTO detalleUsuarioDTO) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", usuarioId));

        DetalleUsuario detalleUsuario = mapToEntity(detalleUsuarioDTO);

        detalleUsuario.setUsuario(usuario);

        DetalleUsuario detalleUsuarioCreado = detalleUsuarioRepository.save(detalleUsuario);

        return mapToDTO(detalleUsuarioCreado);
    }

    @Override
    public DetalleUsuarioDTO actualizarDetalleUsuario(
        Long usuarioId,
        String nombre,
        String apellido,
        String profesion,
        String descripcion,
        String imagen,
        String direccion,
        String linkCv
    ) {

        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", usuarioId));

        DetalleUsuario detalleUsuarioBD = detalleUsuarioRepository.findByUsuarioId(usuarioId).orElseThrow(() -> new ResourceNotFoundException("Detalle Usuario", "usuario_id", usuarioId));

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

            return mapToDTO(detalleUsuarioNuevo);
        }

        detalleUsuarioBD.setNombre(nombre);
        detalleUsuarioBD.setApellido(apellido);
        detalleUsuarioBD.setDescripcion(descripcion);
        detalleUsuarioBD.setProfesion(profesion);
        detalleUsuarioBD.setDireccion(direccion);
        detalleUsuarioBD.setLinkCv(linkCv);

        DetalleUsuario detalleUsuarioActualizado = detalleUsuarioRepository.save(detalleUsuarioBD);

        return mapToDTO(detalleUsuarioActualizado);
    }

    @Override
    public void eliminarDetalleUsuario(Long usuarioId) {
        DetalleUsuario detalleUsuario = detalleUsuarioRepository.findByUsuarioId(usuarioId).orElseThrow(() -> new ResourceNotFoundException("Detalle Usuario", "usuario_id", usuarioId));

        detalleUsuarioRepository.delete(detalleUsuario);
    }
}
