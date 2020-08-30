package com.nissan.assessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nissan.assessment.entities.IdeaState;

@Repository
public interface IdeaStateRepository extends JpaRepository<IdeaState, Void> {

	@SuppressWarnings("unchecked")
	IdeaState save(IdeaState ideaState);

	List<IdeaState> findAll();

}
