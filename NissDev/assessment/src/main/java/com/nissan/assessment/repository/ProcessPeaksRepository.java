package com.nissan.assessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nissan.assessment.entities.ProcessPeaks;

@Repository
public interface ProcessPeaksRepository extends JpaRepository<ProcessPeaks, Void> {

	@SuppressWarnings("unchecked")
	ProcessPeaks save(ProcessPeaks processPeeks);

	List<ProcessPeaks> findAll();

}
