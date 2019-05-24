package co.com.ajac.http.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebConfigurer {
	
	@Bean
	public RestTemplate restTemplateCreater() {
		return new RestTemplate();
	}
}
