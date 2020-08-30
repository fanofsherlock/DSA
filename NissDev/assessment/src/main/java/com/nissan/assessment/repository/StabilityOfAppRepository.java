package com.nissan.assessment.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nissan.assessment.entities.StabilityOfApp;

@Repository
public interface StabilityOfAppRepository extends CrudRepository<StabilityOfApp, String> {
	public List<StabilityOfApp> findAll();

}
