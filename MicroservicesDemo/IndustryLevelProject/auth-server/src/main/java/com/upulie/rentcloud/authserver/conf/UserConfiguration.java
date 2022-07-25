package com.upulie.rentcloud.authserver.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

//defining the set of users
@Configuration
public class UserConfiguration extends GlobalAuthenticationConfigurerAdapter{

	//used to encode the password
	PasswordEncoder passwordEncoder=PasswordEncoderFactories.createDelegatingPasswordEncoder();
	
	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		//and() can be used to create 2 users
		auth.inMemoryAuthentication().withUser("upulieun").password(passwordEncoder.encode("upuliepw")).roles("USER","ADMIN","MANAGER").authorities("CAN_READ","CAN_WRITE","CAN_DELETE").and().withUser("tinyun").password(passwordEncoder.encode("tinypw")).roles("USER").authorities("CAN_READ","CAN_WRITE");
	}
	
}
