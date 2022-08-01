package argentinaprograma.portfolioweb.service;

import argentinaprograma.portfolioweb.model.DetalleUsuario;

public interface IDetalleUsuarioService {

    public DetalleUsuario obtenerDetalleUsuarioPorUsuarioId(Long usuarioId);
    public DetalleUsuario crearDetalleUsuario(Long usuarioId, DetalleUsuario detalleUsuario);
    public DetalleUsuario actualizarDetalleUsuario(Long usuarioId, String nombre, String apellido, String profesion, String descripcion, String imagen, String direccion, String cv);
    public void eliminarDetalleUsuario(Long usuarioId);
}
