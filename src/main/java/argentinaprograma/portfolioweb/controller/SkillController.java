package argentinaprograma.portfolioweb.controller;

import argentinaprograma.portfolioweb.model.Skill;
import argentinaprograma.portfolioweb.service.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SkillController {

    @Autowired
    private ISkillService iSkillService;

    @GetMapping("/skills")
    public List<Skill> listarSkills() {
        List<Skill> listadoSkills = iSkillService.listarSkills();

        return listadoSkills;
    }

    @GetMapping("/skills/{id}")
    public Skill obtenerSkill(@PathVariable Long id) {
        Skill skill = iSkillService.obtenerSkill(id);

        return skill;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/skills")
    public Skill crearSkill(@RequestBody Skill skill) {
        Skill skillCreada = iSkillService.crearSkill(skill);

        return skillCreada;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/skills/{id}")
    public Skill actualizarSkill(
            @PathVariable Long id,
            @RequestParam("nombre") String nombre,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("imagen") String imagen,
            @RequestParam("porcentaje") Integer porcentaje
    ) {
        Skill skillActualizada = iSkillService.actualizarSkill(id, nombre, descripcion, imagen, porcentaje);

        return skillActualizada;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/skills/{id}")
    public String eliminarSkill(@PathVariable Long id) {
        iSkillService.eliminarSkill(id);

        return "La skill se eliminó correctamente";
    }
}
