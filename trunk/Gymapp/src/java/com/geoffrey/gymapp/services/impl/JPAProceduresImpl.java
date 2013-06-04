/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.impl;

import com.geoffrey.gymapp.services.JPAProcedures;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 211026298
 */
@Service("procedures")
public class JPAProceduresImpl implements JPAProcedures {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    EntityManager em;

    @Override
    @Transactional
    public void createExercise() {
        Query query = em.createNativeQuery("BEGIN exercise_management.ADD_EXERCISE(); END;");
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

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public String insertTestValues() {
        try {
            insertExercises();
            insertPreferences();
            insertPeople();
            insertUsers();
            updatePeople();
            insertAddress();
            insertBodyStatGoals();
            return "Successful";
        } catch (TransactionRequiredException e) {
            return "Unsuccessful";
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public String insertTestPart2Values() {
        try {
            insertStatistics();
            insertExercisePreferences();
            insertFitnessRoutine();
            insertUserRoles();
            insertWorkouts();
            insertWorkoutItems();
            insertRoutineItem();
            return "Successful";
        } catch (TransactionRequiredException e) {
            return "Unsuccessful";
        }
    }
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    private void insertExercises() {
        Query query = em.createNativeQuery("BEGIN exercise_management.p_insertexercise( 1000, 100, 'bench dip', 'body weight', 8, 'added soon', 1, 'bench dip', 10, 60); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercise_management.p_insertexercise( 1002, 120, 'close tricep pushup', 'body weight', 8, 'added soon', 1, 'close tricep pushup', 10, 60); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercise_management.p_insertexercise( 1003, 125, 'dumbell tate press', 'dumbells', 8, 'added soon' , 1, 'dumbell tate press', 10, 20); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercise_management.p_insertexercise( 1004, 60, 'Arm Circles', 'body', 8, 'added soon' , 2, 'Arm Circles', 10, 60); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercise_management.p_insertexercise( 1005, 80, 'dublin press', 'dumbells', 8, 'added soon' , 2, 'dublin press', 10, 60); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercise_management.p_insertexercise( 1006, 120, 'dumbell shoulder press', 'dumbells', 8, 'added soon' , 2, 'dumbell shoulder press', 10 , 60); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercise_management.p_insertexercise( 1007, 100, 'alternate hammer curl', 'dumbells', 8, 'added soon' , 3, 'alternate hammer curl', 10 , 60); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercise_management.p_insertexercise( 1008, 80, 'drag curl', 'barbell', 8, 'added soon' , 3, 'drag curl', 10 , 60); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercise_management.p_insertexercise( 1009, 95, 'dumbell high curl', 'dumbells', 8, 'added soon' , 3, 'dumbell high curl', 10 , 60); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercise_management.p_insertexercise( 1010, 100, '1 leg pushups', 'body', 8, 'added soon' , 4, '1 leg pushups', 10 , 60); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercise_management.p_insertexercise( 1011, 50, 'barbell bench press', 'barbell', 8, 'added soon' , 4, 'barbell bench press', 10 , 60); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercise_management.p_insertexercise( 1012, 80, 'dumbell fly', 'dumbells', 8, 'added soon' , 4, 'dumbell fly', 10 , 60); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercise_management.p_insertexercise( 1013, 90, 'alternating kettlebell row', 'kettlebells', 8, 'added soon' , 5, 'alternating kettlebell row', 10 , 60); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercise_management.p_insertexercise( 1014, 65, 'alternating renegade row', 'kettlebells', 8, 'added soon' , 5,  'alternating renegade row', 10 , 60); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercise_management.p_insertexercise( 1015, 75, 'barbell good morning', 'barbell', 8, 'added soon' , 5, 'barbell good morning', 10 , 60); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercise_management.p_insertexercise( 1016, 89, 'reverse barbell curl', 'barbell', 8, 'added soon' , 6, 'reverse barbell curl', 10 , 60); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercise_management.p_insertexercise( 1017, 75, 'plate pinch', 'weight plate', 8, 'added soon' , 6, 'plate pinch', 10 , 60); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercise_management.p_insertexercise( 1018, 110, 'kneeling forearm stretch', 'body', 8, 'added soon' , 6, 'kneeling forearm stretch', 10 , 60); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercise_management.p_insertexercise( 1019, 95, 'bridge', 'body', 8, 'added soon' , 7, 'bridge', 10 , 60); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercise_management.p_insertexercise( 1020, 45, 'iron cross stretch', 'body', 8, 'added soon' , 7, 'iron cross stretch', 10 , 60); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercise_management.p_insertexercise( 1021, 120, 'kneeling squat', 'barbell', 8, 'added soon' , 7, 'kneeling squat', 10 , 60); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercise_management.p_insertexercise( 1022, 65, 'abdominal pendulum', 'body', 8, 'added soon' , 8, 'abdominal pendulum', 10 , 60); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercise_management.p_insertexercise( 1023, 95, 'air bike', 'body', 8, 'added soon' , 8, 'air bike', 10 , 60); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercise_management.p_insertexercise( 1024, 115, 'barbell side bend', 'barbell', 8, 'added soon' , 8, 'barbell side bend', 10 , 60); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercise_management.p_insertexercise( 1025, 120, 'bodyweight standing calf raise', 'body', 8, 'added soon' , 9, 'bodyweight standing calf raise', 10 , 60); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercise_management.p_insertexercise( 1026, 105, 'seated calf stretch', 'body', 8, 'added soon' , 9, 'seated calf stretch', 10 , 60); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercise_management.p_insertexercise( 1027, 65, 'floor barbell calf raise', 'barbell', 8, 'added soon' , 9, 'floor barbell calf raise', 10 , 60); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercise_management.p_insertexercise( 1028, 70, '1/2 squat', 'barbell', 8, 'added soon' , 2, '1/2 squat', 10 , 60); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercise_management.p_insertexercise( 1029, 80, 'barbell full squat', 'barbell', 8, 'added soon' , 2, 'barbell full squat', 10 , 60); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercise_management.p_insertexercise( 1030, 85, 'dumbell lunges', 'dumbells', 8, 'added soon' , 2, 'dumbell lunges', 10 , 60); END;");
        query.executeUpdate();
    }

    private void insertPreferences() {
        Query query = em.createNativeQuery("BEGIN p_insertpreferences( 4001, 1, 30); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertpreferences( 4002, 1, 60); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertpreferences( 4003, 1, 90); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertpreferences( 4004, 1, 120); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertpreferences( 4005, 1, 150); END;");
        query.executeUpdate();
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    private void insertPeople() {
        Query query = em.createNativeQuery("BEGIN person_management.p_insertperson( 3001, '23-11-1992', 'geoffrey', 0, 'mouton', 'N/A', 4001, NULL); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN person_management.p_insertperson( 3002, '24-07-1991', 'xavier', 0, 'lawrence', 'N/A', 4002, NULL); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN person_management.p_insertperson( 3003, '08-05-1991', 'lance', 0, 'hutchinson', 'N/A', 4003, NULL); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN person_management.p_insertperson( 3004, '02-02-1991', 'jp', 0, 'de buys', 'N/A', 4004, NULL); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN person_management.p_insertperson( 3005, '20-09-1991', 'tatenda', 0, 'mufakose', 'N/A', 4005, NULL); END;");
        query.executeUpdate();
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    private void insertUsers() {
        Query query = em.createNativeQuery("BEGIN user_management.p_insertuser( 2011, 1, 'geoffrey', '4812770c53f5e0c64c3cefb84d32525a', 3001); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN user_management.p_insertuser( 2012, 1, 'xavier', '4812770c53f5e0c64c3cefb84d32525a', 3002); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN user_management.p_insertuser( 2013, 1, 'lance', '4812770c53f5e0c64c3cefb84d32525a', 3003); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN user_management.p_insertuser( 2014, 1, 'jp', '4812770c53f5e0c64c3cefb84d32525a', 3004); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN user_management.p_insertuser( 2015, 1, 'tatenda', '4812770c53f5e0c64c3cefb84d32525a', 3005); END;");
        query.executeUpdate();
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    private void updatePeople() {
        Query query = em.createNativeQuery("BEGIN person_management.p_updateperson(3001,2011); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN person_management.p_updateperson(3002,2012); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN person_management.p_updateperson(3003,2013); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN person_management.p_updateperson(3004,2014); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN person_management.p_updateperson(3005,2015); END;");
        query.executeUpdate();
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    private void insertAddress() {
        Query query = em.createNativeQuery("BEGIN address_management.p_insertaddress( 5001, '75 Tiger Street, Kraaifontein', '75 Tiger Street, Kraaifontein', '7570', 3001 ); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN address_management.p_insertaddress( 5002, '43 York Street, Woodstock', '43 York Street, Woodstock', '7925', 3002 ); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN address_management.p_insertaddress( 5003, '13 Nerina Crescent, Fish Hoek', '13 Nerina Crescent, Fish Hoek', '7975', 3003 ); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN address_management.p_insertaddress( 5004, 'Mitchels Plain', 'Mitchels Plain', '7785', 3004 ); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN address_management.p_insertaddress( 5005, 'Harare, Zimbabwe', 'Harare, Zimbabwe', '8001', 3005 ); END;");
        query.executeUpdate();
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    private void insertBodyStatGoals() {
        Query query = em.createNativeQuery("BEGIN exercisegoal_management.p_insertexercisegoal( 8001, 8, 80.0, 1023, 3001); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercisegoal_management.p_insertexercisegoal( 8002, 8, 66.0, 1002, 3002); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercisegoal_management.p_insertexercisegoal( 8003, 8, 90.0, 1029, 3003); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercisegoal_management.p_insertexercisegoal( 8004, 8, 70.0, 1015, 3004); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercisegoal_management.p_insertexercisegoal( 8005, 8, 95.0, 1010, 3005); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN bodystatgoal_management.p_insertbodystatgoal( 6001, 80.0, 1, 3001 ); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN bodystatgoal_management.p_insertbodystatgoal( 6002, 75.0, 2, 3002 ); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN bodystatgoal_management.p_insertbodystatgoal( 6003, 95.0, 1, 3003 ); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN bodystatgoal_management.p_insertbodystatgoal( 6004, 70.0, 3, 3004 ); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN bodystatgoal_management.p_insertbodystatgoal( 6005, 90.0, 4, 3005 ); END;");
        query.executeUpdate();
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    private void insertStatistics() {
        Query query = em.createNativeQuery("BEGIN p_insertstatistics( 7001, to_date('2013/01/15 20:30:00','yyyy/mm/dd hh24:mi:ss'), 10, 8, 80.0, 1000, 3001); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertstatistics( 7002, to_date('2013/01/09 21:00:00','yyyy/mm/dd hh24:mi:ss'), 10, 8, 66.0, 1002, 3002); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertstatistics( 7003, to_date('2013/01/22 16:30:00','yyyy/mm/dd hh24:mi:ss'), 10, 8, 95.0, 1003, 3003); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertstatistics( 7004, to_date('2013/01/19 17:45:00','yyyy/mm/dd hh24:mi:ss'), 10, 8, 70.0, 1004, 3004); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertstatistics( 7005, to_date('2013/01/28 08:30:00','yyyy/mm/dd hh24:mi:ss'), 10, 8, 90.0, 1005, 3005); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertstatistics( 7006, to_date('2013/02/15 20:30:00','yyyy/mm/dd hh24:mi:ss'), 10, 8, 80.0, 1006, 3001); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertstatistics( 7007, to_date('2013/02/09 21:00:00','yyyy/mm/dd hh24:mi:ss'), 10, 8, 66.0, 1007, 3002); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertstatistics( 7008, to_date('2013/02/22 16:30:00','yyyy/mm/dd hh24:mi:ss'), 10, 8, 95.0, 1008, 3003); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertstatistics( 7009, to_date('2013/02/19 17:45:00','yyyy/mm/dd hh24:mi:ss'), 10, 8, 70.0, 1009, 3004); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertstatistics( 7010, to_date('2013/02/28 08:30:00','yyyy/mm/dd hh24:mi:ss'), 10, 8, 90.0, 1010, 3005); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertstatistics( 7011, to_date('2013/03/15 20:30:00','yyyy/mm/dd hh24:mi:ss'), 10, 8, 80.0, 1011, 3001); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertstatistics( 7012, to_date('2013/03/09 21:00:00','yyyy/mm/dd hh24:mi:ss'), 10, 8, 66.0, 1012, 3002); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertstatistics( 7013, to_date('2013/03/22 16:30:00','yyyy/mm/dd hh24:mi:ss'), 10, 8, 95.0, 1013, 3003); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertstatistics( 7014, to_date('2013/03/19 17:45:00','yyyy/mm/dd hh24:mi:ss'), 10, 8, 70.0, 1014, 3004); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertstatistics( 7015, to_date('2013/03/28 08:30:00','yyyy/mm/dd hh24:mi:ss'), 10, 8, 90.0, 1015, 3005); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertstatistics( 7016, to_date('2013/04/15 20:30:00','yyyy/mm/dd hh24:mi:ss'), 10, 8, 80.0, 1016, 3001); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertstatistics( 7017, to_date('2013/04/09 21:00:00','yyyy/mm/dd hh24:mi:ss'), 10, 8, 66.0, 1017, 3002); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertstatistics( 7018, to_date('2013/04/22 16:30:00','yyyy/mm/dd hh24:mi:ss'), 10, 8, 95.0, 1018, 3003); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertstatistics( 7019, to_date('2013/04/19 17:45:00','yyyy/mm/dd hh24:mi:ss'), 10, 8, 70.0, 1019, 3004); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertstatistics( 7020, to_date('2013/04/28 08:30:00','yyyy/mm/dd hh24:mi:ss'), 10, 8, 90.0, 1020, 3005); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertstatistics( 7021, to_date('2013/05/15 20:30:00','yyyy/mm/dd hh24:mi:ss'), 10, 8, 80.0, 1021, 3001); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertstatistics( 7022, to_date('2013/05/09 21:00:00','yyyy/mm/dd hh24:mi:ss'), 10, 8, 66.0, 1022, 3002); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertstatistics( 7023, to_date('2013/05/22 16:30:00','yyyy/mm/dd hh24:mi:ss'), 10, 8, 95.0, 1023, 3003); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertstatistics( 7024, to_date('2013/05/19 17:45:00','yyyy/mm/dd hh24:mi:ss'), 10, 8, 70.0, 1024, 3004); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertstatistics( 7025, to_date('2013/05/28 08:30:00','yyyy/mm/dd hh24:mi:ss'), 10, 8, 90.0, 1025, 3005); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertstatistics( 7026, to_date('2013/06/01 20:30:00','yyyy/mm/dd hh24:mi:ss'), 10, 8, 80.0, 1026, 3001); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertstatistics( 7027, to_date('2013/06/01 21:00:00','yyyy/mm/dd hh24:mi:ss'), 10, 8, 66.0, 1027, 3002); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertstatistics( 7028, to_date('2013/06/02 16:30:00','yyyy/mm/dd hh24:mi:ss'), 10, 8, 95.0, 1028, 3003); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertstatistics( 7029, to_date('2013/06/02 17:45:00','yyyy/mm/dd hh24:mi:ss'), 10, 8, 70.0, 1029, 3004); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertstatistics( 7030, to_date('2013/06/03 08:30:00','yyyy/mm/dd hh24:mi:ss'), 10, 8, 90.0, 1030, 3005); END;");
        query.executeUpdate();
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    private void insertExercisePreferences() {
        Query query = em.createNativeQuery("BEGIN exercisepref_management.p_insertexercisepref( 9001, 15, 10, 1010, 4001); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercisepref_management.p_insertexercisepref( 9002, 10, 10, 1002, 4002); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercisepref_management.p_insertexercisepref( 9003, 15, 10, 1022, 4001); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercisepref_management.p_insertexercisepref( 9004, 5, 10, 1000, 4004); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN exercisepref_management.p_insertexercisepref( 9005, 8, 10, 1020, 4003); END;");
        query.executeUpdate();
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    private void insertFitnessRoutine() {
        Query query = em.createNativeQuery("BEGIN p_insertfitnessroutine( 10001, 1, 'Get off that couch', 1); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertfitnessroutine( 10002, 2, 'Beginner', 2); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertfitnessroutine( 10003, 0, 'Feel your heart pumping yet?', 3); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertfitnessroutine( 10004, 1, 'Dont give up just yet', 4); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertfitnessroutine( 10005, 2, 'For the seasoned', 5); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertfitnessroutine( 10006, 0, 'Keep sweating', 6); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertfitnessroutine( 10007, 1, 'Hardcore', 7); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertfitnessroutine( 10008, 2, 'Major Pain', 8); END;");
        query.executeUpdate();
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    private void insertRoutineItem() {
        Query query = em.createNativeQuery("BEGIN p_insertroutineitem( 13001, 1, 12001, 10001); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertroutineitem( 13002, 2, 12002, 10002); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertroutineitem( 13003, 3, 12003, 10003); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertroutineitem( 13004, 4, 12004, 10004); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertroutineitem( 13005, 5, 12005, 10005); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertroutineitem( 13006, 6, 12006, 10006); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertroutineitem( 13007, 7, 12007, 10007); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertroutineitem( 13008, 8, 12008, 10008); END;");
        query.executeUpdate();
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    private void insertUserRoles() {
        Query query = em.createNativeQuery("BEGIN p_insertuserrole( 11001, 1, 'ROLE_ADMIN', 2001); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertuserrole( 11002, 1, 'ROLE_ADMIN', 2002); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertuserrole( 11003, 1, 'ROLE_USER', 2003); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertuserrole( 11004, 1, 'ROLE_USER', 2004); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertuserrole( 11005, 1, 'ROLE_USER', 2005); END;");
        query.executeUpdate();
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    private void insertWorkouts() {
        Query query = em.createNativeQuery("BEGIN p_insertworkout( 12001, 1, 100, 30); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertworkout( 12002, 2, 150, 45); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertworkout( 12003, 0, 200, 60); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertworkout( 12004, 1, 250, 75); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertworkout( 12005, 2, 300, 90); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertworkout( 12006, 0, 350, 105); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertworkout( 12007, 1, 400, 120); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertworkout( 12008, 2, 450, 135); END;");
        query.executeUpdate();
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    private void insertWorkoutItems() {
        Query query = em.createNativeQuery("BEGIN p_insertworkoutitem( 14001, 1000, 12001); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertworkoutitem( 14002, 1002, 12002); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertworkoutitem( 14003, 1003, 12003); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertworkoutitem( 14004, 1004, 12004);END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertworkoutitem( 14005, 1005, 12005); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertworkoutitem( 14006, 1006, 12006); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertworkoutitem( 14007, 1007, 12007); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertworkoutitem( 14008, 1008, 12008); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertworkoutitem( 14009, 1009, 12001); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertworkoutitem( 14010, 1010, 12002); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertworkoutitem( 14011, 1011, 12003); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertworkoutitem( 14012, 1012, 12004); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertworkoutitem( 14013, 1013, 12005); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertworkoutitem( 14014, 1014, 12006); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertworkoutitem( 14015, 1015, 12007); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertworkoutitem( 14016, 1016, 12008); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertworkoutitem( 14017, 1017, 12001); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertworkoutitem( 14018, 1018, 12002); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertworkoutitem( 14019, 1019, 12003); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertworkoutitem( 14020, 1020, 12004); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertworkoutitem( 14021, 1021, 12005); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertworkoutitem( 14022, 1022, 12006); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertworkoutitem( 14023, 1023, 12007); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertworkoutitem( 14024, 1024, 12008); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertworkoutitem( 14025, 1025, 12001); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertworkoutitem( 14026, 1026, 12002); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertworkoutitem( 14027, 1027, 12003); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertworkoutitem( 14028, 1028, 12004); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertworkoutitem( 14029, 1029, 12005); END;");
        query.executeUpdate();
        query = em.createNativeQuery("BEGIN p_insertworkoutitem( 14030, 1030, 12006); END;");
        query.executeUpdate();
    }
}
