package argentinaprograma.portfolioweb.controller;

import argentinaprograma.portfolioweb.model.Trabajo;
import argentinaprograma.portfolioweb.service.ITrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrabajoController {

    @Autowired
    private ITrabajoService iTrabajoService;

    @GetMapping("/trabajos")
    public List<Trabajo> listarTrabajos() {
        List<Trabajo> listadoTrabajos = iTrabajoService.listarTrabajos();

        return listadoTrabajos;
    }

    @GetMapping("/trabajos/{id}")
    public Trabajo obtenerTrabajo(@PathVariable Long id) {
        Trabajo trabajo = iTrabajoService.obtenerTrabajo(id);

        return trabajo;
    }

    @PostMapping("/trabajos")
    public Trabajo crearTrabajo(@RequestBody Trabajo trabajo) {
        Trabajo trabajoCreado = iTrabajoService.crearTrabajo(trabajo);

        return trabajoCreado;
    }

    @PutMapping("/trabajos/{id}")
    public Trabajo actualizarTrabajo(
            @PathVariable Long id,
            @RequestParam("puesto") String puesto,
            @RequestParam("empresa") String empresa,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("imagen") String imagen,
            @RequestParam("fecha_inicio") String fecha_inicio,
            @RequestParam("fecha_fin") String fecha_fin
    ) {
        Trabajo trabajoActualizado = iTrabajoService.actualizarTrabajo(id, puesto, empresa, descripcion, imagen, fecha_inicio, fecha_fin);

        return trabajoActualizado;
    }

    @DeleteMapping("/trabajos/{id}")
    public String eliminarTrabajo(@PathVariable Long id) {
        iTrabajoService.eliminarTrabajo(id);

        return "El trabajo se eliminó correctamente";
    }
}