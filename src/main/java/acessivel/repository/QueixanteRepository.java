package acessivel.repository;

import acessivel.entity.Queixante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueixanteRepository extends JpaRepository<Queixante, Long> {
}
