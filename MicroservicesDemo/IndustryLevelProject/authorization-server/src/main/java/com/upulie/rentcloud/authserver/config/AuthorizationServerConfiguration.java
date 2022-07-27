package com.upulie.rentcloud.authserver.config;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

//setting authorization server configurations
//AuthorizationServerConfigurationAdapter can also be used (in the place of AuthorizationServerConfigurer)
@Configuration
public class AuthorizationServerConfiguration implements AuthorizationServerConfigurer{

	@Autowired //using the previously created password encoder bean
	private PasswordEncoder passwordEncoder;
	@Autowired
	private DataSource dataSource;
	@Autowired //as we used in it WebConfigurer
	private AuthenticationManager authenticationManager;
	
	//On this project this tokenstore is only used by this service. However, if more services want to validate the tokens using this token store, we can do that by pointing them to this server
	//aka using a shared token store
	@Bean 
	TokenStore jdbcTokenStore() {
		return new JdbcTokenStore(dataSource);
	}
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		//token access configuration
		security.checkTokenAccess("isAuthenticated()").tokenKeyAccess("permitAll()");
		
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		//retrieving client data from the database
		clients.jdbc(dataSource).passwordEncoder(passwordEncoder);
		
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		//setting the token store (for persisting the tokens)
		endpoints.tokenStore(jdbcTokenStore());
		endpoints.authenticationManager(authenticationManager);		
	}
	
}
