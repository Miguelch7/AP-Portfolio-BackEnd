package argentinaprograma.portfolioweb.controller;

import argentinaprograma.portfolioweb.model.DetalleUsuario;
import argentinaprograma.portfolioweb.service.IDetalleUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class DetalleUsuarioController {

    @Autowired
    private IDetalleUsuarioService iDetalleUsuarioService;

    @GetMapping("/usuarios/{usuarioId}/detalle")
    public DetalleUsuario obtenerDetalleUsuario(@PathVariable Long usuarioId) {
        DetalleUsuario detalleUsuario = iDetalleUsuarioService.obtenerDetalleUsuarioPorUsuarioId(usuarioId);

        return detalleUsuario;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/usuarios/{usuarioId}/detalle")
    public DetalleUsuario crearDetalleUsuario(@PathVariable Long usuarioId, @RequestBody DetalleUsuario detalleUsuario) {
        DetalleUsuario detalleUsuarioCreado = iDetalleUsuarioService.crearDetalleUsuario(usuarioId, detalleUsuario);

        return detalleUsuarioCreado;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/usuarios/{usuarioId}/detalle")
    public DetalleUsuario actualizarDetalleUsuario(
        @PathVariable(value = "usuarioId") Long usuarioId,
        @RequestParam("nombre") String nombre,
        @RequestParam("apellido") String apellido,
        @RequestParam("profesion") String profesion,
        @RequestParam("descripcion") String descripcion,
        @RequestParam("imagen") String imagen,
        @RequestParam("direccion") String direccion,
        @RequestParam("cv") String cv
    ) {
        DetalleUsuario detalleUsuarioActualizado = iDetalleUsuarioService.actualizarDetalleUsuario(usuarioId, nombre, apellido, profesion, descripcion, imagen, direccion, cv);

        return detalleUsuarioActualizado;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/usuarios/{usuarioId}/detalle")
    public String eliminarDetalleUsuario(@PathVariable Long usuarioId) {
        iDetalleUsuarioService.eliminarDetalleUsuario(usuarioId);

        return "El detalle de usuario se eliminó correctamente";
    }

}
