package co.com.ajac.eventos;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import events.EventoMensaje;
import events.Publish;
import infrastructure.eventos.AplicacionConfig;

@Component
public class EventPublish  implements Publish{

	private final RabbitTemplate rabbitTemplate;
	private final AplicacionConfig aplicacionConfig;

    @Autowired
    public EventPublish(RabbitTemplate rabbitTemplate, AplicacionConfig aplicacionConfig) {
        this.rabbitTemplate = rabbitTemplate;
        this.aplicacionConfig = aplicacionConfig;
    } 
	
	@Override
	public EventoMensaje onMessage(EventoMensaje mensaje) {
		rabbitTemplate.convertAndSend(aplicacionConfig.getQueue(), mensaje);
		return mensaje;
	}

}
