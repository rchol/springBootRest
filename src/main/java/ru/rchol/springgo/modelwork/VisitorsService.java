package ru.rchol.springgo.modelwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.rchol.springgo.model.Visitors;

import java.util.List;

/**
 * Created by User on 012 12.06.18.
 */
@Component
@Transactional
public class VisitorsService {

    @Autowired
    private VisitorsDAOImpl visitorsDAO;

    public void addVisitor(Visitors visitors){
        visitorsDAO.addVisitor(visitors);
    }

    public List<Visitors> getAllVisitors(){
        return visitorsDAO.getAllVisitors();
    }

}
