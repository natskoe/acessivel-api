package acessivel.repository;

import acessivel.entity.Necessidade;
import acessivel.entity.Queixante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NecessidadeRepository extends JpaRepository<Necessidade, Long> {
    List<Necessidade> findAllByQueixante(Queixante queixante);
}
