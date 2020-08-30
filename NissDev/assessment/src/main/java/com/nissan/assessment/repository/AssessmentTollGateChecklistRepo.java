package com.nissan.assessment.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nissan.assessment.entities.AssessmentTollGateChecklist;

@Repository
public interface AssessmentTollGateChecklistRepo extends CrudRepository<AssessmentTollGateChecklist, Long> {

	@SuppressWarnings("unchecked")
	AssessmentTollGateChecklist save(AssessmentTollGateChecklist idea);

	List<AssessmentTollGateChecklist> findAll();

	AssessmentTollGateChecklist findByChecklistItemId(Long checklistItemId);

}
