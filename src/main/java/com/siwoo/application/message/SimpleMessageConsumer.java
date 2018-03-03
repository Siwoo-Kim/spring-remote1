package com.siwoo.application.message;

import lombok.extern.java.Log;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Log
@Component("simpleMessageConsumer")
public class SimpleMessageConsumer {

    @JmsListener(destination = "myqueue",containerFactory = "jmsListenerContainerFactory")
    public void onMessage(Message message){
        TextMessage textMessage = (TextMessage) message;

        try {
            log.info("Recieved : "+ textMessage.getText());
        } catch (JMSException e) {
            log.warning("Error "+e);
        }
    }
}
