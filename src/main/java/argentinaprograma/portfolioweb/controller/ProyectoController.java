package argentinaprograma.portfolioweb.controller;

import argentinaprograma.portfolioweb.model.Proyecto;
import argentinaprograma.portfolioweb.service.IProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProyectoController {

    @Autowired
    private IProyectoService iProyectoService;

    @GetMapping("/proyectos")
    public List<Proyecto> listarProyectos() {
        List<Proyecto> listadoProyectos = iProyectoService.listarProyectos();

        return listadoProyectos;
    }

    @GetMapping("/proyectos/{id}")
    public Proyecto obtenerProyecto(@PathVariable Long id) {
        Proyecto proyecto = iProyectoService.obtenerProyecto(id);

        return proyecto;
    }

    @PostMapping("/proyectos")
    public Proyecto crearProyecto(@RequestBody Proyecto proyecto) {
        Proyecto proyectoCreado = iProyectoService.crearProyecto(proyecto);

        return proyectoCreado;
    }

    @PutMapping("/proyectos/{id}")
    public Proyecto actualizarProyecto(
            @PathVariable Long id,
            @RequestParam("nombre") String nombre,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("imagen") String imagen,
            @RequestParam("link_proyecto") String link_proyecto,
            @RequestParam("link_repositorio") String link_repositorio
    ) {
        Proyecto proyectoActualizado = iProyectoService.actualizarProyecto(id, nombre, descripcion, imagen, link_proyecto, link_repositorio);

        return proyectoActualizado;
    }

    @DeleteMapping("/proyectos/{id}")
    public String eliminarProyecto(@PathVariable Long id) {
        iProyectoService.eliminarProyecto(id);

        return "El proyecto se eliminó correctamente";
    }
}
