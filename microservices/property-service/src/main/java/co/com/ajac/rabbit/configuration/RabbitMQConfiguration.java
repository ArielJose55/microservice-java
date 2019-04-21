package co.com.ajac.rabbit.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

import co.com.ajac.rabbit.receiver.ReceiverAdapter;



@Configuration
public class RabbitMQConfiguration{

	private static final  String EXCHANGE_NAME = "phman_exchange";
	private static final String QUEUE_NAME = "phman_queue";
	private static final String ROUTING_KEY = "authentication.*";
	
	@Bean
	public TopicExchange multicastPhManExchange() {
		return new TopicExchange(EXCHANGE_NAME);
	}
	
	@Bean
    public Queue phManQueue() {
        return new Queue(QUEUE_NAME, true);
    }
	
	@Bean
    Binding binding(final Queue queue, final TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }
	
	@Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
            MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(QUEUE_NAME);
        container.setMessageListener(listenerAdapter);
        return container;
    }
	
	@Bean
    MessageListenerAdapter listenerAdapter(ReceiverAdapter receiver) {
        return new MessageListenerAdapter(receiver, "recibir");
    }
}
