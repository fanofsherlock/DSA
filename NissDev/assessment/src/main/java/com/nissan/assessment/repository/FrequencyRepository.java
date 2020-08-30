package com.nissan.assessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nissan.assessment.entities.ProcessFrequency;

@Repository
public interface FrequencyRepository extends JpaRepository<ProcessFrequency, Void> {

	@SuppressWarnings("unchecked")
	ProcessFrequency save(ProcessFrequency processFreq);

	List<ProcessFrequency> findAll();

}
