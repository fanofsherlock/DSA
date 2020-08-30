package com.nissan.assessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nissan.assessment.entities.EnvironmentStability;

public interface EnvironmentStabilityRepo extends JpaRepository<EnvironmentStability, Void> {
	@SuppressWarnings("unchecked")
	EnvironmentStability save(EnvironmentStability noOfWaysToComplete);

	List<EnvironmentStability> findAll();
}
