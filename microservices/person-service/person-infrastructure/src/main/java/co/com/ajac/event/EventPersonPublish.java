package co.com.ajac.event;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.events.EventoMensaje;
import co.com.ajac.events.Publish;
import co.com.ajac.infrastructure.eventos.EventConf;


@Component
public class EventPersonPublish  implements Publish{

	private final RabbitTemplate rabbitTemplate;
	private final EventConf eventConf;

    @Autowired
    public EventPersonPublish(RabbitTemplate rabbitTemplate, EventConf eventConf) {
        this.rabbitTemplate = rabbitTemplate;
        this.eventConf = eventConf;
    } 
	
	@Override
	public EventoMensaje onMessage(EventoMensaje mensaje) {
		rabbitTemplate.convertAndSend(eventConf.getQueue(), mensaje);
		return mensaje;
	}

}
