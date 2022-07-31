package argentinaprograma.portfolioweb.controller;

import argentinaprograma.portfolioweb.model.DetalleUsuario;
import argentinaprograma.portfolioweb.model.Usuario;
import argentinaprograma.portfolioweb.service.DetalleUsuarioService;
import argentinaprograma.portfolioweb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class DetalleUsuarioController {

    @Autowired
    private DetalleUsuarioService detalleUsuarioService;

    @GetMapping("/usuarios/{usuarioId}/detalle")
    private DetalleUsuario obtenerDetalleUsuario(@PathVariable Long usuarioId) {
        DetalleUsuario detalleUsuario = detalleUsuarioService.obtenerDetalleUsuarioPorUsuarioId(usuarioId);

        return detalleUsuario;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/usuarios/{usuarioId}/detalle")
    private DetalleUsuario crearDetalleUsuario(@PathVariable Long usuarioId, @RequestBody DetalleUsuario detalleUsuario) {
        DetalleUsuario detalleUsuarioCreado = detalleUsuarioService.crearDetalleUsuario(usuarioId, detalleUsuario);

        return detalleUsuarioCreado;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/usuarios/{usuarioId}/detalle")
    private DetalleUsuario actualizarDetalleUsuario(
        @PathVariable(value = "usuarioId") Long usuarioId,
        @RequestParam("descripcion") String descripcion,
        @RequestParam("profesion") String profesion,
        @RequestParam("direccion") String direccion,
        @RequestParam("cv") String cv
    ) {
        DetalleUsuario detalleUsuarioActualizado = detalleUsuarioService.actualizarDetalleUsuario(usuarioId, descripcion, profesion, direccion, cv);

        return detalleUsuarioActualizado;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/usuarios/{usuarioId}/detalle")
    private String eliminarDetalleUsuario(@PathVariable Long usuarioId) {
        detalleUsuarioService.eliminarDetalleUsuario(usuarioId);

        return "El detalle de usuario se eliminó correctamente";
    }

}
