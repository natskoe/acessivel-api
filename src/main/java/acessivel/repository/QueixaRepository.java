package acessivel.repository;

import acessivel.entity.Queixa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueixaRepository extends JpaRepository<Queixa, Long> {
}
