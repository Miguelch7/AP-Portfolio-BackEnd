package argentinaprograma.portfolioweb.controller;

import argentinaprograma.portfolioweb.model.DetalleUsuario;
import argentinaprograma.portfolioweb.service.IDetalleUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/usuarios")
public class DetalleUsuarioController {

    @Autowired
    private IDetalleUsuarioService iDetalleUsuarioService;

    @GetMapping("/{usuarioId}/detalle")
    public ResponseEntity<DetalleUsuario> obtenerDetalleUsuario(@PathVariable Long usuarioId) {
        DetalleUsuario detalleUsuario = iDetalleUsuarioService.obtenerDetalleUsuarioPorUsuarioId(usuarioId);

        return new ResponseEntity<>(detalleUsuario, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{usuarioId}/detalle")
    public ResponseEntity<DetalleUsuario> crearDetalleUsuario(@PathVariable Long usuarioId, @RequestBody DetalleUsuario detalleUsuario) {
        DetalleUsuario detalleUsuarioCreado = iDetalleUsuarioService.crearDetalleUsuario(usuarioId, detalleUsuario);

        return new ResponseEntity<>(detalleUsuarioCreado, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{usuarioId}/detalle")
    public ResponseEntity<DetalleUsuario> actualizarDetalleUsuario(
        @PathVariable(value = "usuarioId") Long usuarioId,
        @RequestParam("nombre") String nombre,
        @RequestParam("apellido") String apellido,
        @RequestParam("profesion") String profesion,
        @RequestParam("descripcion") String descripcion,
        @RequestParam("imagen") String imagen,
        @RequestParam("direccion") String direccion,
        @RequestParam("linkCv") String linkCv
    ) {
        DetalleUsuario detalleUsuarioActualizado = iDetalleUsuarioService.actualizarDetalleUsuario(usuarioId, nombre, apellido, profesion, descripcion, imagen, direccion, linkCv);

        return new ResponseEntity<>(detalleUsuarioActualizado, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{usuarioId}/detalle")
    public ResponseEntity<Long> eliminarDetalleUsuario(@PathVariable Long usuarioId) {
        iDetalleUsuarioService.eliminarDetalleUsuario(usuarioId);

        return new ResponseEntity<>(usuarioId, HttpStatus.OK);
    }

}
