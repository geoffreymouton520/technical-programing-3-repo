/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.impl;

import com.geoffrey.gymapp.app.factory.MessageFactory;
import com.geoffrey.gymapp.domain.MQMessage;
import com.geoffrey.gymapp.services.MessagerBrokerServices;
import com.geoffrey.gymapp.services.MessagerConsumerServices;
import com.geoffrey.gymapp.services.MessagerProducerServices;
import com.geoffrey.gymapp.services.crud.MessageCrudService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.TransportConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author geoffrey
 */
@Service("messageServices")
public class MessageServicesImpl {
    @Autowired
    private MessagerBrokerServices messagerBrokerServices;
    
    @Autowired
    private MessagerProducerServices messagerProducerServices;
    
    @Autowired
    private MessagerConsumerServices messagerConsumerServices;
    
    @Autowired
    private MessageCrudService messageCrudService;
    
    public void setupMom(){
        messagerBrokerServices.setBroker(new BrokerService());
        messagerBrokerServices.setTransportConnector(new TransportConnector());
        try {
            messagerBrokerServices.setUri(new URI("tcp://localhost:61616"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(MessageServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        messagerBrokerServices.startBroker();
    }
    
    public void sendMessage(String message,String queue){
        messagerProducerServices.setConnectionFactory(new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL));
        messagerProducerServices.createConnection();
        messagerProducerServices.createSession(false, Session.AUTO_ACKNOWLEDGE);
        messagerProducerServices.createDestination(queue);
        messagerProducerServices.setupProducer();
        
        messagerProducerServices.sendMessage(message);
    }
    
    public String recieveMessage(String queue){
        try {
            messagerConsumerServices.setConnectionFactory(new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL));
            messagerConsumerServices.createConnection();
            messagerConsumerServices.createSession(false, Session.AUTO_ACKNOWLEDGE);
            messagerConsumerServices.createDestination(queue);
            messagerConsumerServices.setupConsumer();
            
            messagerConsumerServices.receiveMessage();
            
            TextMessage messsage = messagerConsumerServices.getMessage();
            MessageFactory messageFactory = MessageFactory.getInstance();
            MQMessage mQMessage = messageFactory.getMessage(messsage.getText(), queue);
            messageCrudService.persist(mQMessage);
            
            return mQMessage.getMessage();
        } catch (JMSException ex) {
            Logger.getLogger(MessageServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }
}
