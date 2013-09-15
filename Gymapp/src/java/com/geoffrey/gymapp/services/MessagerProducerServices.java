/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services;

import javax.jms.ConnectionFactory;

/**
 *
 * @author geoffrey
 */
public interface MessagerProducerServices {
    void setConnectionFactory(ConnectionFactory connectionFactory);
    void createConnection();
    void createSession(Boolean transacted,int acknowledgeMode);
    void createDestination(String name);
    void setupProducer();
    void sendMessage(String text);
}
