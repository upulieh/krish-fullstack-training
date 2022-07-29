package com.upulie.rentcloud.rentui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class RentUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentUiApplication.class, args);
	}

}
