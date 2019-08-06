package co.com.ajac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://192.168.1.8:4200")
@ComponentScan(basePackages = {"co.com.ajac"})
@SpringBootApplication
public class PersonServiceApplication {

	static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }
	
	public static void main(String[] args) {
		SpringApplication.run(PersonServiceApplication.class, args);
	}
}

