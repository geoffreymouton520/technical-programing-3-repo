/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.presentation.web.services.rest;
import com.geoffrey.gymapp.app.factory.MessageFactory;
import com.geoffrey.gymapp.domain.MQMessage;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author geoffrey
 */
@Controller
@RequestMapping("/json/message")
public class JSONMessageService {
    
    @RequestMapping("get")
    @ResponseBody
    public MQMessage getMessageInJSON() {
            MessageFactory messageFactory = MessageFactory.getInstance();
            MQMessage mQMessage = messageFactory.getMessage("Hello World", "Greeting");

            return mQMessage; 

    }
 /*
	@POST
	@Path("/post")
	@Consumes("application/json")
	public Response createProductInJSON(MQMessage mQMessage) {
 
		String result = "Product created : " + product;
		return Response.status(201).entity(result).build();
 
	}*/
}
