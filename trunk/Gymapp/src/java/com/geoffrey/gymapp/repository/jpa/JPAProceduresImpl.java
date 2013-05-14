/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.repository.jpa;

import com.geoffrey.gymapp.repository.JPAProcedures;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 211026298
 */
@Repository("procedures")
public class JPAProceduresImpl implements JPAProcedures{
    @PersistenceContext(type=PersistenceContextType.EXTENDED)
    EntityManager em; 

    @Override
    public void createExercise() {
        Query query = em.createNativeQuery("BEGIN VALIDATE_EMP(P_EMP_ID=>?); END;");
        query.executeUpdate();  
    }
    
    
}
