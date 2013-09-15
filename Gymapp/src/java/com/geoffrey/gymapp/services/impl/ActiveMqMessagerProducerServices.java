/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.impl;

import com.geoffrey.gymapp.services.MessagerProducerServices;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.springframework.stereotype.Service;

/**
 *
 * @author geoffrey
 */
@Service("messagerProducerServices")
public class ActiveMqMessagerProducerServices implements MessagerProducerServices{

    private ConnectionFactory connectionFactory;
    private Connection connection;
    private Session session;
    private Queue destination;
    private MessageProducer producer;
    
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
    public void setupProducer() {
        try {
            this.producer = session.createProducer(destination);
        } catch (JMSException ex) {
            Logger.getLogger(ActiveMqMessagerConsumerServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void sendMessage(String text) {
        try {
            Message message = session.createTextMessage(text);
            producer.send(message);
            session.close();
            connection.close();
        } catch (JMSException ex) {
            Logger.getLogger(ActiveMqMessagerConsumerServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
