package acessivel.repository;

import acessivel.entity.Queixante;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
//import jakarta.enterprise.context.ApplicationScoped;

@Repository
public interface QueixanteRepository extends JpaRepository<Queixante, Long> {

//    @PersistenceContext
//    private EntityManager em;
//
//    @Transactional
//    public void create(Queixante queixante){
//        em.persist(queixante);
//    }
}
