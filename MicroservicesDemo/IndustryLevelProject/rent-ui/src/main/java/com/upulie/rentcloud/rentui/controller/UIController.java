package com.upulie.rentcloud.rentui.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import com.upulie.rentcloud.rentui.config.RestTemplateConfiguration;
import com.upulie.rentcloud.rentui.config.AccessToken;
import com.upulie.rentcloud.commons.model.Customer;

//for UI components, the annotation should be @Controller (not a @RESTController)
@Controller
@EnableOAuth2Sso // to override the provided authentication process (UI service gets to know that
					// it needs to get authenticated from the oauth server) which oauth server to
					// use is provided in properties file
public class UIController extends WebSecurityConfigurerAdapter {

	@Autowired
	RestTemplate restTemplate; // user to invoke a secure service from this service

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll() // if the request maps to "/" allow them
				.anyRequest().authenticated(); // if the request maps to any other path, authenticate them
	}

	@RequestMapping(value = "/")
	public String loadUI() {
		return "home"; // file name
	}

	@RequestMapping(value = "/secure")
	public String loadSecuredUI() {
		return "secure"; // file name
	}

	@RequestMapping(value = "/customers")
	public String loadCustomers(Model model) {

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", AccessToken.getAccessToken());
		HttpEntity<Customer> customerHttpEntity = new HttpEntity<>(httpHeaders);
		try {
			ResponseEntity<Customer[]> responseEntity = restTemplate.exchange(
					"http://localhost:8191/services/customers", HttpMethod.GET, customerHttpEntity, Customer[].class);
			model.addAttribute("customers", responseEntity.getBody());
		} catch (HttpStatusCodeException e) { //if the http code is not in 200s
			ResponseEntity responseEntity = ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders()).body(e.getResponseBodyAsString());
			model.addAttribute("error", responseEntity);
		}
		return "secure"; // file name
	}
}
