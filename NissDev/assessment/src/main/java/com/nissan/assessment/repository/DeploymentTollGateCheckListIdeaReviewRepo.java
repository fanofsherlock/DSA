package com.nissan.assessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nissan.assessment.entities.AssessmentTollGateCheckListIdeaReview;
import com.nissan.assessment.entities.DeploymentTollGateCheckListIdeaReview;

@Repository
public interface DeploymentTollGateCheckListIdeaReviewRepo
		extends CrudRepository<DeploymentTollGateCheckListIdeaReview, Long> {

	@SuppressWarnings("unchecked")
	DeploymentTollGateCheckListIdeaReview save(DeploymentTollGateCheckListIdeaReview review);

	List<DeploymentTollGateCheckListIdeaReview> findAll();

	/*
	 * @Query(value =
	 * "SELECT t from TollGateCheckListIdeaReview t where t.idea.ideaId= ?1")
	 * DeploymentTollGateCheckListIdeaReview findByIdeaId(String ideaId);
	 */

}
