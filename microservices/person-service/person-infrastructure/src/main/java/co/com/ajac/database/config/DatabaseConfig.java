package co.com.ajac.database.config;


import org.jdbi.v3.core.Jdbi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import infrastructure.database.JdbiConfigurer;

@Configuration
public class DatabaseConfig {

	@Bean
	public JdbiConfigurer createConnector() {
		return new JdbiConfigurer();
	}
	
	@Bean
	public Jdbi createConnectionJdbi(JdbiConfigurer jdbiConfigurer) {
		return jdbiConfigurer.dataSourcePostgres("jdbc:postgresql://person-database:5432/person-database", "person_user", "root");
	}
}