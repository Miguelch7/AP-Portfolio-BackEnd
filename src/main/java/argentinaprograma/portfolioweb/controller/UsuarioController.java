package argentinaprograma.portfolioweb.controller;

import argentinaprograma.portfolioweb.model.Usuario;
import argentinaprograma.portfolioweb.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UsuarioController {

    @Autowired
    private IUsuarioService iUsuarioService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios() {
        return iUsuarioService.listarUsuarios();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/usuarios/{id}")
    public Usuario obtenerUsuario(@PathVariable Long id) {
        return iUsuarioService.obtenerUsuario(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/usuarios")
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioCreado = iUsuarioService.crearUsuario(usuario);

        return usuarioCreado;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/usuarios/{id}")
    public Usuario actualizarUsuario(
            @PathVariable Long id,
            @RequestParam("email") String nuevoEmail
    ) {
        Usuario usuarioActualizado = iUsuarioService.actualizarUsuario(id, nuevoEmail);

        return usuarioActualizado;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/usuarios/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        iUsuarioService.eliminarUsuario(id);

        return "Usuario eliminado correctamente";
    }
}
