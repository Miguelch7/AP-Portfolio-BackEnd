package argentinaprograma.portfolioweb.controller;

import argentinaprograma.portfolioweb.dto.SkillDTO;
import argentinaprograma.portfolioweb.service.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/skills")
public class SkillController {

    @Autowired
    private ISkillService iSkillService;

    @GetMapping
    public ResponseEntity<List<SkillDTO>> listarSkills() {
        List<SkillDTO> listadoSkills = iSkillService.listarSkills();

        return new ResponseEntity<>(listadoSkills, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillDTO> obtenerSkill(@PathVariable Long id) {
        SkillDTO skill = iSkillService.obtenerSkill(id);

        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<SkillDTO> crearSkill(@Valid @RequestBody SkillDTO skillDTO) {
        SkillDTO skillCreada = iSkillService.crearSkill(skillDTO);

        return new ResponseEntity<>(skillCreada, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<SkillDTO> actualizarSkill(
            @PathVariable Long id,
            @RequestParam("nombre") String nombre,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("imagen") String imagen,
            @RequestParam("porcentaje") Integer porcentaje
    ) {
        SkillDTO skillActualizada = iSkillService.actualizarSkill(id, nombre, descripcion, imagen, porcentaje);

        return new ResponseEntity<>(skillActualizada, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> eliminarSkill(@PathVariable Long id) {
        iSkillService.eliminarSkill(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
