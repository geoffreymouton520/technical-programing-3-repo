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

/**
 *
 * @author geoffrey
 */
@Path("/json/message")
public class JSONMessageService {
    @GET
	@Path("/get")
	@Produces("application/json")
	public MQMessage getProductInJSON() {
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
