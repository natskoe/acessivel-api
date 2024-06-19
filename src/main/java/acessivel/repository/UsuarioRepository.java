package acessivel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import acessivel.entity.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
