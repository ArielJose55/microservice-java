package co.com.ajac.rabbit.receiver;

import org.springframework.stereotype.Component;

@Component
public class ReceiverAdapter {

	public void recibir(String message) {
		System.out.println("Message Recivido: " + message);
	}
}
