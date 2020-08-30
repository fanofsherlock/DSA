package com.nissan.assessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nissan.assessment.entities.AutomationCategory;

@Repository
public interface AutomationCategoryRepository extends JpaRepository<AutomationCategory, Void> {

	@SuppressWarnings("unchecked")
	AutomationCategory save(AutomationCategory automationCategory);

	List<AutomationCategory> findAll();

}
