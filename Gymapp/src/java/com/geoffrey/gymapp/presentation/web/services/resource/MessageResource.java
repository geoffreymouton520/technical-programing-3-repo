/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.presentation.web.services.resource;
import com.geoffrey.gymapp.domain.MQMessage;
import org.springframework.hateoas.ResourceSupport;
/**
 *
 * @author geoffrey
 */
public class MessageResource extends ResourceSupport{
    private MQMessage message;

    public MQMessage getMessage() {
        return message;
    }

    public void setMessage(MQMessage message) {
        this.message = message;
    }

    
}
