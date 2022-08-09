package argentinaprograma.portfolioweb.service;

import argentinaprograma.portfolioweb.dto.DetalleUsuarioDTO;

public interface IDetalleUsuarioService {

    public DetalleUsuarioDTO obtenerDetalleUsuarioPorUsuarioId(Long usuarioId);
    public DetalleUsuarioDTO crearDetalleUsuario(Long usuarioId, DetalleUsuarioDTO detalleUsuarioDTO);
    public DetalleUsuarioDTO actualizarDetalleUsuario(Long usuarioId, String nombre, String apellido, String profesion, String descripcion, String imagen, String direccion, String linkCv);
    public void eliminarDetalleUsuario(Long usuarioId);
}
