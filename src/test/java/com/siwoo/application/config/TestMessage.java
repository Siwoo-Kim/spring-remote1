package com.siwoo.application.config;

import com.siwoo.application.message.SimpleMessageProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MessageConfig.class)
public class TestMessage {

    @Autowired SimpleMessageProducer simpleMessageProducer;

    @Test
    public void testSendingMessage() throws InterruptedException {

        for(int i=0;i<5;i++){
            simpleMessageProducer.send("Message "+i);
            Thread.sleep(2000);
        }

    }
}
