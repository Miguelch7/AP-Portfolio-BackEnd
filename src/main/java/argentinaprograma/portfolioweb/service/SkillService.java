package argentinaprograma.portfolioweb.service;

import argentinaprograma.portfolioweb.model.Skill;
import argentinaprograma.portfolioweb.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService implements ISkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Override
    public List<Skill> listarSkills() {
        List <Skill> listadoSkills = skillRepository.findAll();

        return listadoSkills;
    }

    @Override
    public Skill obtenerSkill(Long id) {
        Skill skill = skillRepository.findById(id).orElse(null);

        return skill;
    }

    @Override
    public Skill crearSkill(Skill skill) {
        Skill nuevaSkill = skillRepository.save(skill);

        return nuevaSkill;
    }

    @Override
    public Skill actualizarSkill(Long id, String nombre, String descripcion, String imagen, Integer porcentaje) {
        Skill skillActualizada = obtenerSkill(id);

        if (skillActualizada != null) {
            skillActualizada.setNombre(nombre);
            skillActualizada.setDescripcion(descripcion);
            skillActualizada.setImagen(imagen);
            skillActualizada.setPorcentaje(porcentaje);

            skillRepository.save(skillActualizada);
        }

        return skillActualizada;
    }

    @Override
    public void eliminarSkill(Long id) {
        skillRepository.deleteById(id);
    }
}
