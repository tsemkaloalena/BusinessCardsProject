package com.tsemkalo.businesscards.configuration;

import com.tsemkalo.businesscards.configuration.filters.JWTAuthorizationFilter;
import com.tsemkalo.businesscards.exceptions.handler.CustomAccessDeniedHandler;
import com.tsemkalo.businesscards.exceptions.SecurityConfigurationException;
import com.tsemkalo.businesscards.service.AuthorizationServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.util.Arrays;

@Slf4j
@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private AuthorizationServiceImpl authorizationService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	@Qualifier("delegatedAuthenticationEntryPoint")
	private AuthenticationEntryPoint authenticationEntryPoint;

	@Override
	protected void configure(HttpSecurity http) {
		try {
			http.csrf().disable()
					.cors().and()
					.authorizeRequests()
					.antMatchers(HttpMethod.POST, "/user/sign_up", "/user/forgot_password", "/user/reset_password/*", "/user/activate_account/*").permitAll()
					.antMatchers(HttpMethod.GET, "/user/login").permitAll()
					.anyRequest().authenticated()
					.and()
					.formLogin().permitAll()
					.and()
					.logout().permitAll()
					.and()
					.exceptionHandling()
					.accessDeniedHandler(accessDeniedHandler())
					.authenticationEntryPoint(authenticationEntryPoint)
					.and()
//					.addFilter(new JWTAuthenticationFilter(authenticationManager()))
					.addFilter(new JWTAuthorizationFilter(authenticationManager(), authorizationService))
					.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		} catch (Exception exception) {
			log.error(Arrays.toString(exception.getStackTrace()));
			throw new SecurityConfigurationException(Arrays.toString(exception.getStackTrace()));
		}
	}

	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) {
		try {
			authenticationManagerBuilder.userDetailsService(authorizationService).passwordEncoder(bCryptPasswordEncoder);
		} catch (Exception exception) {
			log.error(Arrays.toString(exception.getStackTrace()));
			throw new SecurityConfigurationException(Arrays.toString(exception.getStackTrace()));
		}
	}

	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
}
