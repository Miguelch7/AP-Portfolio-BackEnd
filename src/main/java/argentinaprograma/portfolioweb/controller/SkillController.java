package argentinaprograma.portfolioweb.controller;

import argentinaprograma.portfolioweb.model.Skill;
import argentinaprograma.portfolioweb.service.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/skills")
public class SkillController {

    @Autowired
    private ISkillService iSkillService;

    @GetMapping
    public ResponseEntity<List<Skill>> listarSkills() {
        List<Skill> listadoSkills = iSkillService.listarSkills();

        return new ResponseEntity<>(listadoSkills, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Skill> obtenerSkill(@PathVariable Long id) {
        Skill skill = iSkillService.obtenerSkill(id);

        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Skill> crearSkill(@RequestBody Skill skill) {
        Skill skillCreada = iSkillService.crearSkill(skill);

        return new ResponseEntity<>(skillCreada, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Skill> actualizarSkill(
            @PathVariable Long id,
            @RequestParam("nombre") String nombre,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("imagen") String imagen,
            @RequestParam("porcentaje") Integer porcentaje
    ) {
        Skill skillActualizada = iSkillService.actualizarSkill(id, nombre, descripcion, imagen, porcentaje);

        return new ResponseEntity<>(skillActualizada, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> eliminarSkill(@PathVariable Long id) {
        iSkillService.eliminarSkill(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
