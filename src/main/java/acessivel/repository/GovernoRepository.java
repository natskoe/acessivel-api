package acessivel.repository;

import acessivel.entity.Governo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GovernoRepository extends JpaRepository<Governo, Long> {

    Optional<Governo> findByEmail(String email);
}
