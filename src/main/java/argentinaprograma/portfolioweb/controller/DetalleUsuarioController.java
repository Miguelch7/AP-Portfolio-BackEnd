package argentinaprograma.portfolioweb.controller;

import argentinaprograma.portfolioweb.dto.DetalleUsuarioDTO;
import argentinaprograma.portfolioweb.service.IDetalleUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/usuarios")
public class DetalleUsuarioController {

    @Autowired
    private IDetalleUsuarioService iDetalleUsuarioService;

    @GetMapping("/{usuarioId}/detalle")
    public ResponseEntity<DetalleUsuarioDTO> obtenerDetalleUsuario(@PathVariable Long usuarioId) {
        DetalleUsuarioDTO detalleUsuarioDTO = iDetalleUsuarioService.obtenerDetalleUsuarioPorUsuarioId(usuarioId);

        return new ResponseEntity<>(detalleUsuarioDTO, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{usuarioId}/detalle")
    public ResponseEntity<DetalleUsuarioDTO> crearDetalleUsuario(@PathVariable Long usuarioId, @Valid @RequestBody DetalleUsuarioDTO detalleUsuarioDTO) {
        DetalleUsuarioDTO detalleUsuarioCreado = iDetalleUsuarioService.crearDetalleUsuario(usuarioId, detalleUsuarioDTO);

        return new ResponseEntity<>(detalleUsuarioCreado, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{usuarioId}/detalle")
    public ResponseEntity<DetalleUsuarioDTO> actualizarDetalleUsuario(@PathVariable(value = "usuarioId") Long usuarioId, @Valid @RequestBody DetalleUsuarioDTO detalleUsuarioDTO) {
        DetalleUsuarioDTO detalleUsuarioActualizado = iDetalleUsuarioService.actualizarDetalleUsuario(usuarioId, detalleUsuarioDTO);

        return new ResponseEntity<>(detalleUsuarioActualizado, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{usuarioId}/detalle")
    public ResponseEntity<Long> eliminarDetalleUsuario(@PathVariable Long usuarioId) {
        iDetalleUsuarioService.eliminarDetalleUsuario(usuarioId);

        return new ResponseEntity<>(usuarioId, HttpStatus.OK);
    }

}
