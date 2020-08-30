package com.nissan.assessment.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nissan.assessment.entities.IdeaSave;

@Repository
public interface IdeaSaveRepository extends CrudRepository<IdeaSave, String> {

	public List<IdeaSave> findAll();

	@SuppressWarnings("unchecked")
	IdeaSave save(IdeaSave saveIdea);

	public IdeaSave findTopByOrderByIdeaIdDesc();

	public IdeaSave findFirstBySavedByOrderBySavedDateDesc(Long currentLoggedInUserId);

}
