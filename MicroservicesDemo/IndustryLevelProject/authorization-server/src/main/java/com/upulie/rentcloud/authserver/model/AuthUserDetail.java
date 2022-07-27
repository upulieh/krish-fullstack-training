package com.upulie.rentcloud.authserver.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

// UserDetail interface is provided by Spring Security
public class AuthUserDetail extends User implements UserDetails {

	
	public AuthUserDetail() {
		
	}
	
	//since Spring Security is asking for a AuthUserDetail object (not User object)
	public AuthUserDetail(User user) {
		super(user);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		List<GrantedAuthority> grantedAuthority = new ArrayList<>();
		
		getRoles().forEach(role -> {

			grantedAuthority.add(new SimpleGrantedAuthority(role.getName())); // setting authorities for users

			role.getPermissions().forEach(permission -> {
				grantedAuthority.add(new SimpleGrantedAuthority(permission.getName()));
			});

		});
		return grantedAuthority; //returning the defined authorities
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return super.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return super.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return super.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		return super.isEnabled();
	}

}
