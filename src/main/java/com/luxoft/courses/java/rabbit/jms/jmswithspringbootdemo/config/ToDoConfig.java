package com.luxoft.courses.java.rabbit.jms.jmswithspringbootdemo.config;

import com.luxoft.courses.java.rabbit.jms.jmswithspringbootdemo.errorhandler.ToDoErrorHandler;
import com.luxoft.courses.java.rabbit.jms.jmswithspringbootdemo.validator.ToDoValidator;
import javax.jms.ConnectionFactory;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListenerConfigurer;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerEndpointRegistrar;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

@Configuration
public class ToDoConfig {

  @Bean
  public MessageConverter jacksonJmsMessageConverter() {
    MappingJackson2MessageConverter converter = new
                                                    MappingJackson2MessageConverter();
    converter.setTargetType(MessageType.TEXT);
    converter.setTypeIdPropertyName("_class_");
    return converter;
  }

  @Bean
  public JmsListenerContainerFactory<?> jmsFactory(ConnectionFactory
                                                       connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
    DefaultJmsListenerContainerFactory factory = new
                                                     DefaultJmsListenerContainerFactory();
        factory.setErrorHandler(new ToDoErrorHandler());
    configurer.configure(factory, connectionFactory);
    return factory;
  }

  @Configuration
  static class MethodListenerConfig implements JmsListenerConfigurer {
    @Override
    public void configureJmsListeners(JmsListenerEndpointRegistrar
                                          jmsListenerEndpointRegistrar) {
      jmsListenerEndpointRegistrar.setMessageHandlerMethodFactory
                                       (myHandlerMethodFactory());
    }

    @Bean
    public DefaultMessageHandlerMethodFactory myHandlerMethodFactory() {
      DefaultMessageHandlerMethodFactory factory = new
                                                       DefaultMessageHandlerMethodFactory();
      factory.setValidator(new ToDoValidator());
      return factory;
    }
  }
}
