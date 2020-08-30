package com.nissan.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nissan.core.entities.JobTitle;

@Repository
public interface JobTitleRepository extends JpaRepository<JobTitle, Long> {

	List<JobTitle> findAll();
}
