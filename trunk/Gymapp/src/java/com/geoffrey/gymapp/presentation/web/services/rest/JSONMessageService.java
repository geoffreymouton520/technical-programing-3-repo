/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.presentation.web.services.rest;
import com.geoffrey.gymapp.app.factory.MessageFactory;
import com.geoffrey.gymapp.domain.MQMessage;
import com.geoffrey.gymapp.presentation.web.services.assembler.MessageResourceAssembler;
import com.geoffrey.gymapp.presentation.web.services.resource.MessageResource;
import java.util.List;
import javax.jms.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author geoffrey
 */
@Controller
@RequestMapping("/json/message")
public class JSONMessageService {
    
    private MessageFactory messageFactory;
    private MessageResourceAssembler betResourceAssembler;
 /*
 public MessageController(MessageService betService,
   MessageResourceAssembler betResourceAssembler) {
  this.betService = betService;
  this.betResourceAssembler = betResourceAssembler;
 }
 */
 @RequestMapping(method = RequestMethod.POST)
 ResponseEntity<MessageResource> createMessage(@RequestBody MQMessage body) {
    MQMessage bet = messageFactory.getMessage("test", "test");//betService.createMessage(body.getMarketId(),
    MessageResource resource = betResourceAssembler.toResource(bet);
    return new ResponseEntity<MessageResource>(resource, HttpStatus.CREATED);
 }
 
 @RequestMapping(method = RequestMethod.PUT, value = "/{betId}")
 ResponseEntity<MessageResource> updateMessage(@PathVariable Long betId,@RequestBody MQMessage body){
    MQMessage bet = messageFactory.getMessage("test", "test");//messageFactory.updateMessage(betId, body);
    MessageResource resource = betResourceAssembler.toResource(bet);
    return new ResponseEntity<MessageResource>(resource, HttpStatus.OK);
 }
 
 @RequestMapping(method = RequestMethod.GET, value = "/{betId}")
 ResponseEntity<MessageResource> getMessage(@PathVariable Long betId){
     messageFactory = MessageFactory.getInstance();
     betResourceAssembler = new MessageResourceAssembler();
    MQMessage bet = messageFactory.getMessage("test", "test");//messageFactory.getMessage(betId);
    //bet.setId(betId);
    
    MessageResource resource = betResourceAssembler.toResource(bet);
    return new ResponseEntity<MessageResource>(resource, HttpStatus.OK);
 }
 /*
 @RequestMapping(method = RequestMethod.GET)
 ResponseEntity<List<MessageResource>> getMessages() {
  //List<MQMessage> betList = messageFactory.getMessage("test", "test");//messageFactory.getAllMessages();
  //List<MessageResource> resourceList = betResourceAssembler.toResources(betList);
  return new ResponseEntity<List<MessageResource>>(resourceList, HttpStatus.OK);
 }
 */
 @RequestMapping(method = RequestMethod.DELETE, value = "/{betId}")
 ResponseEntity<MessageResource> cancelMessage(@PathVariable Long betId) {
     
  MQMessage bet = messageFactory.getMessage("test", "test");//messageFactory.cancelMessage(betId);
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
