package argentinaprograma.portfolioweb.service;

import argentinaprograma.portfolioweb.model.Skill;

import java.util.List;

public interface ISkillService {

    public List<Skill> listarSkills();
    public Skill obtenerSkill(Long id);
    public Skill crearSkill(Skill skill);
    public Skill actualizarSkill(Long id, String nombre, String descripcion, String imagen, Integer porcentaje);
    public void eliminarSkill(Long id);
}
