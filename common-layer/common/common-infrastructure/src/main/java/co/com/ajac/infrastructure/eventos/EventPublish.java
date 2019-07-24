package co.com.ajac.infrastructure.eventos;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;

@Configuration
public class EventPublish {

	@Autowired
	private EventConf aplicacionConfig;

	@Bean
	Queue queue() {
		return new Queue(aplicacionConfig.getQueue(), false);
	}

	@Bean
	Exchange exchange() {
		return new DirectExchange(aplicacionConfig.getExchange());
	}

	@Bean
	Binding binding(Queue queue, DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(aplicacionConfig.getQueue());
	}

	@Bean
	public MappingJackson2MessageConverter jackson2MessageConverter() {
		return new MappingJackson2MessageConverter();
	}
}
