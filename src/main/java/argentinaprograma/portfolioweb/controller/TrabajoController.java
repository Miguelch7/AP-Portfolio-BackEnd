package argentinaprograma.portfolioweb.controller;

import argentinaprograma.portfolioweb.dto.TrabajoDTO;
import argentinaprograma.portfolioweb.model.Trabajo;
import argentinaprograma.portfolioweb.service.ITrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/trabajos")
public class TrabajoController {

    @Autowired
    private ITrabajoService iTrabajoService;

    @GetMapping
    public ResponseEntity<List<TrabajoDTO>> listarTrabajos() {
        List<TrabajoDTO> listadoTrabajos = iTrabajoService.listarTrabajos();

        return new ResponseEntity<>(listadoTrabajos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrabajoDTO> obtenerTrabajo(@PathVariable Long id) {
        TrabajoDTO trabajo = iTrabajoService.obtenerTrabajo(id);

        return new ResponseEntity<>(trabajo, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<TrabajoDTO> crearTrabajo(@RequestBody TrabajoDTO trabajoDTO) {
        TrabajoDTO trabajoCreado = iTrabajoService.crearTrabajo(trabajoDTO);

        return new ResponseEntity<>(trabajoCreado, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<TrabajoDTO> actualizarTrabajo(
            @PathVariable Long id,
            @RequestParam("puesto") String puesto,
            @RequestParam("empresa") String empresa,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("imagen") String imagen,
            @RequestParam("fechaInicio") String fechaInicio,
            @RequestParam("fechaFin") String fechaFin
    ) {
        TrabajoDTO trabajoActualizado = iTrabajoService.actualizarTrabajo(id, puesto, empresa, descripcion, imagen, fechaInicio, fechaFin);

        return new ResponseEntity<>(trabajoActualizado, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> eliminarTrabajo(@PathVariable Long id) {
        iTrabajoService.eliminarTrabajo(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
