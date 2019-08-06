package co.com.ajac.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityAuth extends WebSecurityConfigurerAdapter{

	private final UsuarioSecurity usuarioSecurity;
	
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public SecurityAuth(UsuarioSecurity usuarioSecurity, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.usuarioSecurity = usuarioSecurity;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioSecurity).passwordEncoder(bCryptPasswordEncoder);
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
        	.anyRequest()
        	.permitAll()
        	.and()
	        .csrf()
	        .disable();
    }
}
