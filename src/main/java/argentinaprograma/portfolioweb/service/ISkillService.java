package argentinaprograma.portfolioweb.service;

import argentinaprograma.portfolioweb.dto.SkillDTO;

import java.util.List;

public interface ISkillService {

    public List<SkillDTO> listarSkills();
    public SkillDTO obtenerSkill(Long id);
    public SkillDTO crearSkill(SkillDTO skillDTO);
    public SkillDTO actualizarSkill(Long id, SkillDTO skillDTO);
    public void eliminarSkill(Long id);
}
