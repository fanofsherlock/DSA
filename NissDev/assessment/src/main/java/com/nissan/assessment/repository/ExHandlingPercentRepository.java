package com.nissan.assessment.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nissan.assessment.entities.ExHandlingPercent;

@Repository
public interface ExHandlingPercentRepository extends CrudRepository<ExHandlingPercent, String> {
	public List<ExHandlingPercent> findAll();

}
