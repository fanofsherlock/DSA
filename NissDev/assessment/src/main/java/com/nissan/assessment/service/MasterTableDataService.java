package com.nissan.assessment.service;

import java.util.List;

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
import com.nissan.core.entities.Region;

public interface MasterTableDataService {

	List<AutomationArea> getAllAutomationAreas();

	List<AutomationCategory> getAllAutomationCategories();

	List<AutomationSubCategory> getAllAutomationSubCategories();

	List<AutomationGoal> getAllAutomationReasons();

	List<ProcessFrequency> getProcessFreq();

	List<ProcessPeaks> getProcessPeaks();

	List<WaysToCompleteProcess> getWaysToComplete();

	List<StructDigitalDataInput> getStructuredDataInput();

	List<EnvironmentStability> getProcessStabilityChange();

	List<EnvironmentStability> getAppStabilityChange();

	List<IdeaApplication> getIdeaApplications();

	List<IdeaState> getAllIdeaState();

	List<PhaseDocument> getAllPhaseDocument();

	List<Phase> getAllPhases();

	List<Document> getAllDocs();

	List<EnvironmentStability> getEnvStabilityStatus();

	List<AssessmentTollGateChecklist> getAssessmentTollGateChecklist();

	List<DeploymentTollGateChecklist> getDeploymentTollGateChecklist();

	List<AssessmentTollGateCheckListIdeaReview> getAssessmentTollGateCheckListIdeaReview();

	List<DeploymentTollGateCheckListIdeaReview> getDeploymentTollGateCheckListIdeaReview();

	List<NoOfInputFields> getNoOfInputFields();

	List<ExHandlingPercent> getExHandlingPercent();

	List<NumOfApplication> getNoOfApplication();

	List<StabilityOfApp> getStabilityOfApplications();

	List<Region> getAllRegions();

}
