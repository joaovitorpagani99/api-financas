package com.dev.despesa.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

	public static final String[] ENDPOINTS_WITH_AUTHENTICATION_NOT_REQUIRED = {
			"/auth", // url que usaremos para fazer login
			"/usuario" // url que usaremos para criar um usuário
	};

	/*
	 * public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	 * http.csrf(csrf -> csrf.disable())
	 * .authorizeHttpRequests((request) -> request
	 * .requestMatchers("/usuario").permitAll()
	 * .anyRequest()
	 * .authenticated());
	 * return http.build();
	 * }
	 */

	/*
	 * @Override
	 * public void configure(AuthenticationManagerBuilder auth) throws Exception {
	 * auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	 * }
	 * 
	 * @Override
	 * public void configure(WebSecurity http) throws Exception {
	 * http.ignoring().requestMatchers("/actuator/**");
	 * }
	 */
}
