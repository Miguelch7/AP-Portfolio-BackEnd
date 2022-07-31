package argentinaprograma.portfolioweb.service;

import argentinaprograma.portfolioweb.model.DetalleUsuario;

import java.util.List;

public interface IDetalleUsuarioService {

    public DetalleUsuario obtenerDetalleUsuarioPorUsuarioId(Long usuarioId);
    public DetalleUsuario crearDetalleUsuario(Long usuarioId, DetalleUsuario detalleUsuario);
    public DetalleUsuario actualizarDetalleUsuario(Long usuarioId, String descripcion, String profesion, String direccion, String cv);
    public void eliminarDetalleUsuario(Long usuarioId);
}
