package argentinaprograma.portfolioweb.service;

import argentinaprograma.portfolioweb.dto.SkillDTO;
import argentinaprograma.portfolioweb.exception.ResourceNotFoundException;
import argentinaprograma.portfolioweb.model.Skill;
import argentinaprograma.portfolioweb.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillService implements ISkillService {

    @Autowired
    private SkillRepository skillRepository;

    // Convertir Entity a DTO
    private SkillDTO mapToDTO(Skill skill) {
        SkillDTO skillDTO = new SkillDTO();

        skillDTO.setId(skill.getId());
        skillDTO.setNombre(skill.getNombre());
        skillDTO.setDescripcion(skill.getDescripcion());
        skillDTO.setImagen(skill.getImagen());
        skillDTO.setPorcentaje(skill.getPorcentaje());

        return skillDTO;
    }

    // Convertir DTO a Entity
    private Skill mapToEntity(SkillDTO skillDTO) {
        Skill skill = new Skill();

        skill.setNombre(skillDTO.getNombre());
        skill.setDescripcion(skillDTO.getDescripcion());
        skill.setImagen(skillDTO.getImagen());
        skill.setPorcentaje(skillDTO.getPorcentaje());

        return skill;
    }

    @Override
    public List<SkillDTO> listarSkills() {
        List<Skill> listadoSkills = skillRepository.findAll();

        List<SkillDTO> listadoSkillsDTO = listadoSkills.stream().map(skill -> mapToDTO(skill)).collect(Collectors.toList());

        return listadoSkillsDTO;
    }

    @Override
    public SkillDTO obtenerSkill(Long id) {
        Skill skill = skillRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Skill", "id", id));;

        return mapToDTO(skill);
    }

    @Override
    public SkillDTO crearSkill(SkillDTO skillDTO) {

        Skill skill = mapToEntity(skillDTO);

        Skill nuevaSkill = skillRepository.save(skill);

        return mapToDTO(nuevaSkill);
    }

    @Override
    public SkillDTO actualizarSkill(Long id, String nombre, String descripcion, String imagen, Integer porcentaje) {
        Skill skill = skillRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Skill", "id", id));;

        skill.setNombre(nombre);
        skill.setDescripcion(descripcion);
        skill.setImagen(imagen);
        skill.setPorcentaje(porcentaje);

        Skill skillActualizada = skillRepository.save(skill);

        return mapToDTO(skillActualizada);
    }

    @Override
    public void eliminarSkill(Long id) {
        Skill skill = skillRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Skill", "id", id));;

        skillRepository.delete(skill);
    }
}
