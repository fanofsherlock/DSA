package com.nissan.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nissan.core.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	@SuppressWarnings("unchecked")
	Role save(Role roleInfo);

	List<Role> findAll();

}
