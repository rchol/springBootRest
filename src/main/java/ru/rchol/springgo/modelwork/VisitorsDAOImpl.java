package ru.rchol.springgo.modelwork;

import org.springframework.stereotype.Component;
import ru.rchol.springgo.model.Visitors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Component
@Transactional
public class VisitorsDAOImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public VisitorsDAOImpl() {

    }

    public List<Visitors> getAllVisitors(){
         return entityManager.createQuery("from Visitors", Visitors.class).getResultList();
    }

    public void addVisitor(Visitors visitors){
        entityManager.persist(visitors);
    }

}
