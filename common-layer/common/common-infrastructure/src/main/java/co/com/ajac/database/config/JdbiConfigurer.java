package co.com.ajac.database.config;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.postgres.PostgresPlugin;
import org.springframework.stereotype.Component;

@Component
public class JdbiConfigurer {

	public Jdbi dataSourcePostgres(String url, String user, String password) {
		return Jdbi.create(url, user, password)
				.installPlugin(new PostgresPlugin());
	}
}
