package co.com.ajac.database.config;


import org.jdbi.v3.core.Jdbi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ajac.infrastructure.database.JdbiConfigurer;

@Configuration
public class DatabaseConfig {
	
	@Bean
	public Jdbi createConnectionJdbi(JdbiConfigurer jdbiConfigurer) {
		return jdbiConfigurer.dataSourcePostgres(
				"jdbc:postgresql://localhost:5432/phman?currentSchema=property",
				"property",
				"property#");
	}
}