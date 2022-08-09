package argentinaprograma.portfolioweb.service;

import argentinaprograma.portfolioweb.dto.SkillDTO;
import argentinaprograma.portfolioweb.model.Skill;

import java.util.List;

public interface ISkillService {

    public List<SkillDTO> listarSkills();
    public SkillDTO obtenerSkill(Long id);
    public SkillDTO crearSkill(SkillDTO skillDTO);
    public SkillDTO actualizarSkill(Long id, String nombre, String descripcion, String imagen, Integer porcentaje);
    public void eliminarSkill(Long id);
}
