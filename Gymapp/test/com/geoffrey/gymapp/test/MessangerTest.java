/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.test;

import com.geoffrey.gymapp.app.factory.MessageFactory;
import com.geoffrey.gymapp.domain.MQMessage;
import com.geoffrey.gymapp.services.MessageServices;
import com.geoffrey.gymapp.services.MessagerBrokerServices;
import com.geoffrey.gymapp.services.MessagerConsumerServices;
import com.geoffrey.gymapp.services.MessagerProducerServices;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.TransportConnector;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author geoffrey
 */
public class MessangerTest {
    private static ApplicationContext ctx;
    //@Autowired
    public MessagerBrokerServices messagerBrokerServices;
    
    //@Autowired
    public MessagerProducerServices messagerProducerServices;
    
    //@Autowired
    public MessagerConsumerServices messagerConsumerServices;
    public MessangerTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @BeforeClass
    public void setUpClass() throws Exception {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
        messagerBrokerServices = (MessagerBrokerServices) ctx.getBean("messagerBrokerServices");
        messagerBrokerServices.setBroker(new BrokerService());
        messagerBrokerServices.setTransportConnector(new TransportConnector());
        messagerBrokerServices.setUri(new URI("tcp://localhost:61616"));
        messagerBrokerServices.startBroker();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
    
    @Test
    public void sayHello(){
        messagerProducerServices = (MessagerProducerServices) ctx.getBean("messagerProducerServices");
        messagerProducerServices.setConnectionFactory(new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL));
        messagerProducerServices.createConnection();
        messagerProducerServices.createSession(false, Session.AUTO_ACKNOWLEDGE);
        messagerProducerServices.createDestination("HelloQueue");
        messagerProducerServices.setupProducer();
        
        messagerProducerServices.sendMessage("Hello World");
        
        messagerConsumerServices = (MessagerConsumerServices) ctx.getBean("messagerConsumerServices");
        messagerConsumerServices.setConnectionFactory(new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL));
        messagerConsumerServices.createConnection();
        messagerConsumerServices.createSession(false, Session.AUTO_ACKNOWLEDGE);
        messagerConsumerServices.createDestination("HelloQueue");
        messagerConsumerServices.setupConsumer();
        
        messagerConsumerServices.receiveMessage();
        TextMessage messsage = messagerConsumerServices.getMessage();
        try {
            Assert.assertEquals(messsage.getText(), "Hello World");
        } catch (JMSException ex) {
            Logger.getLogger(MessangerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void create(){
        MessageServices messageServices = (MessageServices) ctx.getBean("messageServices");
        MessageFactory messageFactory = MessageFactory.getInstance();
        MQMessage message = messageFactory.getMessage("test", "test");
        messageServices.addMessage(message);//messageFactory.getMessage(betId);
        
        Assert.assertNotNull(message);
    }
}