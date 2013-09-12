/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services;

import java.net.URI;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.TransportConnector;

/**
 *
 * @author geoffrey
 */
public interface MessagerBrokerServices {
    void startBroker();
    void setBroker(BrokerService brokerService);
    void setTransportConnector(TransportConnector transportConnector);
    void setUri(URI uri);
}
