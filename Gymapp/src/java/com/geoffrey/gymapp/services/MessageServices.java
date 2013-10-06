/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.services;

import com.geoffrey.gymapp.domain.MQMessage;
import java.util.List;

/**
 *
 * @author 211026298
 */
public interface MessageServices {
    public MQMessage updateMessage(Long id,MQMessage message);
    
    public List<MQMessage> getMessages();
    
    public MQMessage addMessage(MQMessage message);
    
    public MQMessage getMessageByID(long id);
    
    public MQMessage deleteMessage(long id);
}
