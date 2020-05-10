package com.doctorappointment.resources;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doctorappointment.domain.User;
import com.doctorappointment.dto.UserDTO;
import com.doctorappointment.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public ResponseEntity<?> signUp(@RequestBody Map<String, Object> payload) {
		ObjectMapper objectMapper = new ObjectMapper();

		UserDTO userDTO = objectMapper.convertValue(payload, UserDTO.class);
		
		User newUser = userService.singUp(userDTO);

		return ResponseEntity.ok().body(newUser);
	}
}
