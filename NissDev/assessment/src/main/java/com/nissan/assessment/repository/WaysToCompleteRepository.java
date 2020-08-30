package com.nissan.assessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nissan.assessment.entities.WaysToCompleteProcess;

@Repository
public interface WaysToCompleteRepository extends JpaRepository<WaysToCompleteProcess, Void> {

	@SuppressWarnings("unchecked")
	WaysToCompleteProcess save(WaysToCompleteProcess noOfWaysToComplete);

	List<WaysToCompleteProcess> findAll();

}
