package com.Hospital;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Hospital_DAO {

	@Autowired
	Patient_JPA patient_jpa;

	@Autowired
	Doctor_JPA doctor_jpa;

	@Autowired
	Appointment_JPA appointment_jpa;

	@Autowired
	Department_JPA department_jpa;

	// Patient operations
	public List<Patient> getAllPatients() {
		return patient_jpa.findAll();
	}

	public Patient savePatient(Patient p) {
		return patient_jpa.save(p);
	}

	public Optional<Patient> getPatientById(Long id) {
		return patient_jpa.findById(id);
	}

	public void deletePatient(Long id) {
		patient_jpa.deleteById(id);
	}

	// Doctor operations
	public List<Doctor> getAllDoctors() {
		return doctor_jpa.findAll();
	}

	public Doctor saveDoctor(Doctor d) {
		return doctor_jpa.save(d);
	}

	public Optional<Doctor> getDoctorById(Long id) {
		return doctor_jpa.findById(id);
	}

	public void deleteDoctor(Long id) {
		doctor_jpa.deleteById(id);
	}

	// Appointment operations
	public List<Appointment> getAllAppointments() {
		return appointment_jpa.findAll();
	}

	public Appointment saveAppointment(Appointment a) {
		// optionally validate patient/doctor existence here
		return appointment_jpa.save(a);
	}

	public Optional<Appointment> getAppointmentById(Long id) {
		return appointment_jpa.findById(id);
	}

	public void deleteAppointment(Long id) {
		appointment_jpa.deleteById(id);
	}

	// Department operations
	public List<Department> getAllDepartments() {
		return department_jpa.findAll();
	}

	public Department saveDepartment(Department d) {
		return department_jpa.save(d);
	}

	public Optional<Department> getDepartmentById(Long id) {
		return department_jpa.findById(id);
	}

	public void deleteDepartment(Long id) {
		department_jpa.deleteById(id);
	}
}
