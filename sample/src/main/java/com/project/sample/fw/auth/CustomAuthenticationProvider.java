package com.project.sample.fw.auth;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	// TODO Auto-generated method stub
	LOGGER.debug("###########################################");
	UsernamePasswordAuthenticationToken result = null;
	List<GrantedAuthority> authorities = null;

	String id = (String) authentication.getPrincipal();
	String pw = (String) authentication.getCredentials();

	if("admin".equalsIgnoreCase(id) && "1234".equalsIgnoreCase(pw)){
	    authorities = new ArrayList<GrantedAuthority>();
	    authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

	    result = new UsernamePasswordAuthenticationToken(id, pw, authorities);
	    UserDetails userDetails = new User(id, pw, authorities);
	    result.setDetails(userDetails);
	    return result;
	}
	throw new BadCredentialsException("Bad credentials");
//	return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
	// TODO Auto-generated method stub
	return authentication.equals(UsernamePasswordAuthenticationToken.class);
//	return false;
    }

}
