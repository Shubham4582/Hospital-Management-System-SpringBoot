package com.Hospital;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface Patient_JPA extends JpaRepository<Patient, Long> {
	List<Patient> findByNameContainingIgnoreCase(String name);
}
