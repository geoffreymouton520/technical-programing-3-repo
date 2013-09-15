/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.presentation.web.services.resource;
import java.util.Date;
import org.springframework.hateoas.ResourceSupport;
/**
 *
 * @author geoffrey
 */
public class MessagerResource extends ResourceSupport{
    private String message;
    private String queue;
    private Date dateAdded;


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
