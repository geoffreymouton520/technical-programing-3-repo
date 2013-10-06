/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.presentation.web.services.rest;
import com.geoffrey.gymapp.app.factory.MessageFactory;
import com.geoffrey.gymapp.domain.MQMessage;
import com.geoffrey.gymapp.presentation.web.services.assembler.MessageResourceAssembler;
import com.geoffrey.gymapp.presentation.web.services.resource.MessageResource;
import com.geoffrey.gymapp.services.MessageServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author geoffrey
 */
@Controller
@RequestMapping("/rest/message")
public class RESTMessageService {
    @Autowired
    @Qualifier("messageServices")
    private MessageServices messageServices;
    
    @Autowired
    @Qualifier("messageResourceAssembler")
    private MessageResourceAssembler betResourceAssembler;

    ResponseEntity<MessageResource> createMessage(@RequestBody MQMessage body) {   
        MQMessage message = messageServices.addMessage(body);
        MessageResource resource = betResourceAssembler.toResource(message);
        return new ResponseEntity<MessageResource>(resource, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{betId}")
    ResponseEntity<MessageResource> updateMessage(@PathVariable Long messageId,@RequestBody MQMessage body){
        MQMessage message = messageServices.updateMessage(messageId, body);
        MessageResource resource = betResourceAssembler.toResource(message);
        return new ResponseEntity<MessageResource>(resource, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{betId}")
    ResponseEntity<MessageResource> getMessage(@PathVariable Long betId){
        //messageServices = MessageFactory.getInstance();
        //betResourceAssembler = new MessageResourceAssembler();
        MessageFactory messageFactory = MessageFactory.getInstance();
        MQMessage message = messageFactory.getMessage("test", "test");
        MQMessage returnedMessage = messageServices.addMessage(message);//messageFactory.getMessage(betId);
        MessageResource resource = betResourceAssembler.toResource(returnedMessage);
        return new ResponseEntity<MessageResource>(resource, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<MessageResource>> getMessages() {
        List<MQMessage> messages = messageServices.getMessages();//messageFactory.getAllMessages();
        List<MessageResource> resourceList = betResourceAssembler.toResources(messages);
        return new ResponseEntity<List<MessageResource>>(resourceList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{betId}")
    ResponseEntity<MessageResource> cancelMessage(@PathVariable Long id) {
        MQMessage bet = messageServices.deleteMessage(id);//messageFactory.cancelMessage(betId);
        MessageResource resource = betResourceAssembler.toResource(bet);
        return new ResponseEntity<MessageResource>(resource, HttpStatus.OK);
    }
 /*
 @ExceptionHandler
 ResponseEntity handleExceptions(Exception ex) {
  ResponseEntity responseEntity = null;
  if (ex instanceof MessageNotFoundException) {
   responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
  } else if (ex instanceof MessageNotUnmatchedException) {
   responseEntity = new ResponseEntity(HttpStatus.CONFLICT);
  } else {
   responseEntity = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
  }
  return responseEntity;
  * /
 }
    
    
    
    
    
 /*   @RequestMapping("get")
    @ResponseBody
    public MQMessage getMessageInJSON() {
            MessageFactory messageFactory = MessageFactory.getInstance();
            MQMessage mQMessage = messageFactory.getMessage("Hello World", "Greeting");

            return mQMessage; 

    }*/
 /*
	@POST
	@Path("/post")
	@Consumes("application/json")
	public Response createProductInJSON(MQMessage mQMessage) {
 
		String result = "Product created : " + product;
		return Response.status(201).entity(result).build();
 
	}*/
}
