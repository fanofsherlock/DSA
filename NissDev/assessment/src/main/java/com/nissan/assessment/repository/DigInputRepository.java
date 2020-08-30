package com.nissan.assessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nissan.assessment.entities.StructDigitalDataInput;

@Repository
public interface DigInputRepository extends JpaRepository<StructDigitalDataInput, Void> {

	@SuppressWarnings("unchecked")
	StructDigitalDataInput save(StructDigitalDataInput noOfWaysToComplete);

	List<StructDigitalDataInput> findAll();

}
