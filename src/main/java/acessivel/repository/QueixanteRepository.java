package acessivel.repository;

import acessivel.entity.Queixante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface QueixanteRepository extends JpaRepository<Queixante, Long> {
    Optional<Queixante> findByEmail(String email);
}
