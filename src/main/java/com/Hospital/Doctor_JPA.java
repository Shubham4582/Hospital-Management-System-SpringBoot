package com.Hospital;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface Doctor_JPA extends JpaRepository<Doctor, Long> {
	List<Doctor> findBySpecialization(String specialization);
}
