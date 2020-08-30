package com.nissan.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SystemUserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long systemUserRoleId;

	@ManyToOne
	private SystemUser systemUser;
	
	@ManyToOne
	private Role role;

	public Long getSystemUserRoleId() {
		return systemUserRoleId;
	}

	public void setSystemUserRoleId(Long systemUserRoleId) {
		this.systemUserRoleId = systemUserRoleId;
	}

	public SystemUser getSystemUser() {
		return systemUser;
	}

	public void setSystemUser(SystemUser systemUser) {
		this.systemUser = systemUser;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	

}
