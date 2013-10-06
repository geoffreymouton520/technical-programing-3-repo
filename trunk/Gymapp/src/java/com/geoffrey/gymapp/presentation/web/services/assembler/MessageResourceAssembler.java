/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.presentation.web.services.assembler;

import com.geoffrey.gymapp.domain.MQMessage;
import com.geoffrey.gymapp.presentation.web.services.resource.MessageResource;
import com.geoffrey.gymapp.presentation.web.services.rest.RESTMessageService;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import org.springframework.stereotype.Service;

/**
 *
 * @author geoffrey
 */
@Service("messageResourceAssembler")
public class MessageResourceAssembler extends ResourceAssemblerSupport<MQMessage, MessageResource>{

    public MessageResourceAssembler() {
        super(RESTMessageService.class, MessageResource.class);
    }

    
    @Override
    public MessageResource toResource(MQMessage t) {
        MessageResource messagerResource = instantiateResource(t);
        messagerResource.setMessage(t);
        messagerResource.add(linkTo(RESTMessageService.class).slash(t.getId()).withSelfRel());
        return messagerResource;
    }
}
