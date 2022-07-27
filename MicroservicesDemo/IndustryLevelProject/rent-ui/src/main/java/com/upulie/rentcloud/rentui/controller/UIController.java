package com.upulie.rentcloud.rentui.controller;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//for UI components, the annotation should be @Controller (not a @RESTController)
@Controller
@EnableOAuth2Sso //to override the provided authentication process (UI service gets to know that it needs to get authenticated from the oauth server) which oauth server to use is provided in properties file
public class UIController extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/").permitAll() //if the request maps to "/" allow them
		.anyRequest().authenticated(); //if the request maps to any other path, authenticate them
	}
	
    @RequestMapping(value = "/")
    public String loadUI(){
        return "home"; //file name
    }
    @RequestMapping(value = "/secure")
    public String loadSecuredUI(){
        return "secure"; //file name
    }
}
