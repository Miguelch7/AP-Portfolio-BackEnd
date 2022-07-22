package argentinaprograma.portfolioweb.repository;

import argentinaprograma.portfolioweb.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
