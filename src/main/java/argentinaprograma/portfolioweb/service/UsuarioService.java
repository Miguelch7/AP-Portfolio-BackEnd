package argentinaprograma.portfolioweb.service;

import argentinaprograma.portfolioweb.model.Usuario;
import argentinaprograma.portfolioweb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listarUsuarios() {
        List<Usuario> listadoUsuarios = usuarioRepository.findAll();

        return listadoUsuarios;
    }

    @Override
    public Usuario obtenerUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);

        return usuario;
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        Usuario usuarioCreado = usuarioRepository.save(usuario);

        return usuarioCreado;
    }

    @Override
    public Usuario actualizarUsuario(Long id, String nombre, String apellido, String email) {
        Usuario usuarioActualizado = this.obtenerUsuario(id);

        if (usuarioActualizado != null) {
            usuarioActualizado.setNombre(nombre);
            usuarioActualizado.setApellido(apellido);
            usuarioActualizado.setEmail(email);
            
            usuarioRepository.save(usuarioActualizado);
        }

        return usuarioActualizado;
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
