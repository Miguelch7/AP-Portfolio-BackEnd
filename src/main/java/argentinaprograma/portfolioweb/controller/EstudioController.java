package argentinaprograma.portfolioweb.controller;

import argentinaprograma.portfolioweb.model.Estudio;
import argentinaprograma.portfolioweb.service.IEstudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/estudios")
public class EstudioController {

    @Autowired
    private IEstudioService iEstudioService;

    @GetMapping
    public ResponseEntity<List<Estudio>> listarEstudios() {
        List<Estudio> listadoEstudios = iEstudioService.listarEstudios();

        return new ResponseEntity<>(listadoEstudios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudio> obtenerEstudio(@PathVariable Long id) {
        Estudio estudio = iEstudioService.obtenerEstudio(id);

        return new ResponseEntity<>(estudio, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Estudio> crearEstudio(@RequestBody Estudio estudio) {
        Estudio estudioCreado = iEstudioService.crearEstudio(estudio);

        return new ResponseEntity<>(estudioCreado, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Estudio> actualizarEstudio(
            @PathVariable Long id,
            @RequestParam("titulo") String titulo,
            @RequestParam("institucion") String institucion,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("imagen") String imagen,
            @RequestParam("fechaInicio") String fechaInicio,
            @RequestParam("fechaFin") String fechaFin
    ) {
        Estudio estudioActualizado = iEstudioService.actualizarEstudio(id, titulo, institucion, descripcion, imagen, fechaInicio, fechaFin);

        return new ResponseEntity<>(estudioActualizado, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> eliminarEstudio(@PathVariable Long id) {
        iEstudioService.eliminarEstudio(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
