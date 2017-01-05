package com.eleganz.main.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * <p>
 * AppSecurityConfigAdapter class.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class AppSecurityConfigAdapter extends WebSecurityConfigurerAdapter {

	@Value("${app.vendor.path}")
	private String vendorPath;

	@Value("${app.public.path}")
	private String publicPath;

	@Value("${app.admin.path}")
	private String adminPath;

	@Autowired
	private UserDetailsService userDetailsService;

	/** {@inheritDoc} */
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userDetailsService)
			.passwordEncoder(new BCryptPasswordEncoder());
	}

	/** {@inheritDoc} */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/welcome/**", vendorPath, publicPath).permitAll()
				.antMatchers("/admin/**", adminPath).hasAuthority("ROLE_ADMIN")
				.and()
				.formLogin().loginPage("/").permitAll()
					.defaultSuccessUrl("/panel", true)
					.failureUrl("/#/login?error")
				.and()
				.logout().permitAll()
					.logoutSuccessUrl("/#/inicio")
				.and()
				.csrf().disable();
	}
}
