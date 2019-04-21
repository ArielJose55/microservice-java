package co.com.ajac.rabbitmq.adapters;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import co.com.ajac.ports.Notify;

@Component
public class NotifierRabbitmq implements Notify{

	private static final  String EXCHANGE_NAME = "phman_exchange";
	private static final String ROUTING_KEY = "authentication.rx";
	
	private final RabbitTemplate rabbitTemplate;
	
	public NotifierRabbitmq(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	@Override
	public void sendResult(String message) {
		rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, message);
	}

}
