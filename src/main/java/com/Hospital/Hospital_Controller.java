package com.Hospital;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Hospital_Controller {

	@Autowired
	Hospital_DAO dao;

	// -----------------
	// Patient endpoints
	// -----------------
	@GetMapping("/patients")
	public List<Patient> getAllPatients() {
		return dao.getAllPatients();
	}

	@PostMapping("/patients")
	public Patient createPatient(@RequestBody Patient p) {
		return dao.savePatient(p);
	}

	@GetMapping("/patients/{id}")
	public Patient getPatient(@PathVariable Long id) {
		Optional<Patient> opt = dao.getPatientById(id);
		return opt.orElse(null);
	}

	@DeleteMapping("/patients/{id}")
	public String deletePatient(@PathVariable Long id) {
		Optional<Patient> opt = dao.getPatientById(id);
		if (opt.isPresent()) {
			dao.deletePatient(id);
			return "Patient removed";
		} else {
			return "Patient not found";
		}
	}

	// -----------------
	// Doctor endpoints
	// -----------------
	@GetMapping("/doctors")
	public List<Doctor> getAllDoctors() {
		return dao.getAllDoctors();
	}

	@PostMapping("/doctors")
	public Doctor createDoctor(@RequestBody Doctor d) {
		return dao.saveDoctor(d);
	}

	@GetMapping("/doctors/{id}")
	public Doctor getDoctor(@PathVariable Long id) {
		Optional<Doctor> opt = dao.getDoctorById(id);
		return opt.orElse(null);
	}

	// -----------------
	// Appointment endpoints
	// -----------------
	@GetMapping("/appointments")
	public List<Appointment> getAllAppointments() {
		return dao.getAllAppointments();
	}

	@PostMapping("/appointments")
	public Appointment createAppointment(@RequestBody Appointment a) {
		// Basic linking: ensure patient and doctor exist (ids provided in incoming
		// JSON)
		return dao.saveAppointment(a);
	}

	@DeleteMapping("/appointments/{id}")
	public String deleteAppointment(@PathVariable Long id) {
		Optional<Appointment> opt = dao.getAppointmentById(id);
		if (opt.isPresent()) {
			dao.deleteAppointment(id);
			return "Appointment removed";
		} else {
			return "Appointment not found";
		}
	}

	// -----------------
	// Department endpoints
	// -----------------
	@GetMapping("/departments")
	public List<Department> getAllDepartments() {
		return dao.getAllDepartments();
	}

	@PostMapping("/departments")
	public Department createDepartment(@RequestBody Department d) {
		return dao.saveDepartment(d);
	}

}
