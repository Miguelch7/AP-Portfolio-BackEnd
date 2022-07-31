package argentinaprograma.portfolioweb.service;

import argentinaprograma.portfolioweb.model.Usuario;

import java.util.List;

public interface IUsuarioService {

    public List<Usuario> listarUsuarios();
    public Usuario obtenerUsuario(Long id);
    public Usuario crearUsuario(Usuario usuario);
    public Usuario actualizarUsuario(Long id, String nombre, String apellido, String email);
    public void eliminarUsuario(Long id);
}
