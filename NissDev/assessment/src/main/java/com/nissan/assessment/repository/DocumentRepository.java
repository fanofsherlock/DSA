package com.nissan.assessment.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nissan.assessment.entities.Document;

public interface DocumentRepository extends CrudRepository<Document, Void> {

	public List<Document> findAll();

	@SuppressWarnings("unchecked")
	Document save(Document document);

}
