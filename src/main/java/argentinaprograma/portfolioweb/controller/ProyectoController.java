package argentinaprograma.portfolioweb.controller;

import argentinaprograma.portfolioweb.model.Proyecto;
import argentinaprograma.portfolioweb.service.IProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/proyectos")
public class ProyectoController {

    @Autowired
    private IProyectoService iProyectoService;

    @GetMapping
    public ResponseEntity<List<Proyecto>> listarProyectos() {
        List<Proyecto> listadoProyectos = iProyectoService.listarProyectos();

        return new ResponseEntity<>(listadoProyectos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proyecto> obtenerProyecto(@PathVariable Long id) {
        Proyecto proyecto = iProyectoService.obtenerProyecto(id);

        return new ResponseEntity<>(proyecto, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Proyecto> crearProyecto(@RequestBody Proyecto proyecto) {
        Proyecto proyectoCreado = iProyectoService.crearProyecto(proyecto);

        return new ResponseEntity<>(proyectoCreado, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Proyecto> actualizarProyecto(
            @PathVariable Long id,
            @RequestParam("nombre") String nombre,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("imagen") String imagen,
            @RequestParam("linkProyecto") String linkProyecto,
            @RequestParam("linkRepositorio") String linkRepositorio
    ) {
        Proyecto proyectoActualizado = iProyectoService.actualizarProyecto(id, nombre, descripcion, imagen, linkProyecto, linkRepositorio);

        return new ResponseEntity<>(proyectoActualizado, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> eliminarProyecto(@PathVariable Long id) {
        iProyectoService.eliminarProyecto(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
