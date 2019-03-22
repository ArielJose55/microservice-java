package co.com.ajac.database.config;

import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {
	
	private final JdbiConfigurer jdbiConfigurer;
	
	@Autowired	
	public DatabaseConfig(JdbiConfigurer jdbiConfigurer) {
		this.jdbiConfigurer = jdbiConfigurer;
	}

	@Bean
	public Jdbi createConnectionJdbi() {
		return jdbiConfigurer.dataSourcePostgres("jdbc:postgresql://device-database:5432/device-database", "device_user", "root");
	}
}
