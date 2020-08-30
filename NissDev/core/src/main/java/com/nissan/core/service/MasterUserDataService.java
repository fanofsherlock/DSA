package com.nissan.core.service;

import java.util.List;

import com.nissan.core.entities.BusinessUnit;
import com.nissan.core.entities.Department;
import com.nissan.core.entities.JobTitle;

public interface MasterUserDataService {

	List<BusinessUnit> getAllBusinessUnits();

	List<JobTitle> getAllJobTitles();

	List<Department> getAllDepartments();

}
