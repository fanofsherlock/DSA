package com.nissan.assessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nissan.assessment.entities.AutomationArea;

@Repository
public interface AutomationAreaRepository extends JpaRepository<AutomationArea, Void> {

	@SuppressWarnings("unchecked")
	AutomationArea save(AutomationArea automationAreaName);

	List<AutomationArea> findAll();

}
