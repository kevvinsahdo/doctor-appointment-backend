package com.doctorappointment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.doctorappointment.domain.Appointment;
import com.doctorappointment.dto.NewAppointmentDTO;
import com.doctorappointment.repositories.AppointmentRepository;
import com.doctorappointment.security.UserSS;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	public List<Appointment> list() {
		List<Appointment> appointmentList = appointmentRepository.findAll();
		
		return appointmentList;
	}

	public Appointment create(NewAppointmentDTO appointment) {
		UserSS auth = (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
		Appointment newAppointment = new Appointment(null, appointment.getDate(), auth.getId(), appointment.getDoctorId());
		
		newAppointment = appointmentRepository.save(newAppointment);
		
		return newAppointment;
	}
}
