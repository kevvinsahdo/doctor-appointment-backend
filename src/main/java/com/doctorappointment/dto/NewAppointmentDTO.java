package com.doctorappointment.dto;

import java.util.Date;

public class NewAppointmentDTO {

	private Integer doctorId;
	private Date date;

	public NewAppointmentDTO() {
		super();
	}

	public NewAppointmentDTO(Integer doctorId, Date date) {
		this.doctorId = doctorId;
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

}
