package argentinaprograma.portfolioweb.repository;

import argentinaprograma.portfolioweb.model.DetalleUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DetalleUsuarioRepository extends JpaRepository<DetalleUsuario, Long> {

    public Optional<DetalleUsuario> findByUsuarioId(Long usuarioId);
}
