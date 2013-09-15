/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services;

import javax.jms.ConnectionFactory;
import javax.jms.TextMessage;

/**
 *
 * @author geoffrey
 */
public interface MessagerConsumerServices {
    void setConnectionFactory(ConnectionFactory connectionFactory);
    void createConnection();
    void createSession(Boolean transacted,int acknowledgeMode);
    void createDestination(String name);
    void setupConsumer();
    void receiveMessage();
    TextMessage getMessage();
}
