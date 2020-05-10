package com.doctorappointment.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doctorappointment.domain.Doctor;
import com.doctorappointment.services.DoctorService;

@RestController
@RequestMapping(value = "/doctors")
public class DoctorResource {

	@Autowired
	private DoctorService doctorService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> list() {
		List<Doctor> doctors = doctorService.list();

		return ResponseEntity.ok().body(doctors);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@Valid @RequestBody Doctor doctor) {
		doctor = doctorService.create(doctor);
		
		return ResponseEntity.ok().body(doctor);
	}

}
