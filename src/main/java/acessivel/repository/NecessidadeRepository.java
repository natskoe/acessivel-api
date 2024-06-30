package acessivel.repository;

import acessivel.entity.Necessidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NecessidadeRepository extends JpaRepository<Necessidade, Long> {
}
