package com.nissan.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nissan.core.entities.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
	@SuppressWarnings("unchecked")
	Region save(Region roleInfo);

	List<Region> findAll();
}
