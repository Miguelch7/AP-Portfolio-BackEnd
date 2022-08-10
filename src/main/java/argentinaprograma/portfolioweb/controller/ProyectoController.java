package argentinaprograma.portfolioweb.controller;

import argentinaprograma.portfolioweb.dto.ProyectoDTO;
import argentinaprograma.portfolioweb.service.IProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/proyectos")
public class ProyectoController {

    @Autowired
    private IProyectoService iProyectoService;

    @GetMapping
    public ResponseEntity<List<ProyectoDTO>> listarProyectos() {
        List<ProyectoDTO> listadoProyectos = iProyectoService.listarProyectos();

        return new ResponseEntity<>(listadoProyectos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProyectoDTO> obtenerProyecto(@PathVariable Long id) {
        ProyectoDTO proyecto = iProyectoService.obtenerProyecto(id);

        return new ResponseEntity<>(proyecto, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ProyectoDTO> crearProyecto(@Valid @RequestBody ProyectoDTO proyectoDTO) {
        ProyectoDTO proyectoCreado = iProyectoService.crearProyecto(proyectoDTO);

        return new ResponseEntity<>(proyectoCreado, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<ProyectoDTO> actualizarProyecto(@PathVariable Long id, @Valid @RequestBody ProyectoDTO proyectoDTO) {
        ProyectoDTO proyectoActualizado = iProyectoService.actualizarProyecto(id, proyectoDTO);

        return new ResponseEntity<>(proyectoActualizado, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> eliminarProyecto(@PathVariable Long id) {
        iProyectoService.eliminarProyecto(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
