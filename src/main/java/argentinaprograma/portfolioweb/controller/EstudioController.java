package argentinaprograma.portfolioweb.controller;

import argentinaprograma.portfolioweb.model.Estudio;
import argentinaprograma.portfolioweb.service.IEstudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EstudioController {

    @Autowired
    private IEstudioService iEstudioService;

    @GetMapping("/estudios")
    public List<Estudio> listarEstudios() {
        List<Estudio> listadoEstudios = iEstudioService.listarEstudios();

        return listadoEstudios;
    }

    @GetMapping("/estudios/{id}")
    public Estudio obtenerEstudio(@PathVariable Long id) {
        Estudio estudio = iEstudioService.obtenerEstudio(id);

        return estudio;
    }

    @PostMapping("/estudios")
    public Estudio crearEstudio(@RequestBody Estudio estudio) {
        Estudio estudioCreado = iEstudioService.crearEstudio(estudio);

        return estudioCreado;
    }

    @PutMapping("/estudios/{id}")
    public Estudio actualizarEstudio(
            @PathVariable Long id,
            @RequestParam("titulo") String titulo,
            @RequestParam("institucion") String institucion,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("imagen") String imagen,
            @RequestParam("fecha_inicio") String fecha_inicio,
            @RequestParam("fecha_fin") String fecha_fin
    ) {
        Estudio estudioActualizado = iEstudioService.actualizarEstudio(id, titulo, institucion, descripcion, imagen, fecha_inicio, fecha_fin);

        return estudioActualizado;
    }

    @DeleteMapping("/estudios/{id}")
    public String eliminarEstudio(@PathVariable Long id) {
        iEstudioService.eliminarEstudio(id);

        return "El estudio se eliminó correctamente";
    }
}
