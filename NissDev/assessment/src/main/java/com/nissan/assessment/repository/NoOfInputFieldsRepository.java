package com.nissan.assessment.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nissan.assessment.entities.NoOfInputFields;

@Repository
public interface NoOfInputFieldsRepository extends CrudRepository<NoOfInputFields, String> {

	public List<NoOfInputFields> findAll();

}
