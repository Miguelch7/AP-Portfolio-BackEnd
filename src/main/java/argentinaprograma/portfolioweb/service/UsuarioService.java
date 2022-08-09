package argentinaprograma.portfolioweb.service;

import argentinaprograma.portfolioweb.model.Rol;
import argentinaprograma.portfolioweb.model.Usuario;
import argentinaprograma.portfolioweb.repository.RolRepository;
import argentinaprograma.portfolioweb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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

        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            return null;
        }

        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

        Rol roles = rolRepository.findByNombre("ROLE_USER").get();
        usuario.setRoles(Collections.singleton(roles));

        Usuario usuarioCreado = usuarioRepository.save(usuario);

        return usuarioCreado;
    }

    @Override
    public Usuario actualizarUsuario(Long id, String email) {
        Usuario usuarioActualizado = this.obtenerUsuario(id);

        if (usuarioActualizado != null) {
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
