package argentinaprograma.portfolioweb.repository;

import argentinaprograma.portfolioweb.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol, Long> {

    public Optional<Rol> findByNombre(String nombre);
}
