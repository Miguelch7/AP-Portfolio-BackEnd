package argentinaprograma.portfolioweb.service;

import argentinaprograma.portfolioweb.dto.DetalleUsuarioDTO;

public interface IDetalleUsuarioService {

    public DetalleUsuarioDTO obtenerDetalleUsuarioPorUsuarioId(Long usuarioId);
    public DetalleUsuarioDTO crearDetalleUsuario(Long usuarioId, DetalleUsuarioDTO detalleUsuarioDTO);
    public DetalleUsuarioDTO actualizarDetalleUsuario(Long usuarioId, DetalleUsuarioDTO detalleUsuarioDTO);
    public void eliminarDetalleUsuario(Long usuarioId);
}
