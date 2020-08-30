package com.nissan.core.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.nissan.core.entities.SystemUser;

@Repository
public interface SystemUserRepository extends PagingAndSortingRepository<SystemUser, Long> {

	@Query(value = "SELECT u from SystemUser u where u.emailId= ?1")
	SystemUser findByEmailId(String emailId);

	@SuppressWarnings("unchecked")
	SystemUser save(SystemUser userInfo);

	Page<SystemUser> findAll(Pageable pageable);

	@Transactional
	@Modifying
	@Query(value = "UPDATE SystemUser set status = 1 where userId= ?1")
	void activateUser(Long userId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE SystemUser set status = 0 where userId= ?1")
	void deactivateUser(Long userId);

	@Query(value = "SELECT status from SystemUser where  userId= ?1")
	Integer getActivationStatus(Long userId);

	@Query(value = "SELECT u from SystemUser u where u.userId != ?1")
	List<SystemUser> getAllApprovers(Long currentLoggedInUserId);
}
