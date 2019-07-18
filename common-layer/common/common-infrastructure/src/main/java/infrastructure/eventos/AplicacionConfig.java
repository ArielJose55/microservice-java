package infrastructure.eventos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:rabbit-config.properties")
public class AplicacionConfig {


	@Value("${queue.name}")
	private String queue;
	
	@Value("${exchange.name}")
	private String exchange;

	public String getExchange() {
		return exchange;
	}

	public String getQueue() {
		return queue;
	}
}

