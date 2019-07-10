package infrastructure.database;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.jackson2.Jackson2Plugin;
import org.jdbi.v3.postgres.PostgresPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.jdbi.v3.vavr.VavrPlugin;
import org.springframework.stereotype.Component;

@Component
public class JdbiConfigurer {

	public Jdbi dataSourcePostgres(String url, String user, String password) {
		return Jdbi.create(url, user, password)
				.installPlugin(new SqlObjectPlugin())
                .installPlugin(new VavrPlugin())
                .installPlugin(new PostgresPlugin())
                .installPlugin(new Jackson2Plugin());
	}
}
