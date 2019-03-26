package com.itlbv.routines.repository.jpa;

import com.itlbv.routines.model.Routine;
import com.itlbv.routines.repository.RoutineRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaRoutineRepositoryImpl implements RoutineRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public Routine save(Routine routine) {
        if (routine.isNew()) {
            em.persist(routine);
        } else {
            em.merge(routine);
        }
        return routine;
    }

    @Override
    public Routine get(int id) {
        return em.find(Routine.class, id);
    }

    @Override
    public boolean delete(int id) {
        return em.createNamedQuery(Routine.DELETE, Routine.class)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }

    @Override
    public List<Routine> getAll() {
        return em.createNamedQuery(Routine.GET_ALL, Routine.class)
                .getResultList();
    }
}
