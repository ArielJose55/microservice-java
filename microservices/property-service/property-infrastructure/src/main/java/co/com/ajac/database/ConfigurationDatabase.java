package co.com.ajac.database;


import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ajac.database.config.JdbiConfigurer;


@Configuration
public class ConfigurationDatabase {
	
	private final JdbiConfigurer jdbiConfigurer;
	
	@Autowired	
	public ConfigurationDatabase(JdbiConfigurer jdbiConfigurer) {
		this.jdbiConfigurer = jdbiConfigurer;
	}

	@Bean
	public Jdbi createConnectionJdbi() {
		return jdbiConfigurer.dataSourcePostgres("jdbc:postgresql://property-database:5432/property-database", "property_user", "root");
	}
}