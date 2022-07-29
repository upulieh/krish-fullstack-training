package com.upulie.rentcloud.rentui.config;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

public class AccessToken {
	public static String getAccessToken() {
//		extracting the token from the context of the web page
		OAuth2AuthenticationDetails authenticationDetails = (OAuth2AuthenticationDetails) SecurityContextHolder
				.getContext().getAuthentication().getDetails();
		return authenticationDetails.getTokenType().concat(" ").concat(authenticationDetails.getTokenValue());
	}
}
