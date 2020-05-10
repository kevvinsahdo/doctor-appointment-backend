package com.doctorappointment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctorappointment.domain.Doctor;
import com.doctorappointment.repositories.DoctorRepository;

@Service
public class DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	public List<Doctor> list() {
		List<Doctor> listDoctors = doctorRepository.findAll();
		
		return listDoctors;
	}
	
	public Doctor create(Doctor doctor) {
		return doctorRepository.save(doctor);
	}
}
