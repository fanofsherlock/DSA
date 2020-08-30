package com.nissan.assessment.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nissan.assessment.entities.AssessmentTollGateCheckListIdeaReview;

@Repository
public interface AssessmentTollGateCheckListIdeaReviewRepo
		extends CrudRepository<AssessmentTollGateCheckListIdeaReview, Long> {

	@SuppressWarnings("unchecked")
	AssessmentTollGateCheckListIdeaReview save(AssessmentTollGateCheckListIdeaReview review);

	List<AssessmentTollGateCheckListIdeaReview> findAll();

	/*@Query(value = "SELECT t from TollGateCheckListIdeaReview t where t.idea.ideaId= ?1")
	AssessmentTollGateCheckListIdeaReview findByIdeaId(String ideaId);*/

}
