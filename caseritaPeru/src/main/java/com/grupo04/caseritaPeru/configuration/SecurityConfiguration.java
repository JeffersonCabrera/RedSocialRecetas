package com.grupo04.caseritaPeru.configuration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private static final Log LOG = LogFactory.getLog(SecurityConfiguration.class);
	
	@Autowired
	@Qualifier("tmUsuarioSCService")
	private  UserDetailsService userDetailsService;
	 	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		LOG.info("configure : http authorizeRequests() -- " + http.authorizeRequests().toString());
		 http.authorizeRequests()
			 	.antMatchers("/css/*","/imgs/*","/fonts/*").permitAll()
			 	.antMatchers("/addUsuFrm").permitAll()
			 	.antMatchers("/addUsu").permitAll()
			 	.anyRequest().authenticated()
			 	.and()
		 	.formLogin().loginPage("/login").loginProcessingUrl("/loginCheck")
		 	.usernameParameter("username").passwordParameter("password")
		 	.defaultSuccessUrl("/loginsuccess").permitAll()
		 	.and()
		 	.logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout")
		 	.permitAll()
		 	 ;
	}
}
