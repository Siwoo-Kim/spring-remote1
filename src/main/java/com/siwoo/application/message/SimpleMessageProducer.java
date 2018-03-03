package com.siwoo.application.message;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.TextMessage;

@Log
@Component("simpleMessageProducer")
public class SimpleMessageProducer implements AppMessageProducer{

    @Autowired JmsTemplate jmsTemplate;

    @Override
    public void send(String message){
        /*jmsTemplate.setDeliveryDelay(5000L);*/

        jmsTemplate.send(session -> {
            TextMessage textMessage = session.createTextMessage(message);
            log.warning("Sending message : "+textMessage.getText());
            return textMessage;
        });
    }
}
