package com.example.employeemangement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
/**
 * This class maintains all
 * security related configuration  for the application 
 * @author saitheja macharla
 *
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter  {
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
	throws Exception {
	auth.
	inMemoryAuthentication()
	.withUser("user").password("{noop}password").roles("USER").and()
	.withUser("admin").password("{noop}password").roles("USER","ADMIN");
	}
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    http
	          .authorizeRequests()
	            .antMatchers("/api/languages/**").hasRole("ADMIN")
	            .antMatchers("/api/departments/**").hasRole("ADMIN")
	            .antMatchers("/api/employees/**").hasRole("ADMIN")
	            .antMatchers("/api/h2-console/**").permitAll()
	            .and()
	          .httpBasic()
	            .and()
         .csrf().disable();   
	    http.headers().frameOptions().disable();
	    }
	
}
