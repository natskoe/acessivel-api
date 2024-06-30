package acessivel.repository;

import acessivel.entity.Queixa;
import acessivel.entity.Queixante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QueixaRepository extends JpaRepository<Queixa, Long> {
    List<Queixa> findAllByQueixante(Queixante queixante);
}
