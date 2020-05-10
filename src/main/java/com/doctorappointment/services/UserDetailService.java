package com.doctorappointment.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.doctorappointment.domain.User;
import com.doctorappointment.repositories.UserRepository;
import com.doctorappointment.security.UserSS;

@Service
public class UserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByEmail(email);
		
		if (user.orElse(null) == null) {
			throw new UsernameNotFoundException(email);
		}
		
		return new UserSS(user.get().getId(), user.get().getEmail(), user.get().getPassword());
	}

}
