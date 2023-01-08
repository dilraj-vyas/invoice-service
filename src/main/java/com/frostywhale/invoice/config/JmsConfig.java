package com.frostywhale.invoice.config;


import javax.jms.ConnectionFactory;

import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.util.ErrorHandler;

import com.frostywhale.invoice.converter.EventMessageConverter;

@Configuration
public class JmsConfig {


    @Bean
    public MessageConverter myMessageConverter() {
        return new EventMessageConverter();
    }

    @Bean
    public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) {
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
        jmsTemplate.setMessageConverter(myMessageConverter());
        return jmsTemplate;
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(
        DefaultJmsListenerContainerFactoryConfigurer configurer,
        ConnectionFactory connectionFactory,
        ErrorHandler myErrorHandler) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        factory.setErrorHandler(myErrorHandler);
        return factory;
    }

}
