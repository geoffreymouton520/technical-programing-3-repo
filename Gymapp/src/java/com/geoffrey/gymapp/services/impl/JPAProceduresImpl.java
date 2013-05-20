/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.impl;

import com.geoffrey.gymapp.services.JPAProcedures;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 211026298
 */
@Service("procedures")
public class JPAProceduresImpl implements JPAProcedures{
    @PersistenceContext(type=PersistenceContextType.EXTENDED)
    EntityManager em; 

    @Override
    @Transactional
    public void createExercise() {
        Query query = em.createNativeQuery("BEGIN ADD_EXERCISE(); END;");
        query.executeUpdate();  
    }

    
    @Override
    @Transactional
    public void findDiscount(int numOfSeats, int discPercentage) {
        Query query = em.createNativeQuery("BEGIN FIND_DISCOUNT(P_NUM_OF_SEATS=>?1,P_DISC_PERC=>?2); END;");
        query.setParameter(1, numOfSeats);
        query.setParameter(2, discPercentage);
        query.executeUpdate();
    }
    
    
}
