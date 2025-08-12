package com.Hospital;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface Appointment_JPA extends JpaRepository<Appointment, Long> {
	List<Appointment> findByPatientId(Long patientId);

	List<Appointment> findByDoctorId(Long doctorId);
}
