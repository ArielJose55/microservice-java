package co.com.ajac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy // Declara un proxy inverso
public class PersonServiceApplication {

	static {
        System.setProperty("log4j.configurationFile", "../log4j2.xml");
    }
	
	public static void main(String[] args) {
		SpringApplication.run(PersonServiceApplication.class, args);
	}
}

