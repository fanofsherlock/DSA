package com.nissan.assessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nissan.assessment.entities.IdeaApplication;

@Repository
public interface IdeaAppRepository extends JpaRepository<IdeaApplication, Void> {

	@SuppressWarnings("unchecked")
	IdeaApplication save(IdeaApplication ideaApplication);

	List<IdeaApplication> findAll();

}
