package com.nissan.assessment.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nissan.assessment.entities.PhaseDocument;

public interface PhaseDocumentRepository extends CrudRepository<PhaseDocument, Void> {

	public List<PhaseDocument> findAll();

	@SuppressWarnings("unchecked")
	PhaseDocument save(PhaseDocument phaseDocument);

}
