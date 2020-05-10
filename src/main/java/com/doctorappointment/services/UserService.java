package com.doctorappointment.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.doctorappointment.domain.User;
import com.doctorappointment.dto.UserDTO;
import com.doctorappointment.repositories.UserRepository;
import com.doctorappointment.services.exceptions.UserConflictException;

@Service
public class UserService {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	public User singUp(UserDTO userDTO) {
		Optional<User> user = userRepository.findByEmail(userDTO.getEmail());

		if (user.orElse(null) != null) {
			throw new UserConflictException("User already exist");
		}

		User newUser = new User(null, userDTO.getName(), userDTO.getEmail(),
				passwordEncoder.encode(userDTO.getPassword()));

		return userRepository.save(newUser);
	}
}
