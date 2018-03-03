package com.siwoo.application.config;

import com.siwoo.application.service.SingerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

@Configuration
public class RemoteClientConfig {

    @Bean
    SingerService singerService(){
        HttpInvokerProxyFactoryBean httpInvokerProxyFactoryBean = new HttpInvokerProxyFactoryBean();
        httpInvokerProxyFactoryBean.setServiceUrl("http://localhost:8080/httpInvoker/singerService");
        httpInvokerProxyFactoryBean.setServiceInterface(SingerService.class);
        httpInvokerProxyFactoryBean.afterPropertiesSet();
        return (SingerService) httpInvokerProxyFactoryBean.getObject();
    }
}
