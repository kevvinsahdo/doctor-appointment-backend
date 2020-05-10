package com.doctorappointment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctorappointment.domain.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

}
