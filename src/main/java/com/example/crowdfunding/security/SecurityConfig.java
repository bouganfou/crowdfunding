package com.example.crowdfunding.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configurable
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private DataSource dataSource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//		.withUser("admin").password("123")
//		.roles("ADMIN","USER");
//		auth.inMemoryAuthentication()
//		.withUser("user").password("123")
//		.roles("USER");
		auth.jdbcAuthentication()
		.dataSource(dataSource).usersByUsernameQuery("select username as principale,password_hash as credentials,activated from users where username=? ")
		.authoritiesByUsernameQuery("select username as principale,role as role from users_roles where username=? ")
		.rolePrefix("ROLE_");
		//.passwordEncoder(new Md5PasswordEncoder());


		
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login");
		//http.authorizeRequests().anyRequest().authenticated();
		http.authorizeRequests().antMatchers("/projets","/entrepreneurs","/contributeurs").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/projets").hasRole("USER");
		http.exceptionHandling().accessDeniedPage("/403");
	}


 @Bean
public static NoOpPasswordEncoder passwordEncoder() {
 return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
}

}
