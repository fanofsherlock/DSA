package com.nissan.core.util;

import java.util.Date;

import com.nissan.core.dto.RoleInfo;
import com.nissan.core.dto.UserInfo;
import com.nissan.core.entities.BusinessUnit;
import com.nissan.core.entities.Department;
import com.nissan.core.entities.JobTitle;
import com.nissan.core.entities.Region;
import com.nissan.core.entities.Role;
import com.nissan.core.entities.SystemUser;

public class UserDtoConverter {

	public static SystemUser getUserDomain(UserInfo userInfo) {

		SystemUser userDomain = new SystemUser();

		userDomain.setFirstName(userInfo.getFirstName());
		userDomain.setLastName(userInfo.getLastName());
		userDomain.setEmailId(userInfo.getEmailId());
		userDomain.setPassword(userInfo.getPassword());

		if (userInfo.getJobTitleId() != null && userInfo.getJobTitleId() > 0) {
			JobTitle jobTitle = new JobTitle();
			jobTitle.setJobTitleId(userInfo.getJobTitleId());
			userDomain.setJobTitle(jobTitle);
		}

		if (userInfo.getBusinessUnitId() != null && userInfo.getBusinessUnitId() > 0) {
			BusinessUnit businessUnit = new BusinessUnit();
			businessUnit.setBusinessUnitId(userInfo.getBusinessUnitId());
			userDomain.setBusinessUnit(businessUnit);
		}

		if (userInfo.getDepartmentId() != null && userInfo.getDepartmentId() > 0) {
			Department department = new Department();
			department.setDeptId(userInfo.getDepartmentId());
			userDomain.setDepartment(department);
		}

		if (userInfo.getRegionId() != null && userInfo.getRegionId() > 0) {
			Region region = new Region();
			region.setRegionId(userInfo.getRegionId());
			userDomain.setRegion(region);
		}

//		Role role = new Role();
//		role.setRoleId(userInfo.getRoleId());
//		userDomain.setRole(role);

		userDomain.setCreatedDate(new Date());
		userDomain.setCreatedBy(null);

		return userDomain;
	}

	public static Role getRoleDomain(RoleInfo roleInfo) {

		Role roleDomain = new Role();

		roleDomain.setDescription(roleInfo.getDescription());
		roleDomain.setRoleName(roleInfo.getRoleName());

		roleDomain.setCreatedDate(new Date());
		roleDomain.setCreatedBy(null);
		return roleDomain;
	}

	public static SystemUser updateUserDomain(SystemUser userDomain, UserInfo userInfo) {

		userDomain.setFirstName(userInfo.getFirstName());
		userDomain.setLastName(userInfo.getLastName());
		// userDomain.setEmailId(userInfo.getEmailId());
		userDomain.setPassword(userInfo.getPassword());

		JobTitle jobTitle = new JobTitle();
		jobTitle.setJobTitleId(userInfo.getJobTitleId());
		userDomain.setJobTitle(jobTitle);

		BusinessUnit businessUnit = new BusinessUnit();
		businessUnit.setBusinessUnitId(userInfo.getBusinessUnitId());
		userDomain.setBusinessUnit(businessUnit);

		Department department = new Department();
		department.setDeptId(userInfo.getDepartmentId());
		userDomain.setDepartment(department);

		Region region = new Region();
		region.setRegionId(userInfo.getRegionId());
		userDomain.setRegion(region);

//		Role role = new Role();
//		role.setRoleId(userInfo.getRoleId());
//		userDomain.setRole(role);

		userDomain.setUpdatedDate(new Date());
		userDomain.setUpdatedBy(null);

		return userDomain;
	}

}
