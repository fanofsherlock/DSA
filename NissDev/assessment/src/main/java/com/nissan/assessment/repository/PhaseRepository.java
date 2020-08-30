package com.nissan.assessment.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nissan.assessment.entities.Phase;

public interface PhaseRepository extends CrudRepository<Phase, Void> {

	public List<Phase> findAll();

	@SuppressWarnings("unchecked")
	Phase save(Phase idea);

}
