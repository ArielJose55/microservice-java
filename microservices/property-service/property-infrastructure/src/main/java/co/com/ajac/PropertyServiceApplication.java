package co.com.ajac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PropertyServiceApplication {

	public static void main(String[] args) {
		//File log4jfile = new File("log4j.properties");
		//PropertyConfigurator.configure(log4jfile.getAbsolutePath());
		SpringApplication.run(PropertyServiceApplication.class, args);

	}
}
