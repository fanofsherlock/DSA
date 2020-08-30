package com.nissan.assessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nissan.assessment.entities.AutomationGoal;

@Repository
public interface AutomationGoalRepository extends JpaRepository<AutomationGoal, Void> {

	@SuppressWarnings("unchecked")
	AutomationGoal save(AutomationGoal automationReason);

	List<AutomationGoal> findAll();

}
