package com.upulie.rentcloud.authserver.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.upulie.rentcloud.authserver.model.AuthUserDetail;
import com.upulie.rentcloud.authserver.model.User;
import com.upulie.rentcloud.authserver.repository.UserDetailRepository;

// userDetailService interface is provided by Spring Security
@Service("userDetailsService") //giving a name for the bean for easier identification in WebSecurityConfiguration
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserDetailRepository userDetailRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optionalUser = userDetailRepository.findByUsername(username);

		// using Spring security
		// what to do if the user is not there
		optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username of password wrong"));

		//if you are unsure that the optionalUser object is not present, you can use optionalUser.map()....
		UserDetails userDetails = new AuthUserDetail(optionalUser.get());
		
		//to check the accounts validity
		new AccountStatusUserDetailsChecker().check(userDetails);
		
		return userDetails;
	}

}
