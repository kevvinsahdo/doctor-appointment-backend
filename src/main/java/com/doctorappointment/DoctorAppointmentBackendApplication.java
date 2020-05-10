package com.doctorappointment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = { "com.doctorappointment.domain" })
public class DoctorAppointmentBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorAppointmentBackendApplication.class, args);
	}

}
