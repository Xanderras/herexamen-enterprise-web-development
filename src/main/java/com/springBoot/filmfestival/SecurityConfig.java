package com.springBoot.filmfestival;

import java.security.spec.EncodedKeySpec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//PasswordEncoder encoder =  
               // PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
        .withUser("user").password(passwordEncoder().encode("user")).roles("USER").and()
		.withUser("jurylid").password(passwordEncoder().encode("jurylid")).roles("USER", "JURY").and()
		.withUser("admin").password(passwordEncoder().encode("admin")).roles("USER", "JURY", "ADMIN");
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		 http.formLogin().
         defaultSuccessUrl("/", true).
         loginPage("/login");
		 
		 http.authorizeRequests()
		 .antMatchers("/").hasRole("USER")
		 .antMatchers("/filmfestival/*").hasRole("ADMIN").and().csrf();
    }
}
