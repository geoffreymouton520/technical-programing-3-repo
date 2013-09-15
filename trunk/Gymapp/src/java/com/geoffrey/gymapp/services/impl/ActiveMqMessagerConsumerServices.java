/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.impl;

import com.geoffrey.gymapp.services.MessagerConsumerServices;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.springframework.stereotype.Service;

/**
 *
 * @author geoffrey
 */
@Service("messagerConsumerServices")
public class ActiveMqMessagerConsumerServices implements MessagerConsumerServices{

    private ConnectionFactory connectionFactory;
    private Connection connection;
    private Session session;
    private Queue destination;
    private MessageConsumer consumer;
    private TextMessage message;
    @Override
    public void setConnectionFactory(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public void createConnection() {
        try{
            this.connection = connectionFactory.createConnection();
            connection.start();
        }catch(JMSException ex){
            Logger.getLogger(ActiveMqMessagerConsumerServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void createSession(Boolean transacted, int acknowledgeMode) {
        try {
            this.session = connection.createSession(transacted, acknowledgeMode);
        } catch (JMSException ex) {
            Logger.getLogger(ActiveMqMessagerConsumerServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void createDestination(String name) {
        try {
            this.destination = session.createQueue(name);
        } catch (JMSException ex) {
            Logger.getLogger(ActiveMqMessagerConsumerServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setupConsumer() {
        try {
            this.consumer = session.createConsumer(destination);
        } catch (JMSException ex) {
            Logger.getLogger(ActiveMqMessagerConsumerServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void receiveMessage() {
        try {
            this.message = (TextMessage) consumer.receive();
            consumer.close();
            session.close();
            connection.close();
        } catch (JMSException ex) {
            Logger.getLogger(ActiveMqMessagerConsumerServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public TextMessage getMessage(){
        return message;
    }
}
