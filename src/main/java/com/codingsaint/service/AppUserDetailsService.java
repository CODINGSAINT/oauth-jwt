package com.codingsaint.service;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codingsaint.model.AppUser;
import com.codingsaint.model.CustomUser;
import com.codingsaint.repository.UserRepository;
@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired 
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		AppUser user= userRepository.getUserDetails(userName);
		CustomUser customUser= new  CustomUser(user);
		return customUser;
	}

}
