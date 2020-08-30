package com.nissan.assessment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.assessment.entities.AssessmentTollGateCheckListIdeaReview;
import com.nissan.assessment.entities.AssessmentTollGateChecklist;
import com.nissan.assessment.entities.AutomationArea;
import com.nissan.assessment.entities.AutomationCategory;
import com.nissan.assessment.entities.AutomationGoal;
import com.nissan.assessment.entities.AutomationSubCategory;
import com.nissan.assessment.entities.DeploymentTollGateCheckListIdeaReview;
import com.nissan.assessment.entities.DeploymentTollGateChecklist;
import com.nissan.assessment.entities.Document;
import com.nissan.assessment.entities.EnvironmentStability;
import com.nissan.assessment.entities.ExHandlingPercent;
import com.nissan.assessment.entities.IdeaApplication;
import com.nissan.assessment.entities.IdeaState;
import com.nissan.assessment.entities.NoOfInputFields;
import com.nissan.assessment.entities.NumOfApplication;
import com.nissan.assessment.entities.Phase;
import com.nissan.assessment.entities.PhaseDocument;
import com.nissan.assessment.entities.ProcessFrequency;
import com.nissan.assessment.entities.ProcessPeaks;
import com.nissan.assessment.entities.StabilityOfApp;
import com.nissan.assessment.entities.StructDigitalDataInput;
import com.nissan.assessment.entities.WaysToCompleteProcess;
import com.nissan.assessment.repository.AssessmentTollGateCheckListIdeaReviewRepo;
import com.nissan.assessment.repository.AssessmentTollGateChecklistRepo;
import com.nissan.assessment.repository.AutomationAreaRepository;
import com.nissan.assessment.repository.AutomationCategoryRepository;
import com.nissan.assessment.repository.AutomationGoalRepository;
import com.nissan.assessment.repository.AutomationSubCategoryRepository;
import com.nissan.assessment.repository.DeploymentTollGateCheckListIdeaReviewRepo;
import com.nissan.assessment.repository.DeploymentTollGateChecklistRepo;
import com.nissan.assessment.repository.DigInputRepository;
import com.nissan.assessment.repository.DocumentRepository;
import com.nissan.assessment.repository.EnvironmentStabilityRepo;
import com.nissan.assessment.repository.ExHandlingPercentRepository;
import com.nissan.assessment.repository.FrequencyRepository;
import com.nissan.assessment.repository.IdeaAppRepository;
import com.nissan.assessment.repository.IdeaRepository;
import com.nissan.assessment.repository.IdeaStateRepository;
import com.nissan.assessment.repository.NoOfApplicationRepository;
import com.nissan.assessment.repository.NoOfInputFieldsRepository;
import com.nissan.assessment.repository.PhaseDocumentRepository;
import com.nissan.assessment.repository.PhaseRepository;
import com.nissan.assessment.repository.ProcessPeaksRepository;
import com.nissan.assessment.repository.StabilityOfAppRepository;
import com.nissan.assessment.repository.WaysToCompleteRepository;
import com.nissan.assessment.service.MasterTableDataService;
import com.nissan.core.entities.Region;
import com.nissan.core.repository.RegionRepository;

@Service
public class MasterTableDataServiceImpl implements MasterTableDataService {

	@Autowired
	AutomationAreaRepository areaRepository;

	@Autowired
	AutomationCategoryRepository catgryRepository;

	@Autowired
	AutomationSubCategoryRepository subCatgryRepository;

	@Autowired
	AutomationGoalRepository reasonRepository;

	@Autowired
	FrequencyRepository prcsFreqRepository;

	@Autowired
	ProcessPeaksRepository prcsPeekRepository;

	@Autowired
	WaysToCompleteRepository waysToCompRepository;

	@Autowired
	EnvironmentStabilityRepo envRepository;

	@Autowired
	DigInputRepository inputRepository;

	@Autowired
	IdeaAppRepository ideaAppRepository;

	@Autowired
	IdeaStateRepository ideaStateRepository;

	@Autowired
	IdeaRepository ideaRepository;

	@Autowired
	PhaseRepository phaseRepository;

	@Autowired
	DocumentRepository docsRepository;

