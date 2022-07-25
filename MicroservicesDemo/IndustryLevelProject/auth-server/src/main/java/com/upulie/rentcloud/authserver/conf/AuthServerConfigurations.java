package com.upulie.rentcloud.authserver.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

//defining the client
@Configuration
public class AuthServerConfigurations extends WebSecurityConfigurerAdapter implements AuthorizationServerConfigurer{

	//used to encode the password
	PasswordEncoder passwordEncoder=PasswordEncoderFactories.createDelegatingPasswordEncoder();
	
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}
	
	@Lazy //to remove the cycle dependencies
	@Autowired
	AuthenticationManager authenticationManager;
	
	
	//AuthorizationServerConfigurer has an implementation called AuthorizationServerConfigurerAdapter (the implementation of the above implemented interface)
	//since Java doesn't support multiple inheritance, you can create 2 different classes that will eventually make this class extend from both
	// A is B, and B is C -> making C is of type A and B
	// one extends from the WebSecurityConfigurerAdapter
	//the other extends from the AuthorizationServerConfigurerAdapter
	
	//why do we need to extends from the WebSecurityConfigurerAdapter?
	//can't access Authentication Manager by default in the latest Spring Security
	//Authentication Manager comes with the WebSecurityConfigurerAdapter, so we can use it
	
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		//to validate the check_token process
		security.checkTokenAccess("permitAll()");
		
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		// to create the client in memory
		//to make sure the property file values are being used, a new client is used here
		//since no validity period is mentioned, the default validity period will be used
		//put in the 'authorization basic' username - web, password - webpass
		clients.inMemory().withClient("web").secret(passwordEncoder.encode("webpass")).scopes("READ","WRITE").authorizedGrantTypes("password","authorization_code");
		
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		//defining the authentication manager (authentication manager validates the password)
		endpoints.authenticationManager(authenticationManager);
		
	}
	
}
