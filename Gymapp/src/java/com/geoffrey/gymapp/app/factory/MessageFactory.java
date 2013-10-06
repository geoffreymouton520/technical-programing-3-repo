/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.app.factory;

import com.geoffrey.gymapp.domain.MQMessage;
import java.util.Date;

/**
 *
 * @author geoffrey
 */
public class MessageFactory {
    private static MessageFactory messageFactory;

    private MessageFactory() {
    }
    
    public static MessageFactory getInstance(){
        if (messageFactory == null) {
            messageFactory = new MessageFactory();
        }
        return messageFactory;
    }
    
    public MQMessage getMessage(String message, String queue){
        MQMessage mQMessage = new MQMessage();
       
        mQMessage.setMessage(message);
        mQMessage.setQueue(queue);
        mQMessage.setDateAdded(new Date());
        return mQMessage;
    }
}
