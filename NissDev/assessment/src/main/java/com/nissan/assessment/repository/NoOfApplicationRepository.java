package com.nissan.assessment.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nissan.assessment.entities.NumOfApplication;

@Repository
public interface NoOfApplicationRepository extends CrudRepository<NumOfApplication, String> {

	public List<NumOfApplication> findAll();

}
