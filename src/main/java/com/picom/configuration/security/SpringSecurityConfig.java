package com.picom.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.picom.security.CustomAuthenticationManager;

@Configuration 
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	private UserDetailsService userDetailsService;
	private PasswordEncoder passwordEncoder;
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		 http.csrf().disable()
		 
		 .authenticationManager(new CustomAuthenticationManager(userDetailsService, passwordEncoder)) 
		 
		 .formLogin()
		 	.loginPage("/connexion")
		 	.loginProcessingUrl("/connexion")
		 	.and()
		 	.logout()
		 	.logoutUrl("/deconnexion")
		 	.and()
         .authorizeRequests()
         .antMatchers("/admin/**").hasRole("ADMIN")
         .antMatchers("/client/**").hasRole("CLIENT")
         .anyRequest().authenticated()
         .and()
   
		  // Pour la console H2 (à ne pas utiliser en prod)
    
         .headers().frameOptions().disable();
       
		 return http.build();
		 
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	      auth.inMemoryAuthentication()
	         .withUser("springuser@orsys.fr").password(passwordEncoder().encode("spring123")).roles("CLIENT")
	         .and()
	         .withUser("springadmin@orsys.fr").password(passwordEncoder().encode("admin123")).roles("ADMIN");
	      
	}


	
}
