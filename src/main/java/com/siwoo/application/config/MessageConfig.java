package com.siwoo.application.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;


@ComponentScan("com.siwoo.application.message")
@EnableJms
@Configuration
public class MessageConfig {


    @Bean("myqueue")
    public Queue myQueue(){
        return new ActiveMQQueue("myqueue");
    }


    @Bean
    public ConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616"); //Openwire
        activeMQConnectionFactory.setUserName("admin");
        activeMQConnectionFactory.setPassword("admin");
        return activeMQConnectionFactory;
    }

    @Bean
    public JmsListenerContainerFactory<DefaultMessageListenerContainer> jmsListenerContainerFactory(){
        DefaultJmsListenerContainerFactory defaultMessageListenerContainer = new DefaultJmsListenerContainerFactory();
        defaultMessageListenerContainer.setConnectionFactory(connectionFactory());
        defaultMessageListenerContainer.setConcurrency("3-5");
        return defaultMessageListenerContainer;
    }

    @Bean JmsTemplate jmsTemplate(){
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory());
        jmsTemplate.setDefaultDestination(myQueue());
        return jmsTemplate;
    }

}
