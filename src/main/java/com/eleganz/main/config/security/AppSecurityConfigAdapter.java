package com.eleganz.main.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * <p>
 * AppSecurityConfigAdapter class.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@Configuration
@EnableWebSecurity
public class AppSecurityConfigAdapter extends WebSecurityConfigurerAdapter {

	@Value("${app.public.path}")
	private String publicPath;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("password").roles("USER");
	}

	/** {@inheritDoc} */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers(publicPath).permitAll()
				.antMatchers("/welcome/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin().loginPage("/").permitAll()
					.defaultSuccessUrl("/main", true)
					.failureUrl("/#/login?error")
				.and()
				.logout().permitAll()
					.logoutSuccessUrl("/#/login?logout")
				.and()
				.csrf().disable();
	}
}
