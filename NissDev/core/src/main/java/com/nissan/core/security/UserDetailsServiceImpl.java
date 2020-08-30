package com.nissan.core.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.nissan.core.entities.SystemUser;
import com.nissan.core.repository.SystemUserRepository;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	private SystemUserRepository systemUserRepository;

	@Autowired
	public UserDetailsServiceImpl(SystemUserRepository systemUserRepository) {
		this.systemUserRepository = systemUserRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
		SystemUser applicationUser = systemUserRepository.findByEmailId(emailId);
		if (applicationUser == null) {
			throw new UsernameNotFoundException(emailId);
		}
		return new User(applicationUser.getEmailId(), applicationUser.getPassword(), new ArrayList<>());
	}

}
