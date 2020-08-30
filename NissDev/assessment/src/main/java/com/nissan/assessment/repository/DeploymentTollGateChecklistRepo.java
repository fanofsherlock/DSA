package com.nissan.assessment.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nissan.assessment.entities.AssessmentTollGateChecklist;
import com.nissan.assessment.entities.DeploymentTollGateChecklist;

@Repository
public interface DeploymentTollGateChecklistRepo extends CrudRepository<DeploymentTollGateChecklist, Long> {

	@SuppressWarnings("unchecked")
	DeploymentTollGateChecklist save(DeploymentTollGateChecklist idea);

	List<DeploymentTollGateChecklist> findAll();

	DeploymentTollGateChecklist findByChecklistItemId(Long checklistItemId);

}
