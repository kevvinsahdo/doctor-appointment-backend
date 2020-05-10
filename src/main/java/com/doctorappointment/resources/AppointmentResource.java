package com.doctorappointment.resources;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doctorappointment.domain.Appointment;
import com.doctorappointment.dto.NewAppointmentDTO;
import com.doctorappointment.services.AppointmentService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/appointments")
public class AppointmentResource {
	
	@Autowired
	private AppointmentService appointmentService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> list() {
		List<Appointment> appointments = appointmentService.list();

		return ResponseEntity.ok().body(appointments);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody Map<String, Object> appointment) {
		ObjectMapper objectMapper =  new ObjectMapper();
		
		NewAppointmentDTO newAppointmentDTO = objectMapper.convertValue(appointment, NewAppointmentDTO.class);
		
		Appointment newAppointment = appointmentService.create(newAppointmentDTO);
		
		return ResponseEntity.ok().body(newAppointment);
	}
}
