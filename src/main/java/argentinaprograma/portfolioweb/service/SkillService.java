package argentinaprograma.portfolioweb.service;

import argentinaprograma.portfolioweb.exception.ResourceNotFoundException;
import argentinaprograma.portfolioweb.model.Proyecto;
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
        Skill skill = skillRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Skill", "id", id));;

        return skill;
    }

    @Override
    public Skill crearSkill(Skill skill) {
        Skill nuevaSkill = skillRepository.save(skill);

        return nuevaSkill;
    }

    @Override
    public Skill actualizarSkill(Long id, String nombre, String descripcion, String imagen, Integer porcentaje) {
        Skill skill = skillRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Skill", "id", id));;

        skill.setNombre(nombre);
        skill.setDescripcion(descripcion);
        skill.setImagen(imagen);
        skill.setPorcentaje(porcentaje);

        Skill skillActualizada = skillRepository.save(skill);

        return skillActualizada;
    }

    @Override
    public void eliminarSkill(Long id) {
        Skill skill = skillRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Skill", "id", id));;

        skillRepository.delete(skill);
    }
}
