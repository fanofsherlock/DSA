package com.nissan.assessment.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nissan.assessment.entities.Idea;

public interface IdeaRepository extends CrudRepository<Idea, String> {

	@Query(value = "SELECT i from Idea i where i.submittedBy= ?1")
	public List<Idea> findAllByUser(Long userId);

	public List<Idea> findByOrderBySubmittedDateDesc();

	@SuppressWarnings("unchecked")
	Idea save(Idea idea);

	@Query(value = "SELECT istate.idea_status, COUNT(i) FROM idea i join idea_state istate on "
			+ "i.idea_state=istate.idea_state_id and i.submitted_by= ?1 group by istate.idea_status ", nativeQuery = true)

	List<Object[]> returnIdeaStateCounts(Long currentLoggedInUserId);

	@Query(value = "SELECT i from Idea i where i.ideaState.ideaStateId= ?1 and  i.submittedBy= ?2")
	public List<Idea> findByStatus(Long statusId, Long currentLoggedInUserId);

	@Query(value = "SELECT i from Idea i where i.automationArea.automationAreaId= ?1 and i.submittedBy= ?2")
	public List<Idea> findByAreaId(Long areaId, Long currentLoggedInUserId);

	@Transactional
	@Modifying
	@Query(value = "update Idea i set i.ideaState.ideaStateId=?2, i.approverId=?3 where i.ideaId= ?1 ")
	public void updateIdeaStatus(String ideaId, Long ideaStatus, Long currentLoggedInUserId);

	@Query(value = "SELECT i from Idea i where i.approverId= ?1 and i.ideaState.ideaStateId= 1")
	public List<Idea> getApprovals(Long userId);

	public Optional<Idea> findByIdeaIdAndSubmittedBy(String ideaId, Long currentLoggedInUserId);

}
