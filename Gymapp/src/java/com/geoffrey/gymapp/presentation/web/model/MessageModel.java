/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.presentation.web.model;

import java.util.Date;

/**
 *
 * @author geoffrey
 */
public class MessageModel {
    private Long messageId;
    private String message;
    private String queue;
    private Date dateAdded;

    public MessageModel() {}

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getQueue() {
        return queue;
    }
    
    public void setQueue(String queue) {
        this.queue = queue;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }
}
