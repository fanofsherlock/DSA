package com.nissan.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.core.entities.BusinessUnit;
import com.nissan.core.entities.Department;
import com.nissan.core.entities.JobTitle;
import com.nissan.core.repository.BusinessUnitRepository;
import com.nissan.core.repository.DepartmentRepository;
import com.nissan.core.repository.JobTitleRepository;
import com.nissan.core.service.MasterUserDataService;

@Service
public class MasterUserDataServiceImpl implements MasterUserDataService {


	@Autowired
	BusinessUnitRepository businessUnitRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	JobTitleRepository jobTitleRepository;


	@Override
	public List<BusinessUnit> getAllBusinessUnits() {
		return businessUnitRepository.findAll();
	}

	@Override
	public List<JobTitle> getAllJobTitles() {
		return jobTitleRepository.findAll();
	}

	@Override
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

}