	@Autowired
	PhaseDocumentRepository phaseDocRepository;

	@Autowired
	AssessmentTollGateChecklistRepo assessmentTollGateCheckListRepository;

	@Autowired
	DeploymentTollGateChecklistRepo deploymentTollGateCheckListRepository;

	@Autowired
	AssessmentTollGateCheckListIdeaReviewRepo assessmentTollGateIdeaReviewRepo;

	@Autowired
	DeploymentTollGateCheckListIdeaReviewRepo deploymentTollGateIdeaReviewRepo;

	@Autowired
	NoOfApplicationRepository noOfApplicationRepository;

	@Autowired
	NoOfInputFieldsRepository noOfInputFieldsRepository;

	@Autowired
	ExHandlingPercentRepository exHandlingPercentRepository;

	@Autowired
	StabilityOfAppRepository stabilityOfAppRepository;

	@Autowired
	RegionRepository regionRepository;

	@Override
	public List<AutomationArea> getAllAutomationAreas() {
		return areaRepository.findAll();
	}

	@Override
	public List<AutomationCategory> getAllAutomationCategories() {
		return catgryRepository.findAll();
	}

	@Override
	public List<AutomationSubCategory> getAllAutomationSubCategories() {
		return subCatgryRepository.findAll();
	}

	@Override
	public List<AutomationGoal> getAllAutomationReasons() {
		return reasonRepository.findAll();
	}

	@Override
	public List<ProcessFrequency> getProcessFreq() {
		return prcsFreqRepository.findAll();
	}

	@Override
	public List<ProcessPeaks> getProcessPeaks() {
		return prcsPeekRepository.findAll();
	}

	@Override
	public List<WaysToCompleteProcess> getWaysToComplete() {
		return waysToCompRepository.findAll();
	}

	@Override
	public List<StructDigitalDataInput> getStructuredDataInput() {
		return inputRepository.findAll();
	}

	@Override
	public List<EnvironmentStability> getProcessStabilityChange() {
		return envRepository.findAll();
	}

	@Override
	public List<EnvironmentStability> getAppStabilityChange() {
		return envRepository.findAll();
	}

	@Override
	public List<IdeaApplication> getIdeaApplications() {
		return ideaAppRepository.findAll();
	}

	@Override
	public List<PhaseDocument> getAllPhaseDocument() {
		return phaseDocRepository.findAll();
	}

	@Override
	public List<IdeaState> getAllIdeaState() {
		return ideaStateRepository.findAll();
	}

	@Override
	public List<Phase> getAllPhases() {
		return phaseRepository.findAll();
	}

	@Override
	public List<Document> getAllDocs() {
		return docsRepository.findAll();
	}

	@Override
	public List<EnvironmentStability> getEnvStabilityStatus() {
		return envRepository.findAll();
	}

	@Override
	public List<AssessmentTollGateChecklist> getAssessmentTollGateChecklist() {
		return assessmentTollGateCheckListRepository.findAll();
	}

	@Override
	public List<DeploymentTollGateChecklist> getDeploymentTollGateChecklist() {
		return deploymentTollGateCheckListRepository.findAll();
	}

	@Override
	public List<AssessmentTollGateCheckListIdeaReview> getAssessmentTollGateCheckListIdeaReview() {
		return assessmentTollGateIdeaReviewRepo.findAll();
	}

	@Override
	public List<DeploymentTollGateCheckListIdeaReview> getDeploymentTollGateCheckListIdeaReview() {
		return deploymentTollGateIdeaReviewRepo.findAll();
	}

	@Override
	public List<NoOfInputFields> getNoOfInputFields() {
		return noOfInputFieldsRepository.findAll();
	}

	@Override
	public List<ExHandlingPercent> getExHandlingPercent() {
		return exHandlingPercentRepository.findAll();
	}

	@Override
	public List<NumOfApplication> getNoOfApplication() {
		return noOfApplicationRepository.findAll();
	}

	@Override
	public List<StabilityOfApp> getStabilityOfApplications() {
		return stabilityOfAppRepository.findAll();
	}

	@Override
	public List<Region> getAllRegions() {
		return regionRepository.findAll();
	}
}
