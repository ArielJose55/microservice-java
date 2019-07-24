package co.com.ajac.infrastructure.eventos;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

@EnableRabbit
@Configuration
public class EventConsumer implements RabbitListenerConfigurer{	
	
    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {
        rabbitListenerEndpointRegistrar.setMessageHandlerMethodFactory(defaultMessageHandlerMethodFactory());
    }

    @Bean
    public DefaultMessageHandlerMethodFactory defaultMessageHandlerMethodFactory(){
        DefaultMessageHandlerMethodFactory defaultMessageHandlerMethodFactory = new DefaultMessageHandlerMethodFactory();
        defaultMessageHandlerMethodFactory.setMessageConverter(mappingJackson2MessageConverter());
        return  defaultMessageHandlerMethodFactory;
    }

    private MappingJackson2MessageConverter mappingJackson2MessageConverter(){
        return new MappingJackson2MessageConverter();
    }
}
