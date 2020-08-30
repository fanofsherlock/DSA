package com.nissan.assessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nissan.assessment.entities.AutomationSubCategory;

@Repository
public interface AutomationSubCategoryRepository extends JpaRepository<AutomationSubCategory, Void> {

	@SuppressWarnings("unchecked")
	AutomationSubCategory save(AutomationSubCategory automationSubCategory);

	List<AutomationSubCategory> findAll();

}
