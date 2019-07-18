package co.com.ajac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import infrastructure.eventos.AplicacionConfig;
import lombok.extern.log4j.Log4j2;

@Log4j2
@ComponentScan(basePackages = {"co.com.ajac","infrastructure.eventos"})
@SpringBootApplication
public class PropertyServiceApplication {
	
	static {
		System.setProperty("log4j.configurationFile", "log4j2.xml");
	}
	
	@Bean
	public Integer colas(AplicacionConfig aplicacionConfig) {
		log.debug("Queue: {}", aplicacionConfig.getQueue());
		log.debug("Exchange: {}", aplicacionConfig.getExchange());
		return 1;
	}

	public static void main(String[] args) {
		SpringApplication.run(PropertyServiceApplication.class, args);

	}
}
