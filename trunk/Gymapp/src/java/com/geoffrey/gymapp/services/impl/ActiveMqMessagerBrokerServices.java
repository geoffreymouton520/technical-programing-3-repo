/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services.impl;

import com.geoffrey.gymapp.services.MessagerBrokerServices;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.TransportConnector;

import org.springframework.stereotype.Service;

/**
 *
 * @author geoffrey
 */
@Service("messagerBrokerServices")
public class ActiveMqMessagerBrokerServices implements MessagerBrokerServices{
    private BrokerService brokerService;
    private TransportConnector transportConnector;
    private URI uri;
    
    @Override
    public void startBroker() {
        if (brokerService != null) {
            if (!brokerService.isStarted()) {
                if (transportConnector != null) {
                    setupService();
                }
            }
        }else{
            brokerService = new BrokerService();
            if (transportConnector != null) {
                    setupService();
            }else{
                transportConnector = new TransportConnector();
                setupService();
            }
        }
    }

    @Override
    public void setBroker(BrokerService brokerService) {
        this.brokerService = brokerService;
    }

    @Override
    public void setTransportConnector(TransportConnector transportConnector) {
        this.transportConnector = transportConnector;
    }

    @Override
    public void setUri(URI uri) {
        this.uri = uri;
    }

    private void setupService() {
        transportConnector.setUri(uri);
        try {
            brokerService.addConnector(transportConnector);
            brokerService.start();
        } catch (Exception ex) {
            Logger.getLogger(ActiveMqMessagerBrokerServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
