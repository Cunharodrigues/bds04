package com.devsuperior.bds04.services;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.devsuperior.bds04.repositories.UserRepository;


@Service
public class UserService implements UserDetailsService {
	
	private static org.jboss.logging.Logger logger = LoggerFactory.logger(UserService.class);
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.devsuperior.bds04.entities.User user = repository.findByEmail(username);
		if (user == null) {
			logger.error("User not found" + username);
			throw new UsernameNotFoundException("Email not found");
		}
		logger.info("User found" + username);
		return user;
	}

}
