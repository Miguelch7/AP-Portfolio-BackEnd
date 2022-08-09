package argentinaprograma.portfolioweb.controller;

import argentinaprograma.portfolioweb.model.Usuario;
import argentinaprograma.portfolioweb.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService iUsuarioService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> listadoUsuarios = iUsuarioService.listarUsuarios();

        return new ResponseEntity<>(listadoUsuarios, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable Long id) {
        Usuario usuario = iUsuarioService.obtenerUsuario(id);

        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioCreado = iUsuarioService.crearUsuario(usuario);

        return new ResponseEntity<>(usuarioCreado, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(
            @PathVariable Long id,
            @RequestParam("email") String nuevoEmail
    ) {
        Usuario usuarioActualizado = iUsuarioService.actualizarUsuario(id, nuevoEmail);

        return new ResponseEntity<>(usuarioActualizado, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> eliminarUsuario(@PathVariable Long id) {
        iUsuarioService.eliminarUsuario(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
