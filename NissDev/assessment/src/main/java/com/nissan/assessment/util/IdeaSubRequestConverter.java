package com.nissan.assessment.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nissan.assessment.dto.ApplicationDto;
import com.nissan.assessment.dto.request.IdeaSubmitRequest;
import com.nissan.assessment.entities.AutomationArea;
import com.nissan.assessment.entities.AutomationCategory;
import com.nissan.assessment.entities.AutomationGoal;
import com.nissan.assessment.entities.AutomationSubCategory;
import com.nissan.assessment.entities.EnvironmentStability;
import com.nissan.assessment.entities.ExHandlingPercent;
import com.nissan.assessment.entities.Idea;
import com.nissan.assessment.entities.IdeaApplication;
import com.nissan.assessment.entities.IdeaState;
import com.nissan.assessment.entities.NoOfInputFields;
import com.nissan.assessment.entities.NumOfApplication;
import com.nissan.assessment.entities.ProcessFrequency;
import com.nissan.assessment.entities.ProcessPeaks;
import com.nissan.assessment.entities.StabilityOfApp;
import com.nissan.assessment.entities.StructDigitalDataInput;
import com.nissan.assessment.entities.WaysToCompleteProcess;
import com.nissan.core.entities.Region;

public class IdeaSubRequestConverter {

	public static Idea getIdeaDomain(IdeaSubmitRequest idea, Long currentLoggedInUserId) {

		Idea ideaDomain = new Idea();
		ideaDomain.setIdeaName(idea.getIdeaName());
		AutomationArea area = new AutomationArea();
		area.setAutomationAreaId(Long.valueOf(idea.getAutomationAreaId()));
		ideaDomain.setAutomationArea(area);

		AutomationCategory autoCategory = new AutomationCategory();
		autoCategory.setAutomationCatId(Long.valueOf(idea.getAutomationCategoryId()));
		ideaDomain.setAutomationCategory(autoCategory);

		AutomationSubCategory subCategory = new AutomationSubCategory();
		subCategory.setAutomationSubCatId(Long.valueOf(idea.getAutomationSubCategoryId()));
		ideaDomain.setAutomationSubCategory(subCategory);

		Region region = new Region();
		region.setRegionId(Long.valueOf(idea.getRegionId()));
		ideaDomain.setRegion(region);

		ideaDomain.setDescription(idea.getDescription());
		ideaDomain.setPainPointComments(idea.getPainPointComments());

		AutomationGoal goal = new AutomationGoal();
		goal.setAutomationGoalId(Long.valueOf(idea.getAutomationGoalId()));
		ideaDomain.setAutomationGoals(goal);

		EnvironmentStability processStability = new EnvironmentStability();
		processStability.setEnvStabilityId(Long.valueOf(idea.getProcessStabilityChangeId()));
		ideaDomain.setProcessStabilityChange(processStability);

		EnvironmentStability appStability = new EnvironmentStability();
		appStability.setEnvStabilityId(Long.valueOf(idea.getApplicationStabilityChangeId()));
		ideaDomain.setApplicationStabilityChange(appStability);

		ideaDomain.setAutomationProfileComments(idea.getAutomationProfileComments());
		ideaDomain.setNumberOfDaysWorked(idea.getNumberOfDaysWorked());
		ideaDomain.setWorkingHoursPerDay(idea.getWorkingHoursPerDay());
		ideaDomain.setAverageEmpFullCostYearly(idea.getAverageEmpFullCostYearly());

		ProcessFrequency frequency = new ProcessFrequency();
		frequency.setFreqId(Long.valueOf(idea.getProcessFrequencyId()));
		ideaDomain.setProcessFrequency(frequency);

		ideaDomain.setActivityVolumAverageHrsPerYear(idea.getActivityVolumAverageHrsPerYear());
		ideaDomain.setAverageProcessingTimePerMin(idea.getAverageProcessingTimePerMin());
		ideaDomain.setTotalProcessingTimeHrsPerYear(idea.getTotalProcessingTimeHrsPerYear());
		ideaDomain.setAverageErrorRatePercentVolume(idea.getAverageErrorRatePercentVolume());
		ideaDomain.setTotalReworkTimeHrsPerYear(idea.getTotalReworkTimeHrsPerYear());
		ideaDomain.setAvgReviewTimePerTransaction(idea.getAvgReviewTimePerTransaction());
		ideaDomain.setNumOfEmployeesPerformingTask(idea.getNumOfEmployeesPerformingTask());
		ideaDomain.setTotTimeNeededToPerformTask(idea.getTotTimeNeededToPerformTask());
		ideaDomain.setFteRequired(idea.getFteRequired());
		ideaDomain.setCostPerYearForProcess(idea.getCostPerYearForProcess());
		ideaDomain.setProcessVolumetryComments(idea.getProcessVolumetryComments());

		ProcessPeaks peaks = new ProcessPeaks();
		peaks.setProcessPeekId(Long.valueOf(idea.getProcessPeaksId()));
		ideaDomain.setProcessPeaks(peaks);
		ideaDomain.setAvgNumberOfSteps(idea.getAvgNumberOfSteps());

		WaysToCompleteProcess waysToComplete = new WaysToCompleteProcess();
		waysToComplete.setWaysToCompletePrcsId(Long.valueOf(idea.getWaysToCompleteProcessId()));
		ideaDomain.setWaysToCompleteProcess(waysToComplete);
		ideaDomain.setProcessWaysComments(idea.getProcessWaysComments());
		ideaDomain.setDigitalDataInPercentage(idea.getDigitalDataInPercentage());

		StructDigitalDataInput inp = new StructDigitalDataInput();
		inp.setStructDataInputId(Long.valueOf(idea.getStructuredDigitalDataInPercentageId()));

		ideaDomain.setStructuredDigitalDataInPercentage(inp);
		ideaDomain.setDataAndAppComments(idea.getDataAndAppComments());
		// ideaDomain.setIdeaApplication(idea.getIdeaApplicationId());

		List<ApplicationDto> appList = idea.getApplicationList();
		IdeaApplication application = null;
		List<IdeaApplication> appListDB = new ArrayList<IdeaApplication>();

		if (appList != null && !appList.isEmpty()) {
			for (ApplicationDto ideaApplication : appList) {
				application = new IdeaApplication();
				application.setApplicationName(ideaApplication.getApplicationName());
				application.setVersionNo(ideaApplication.getVersionNo());
				application.setLanguage(ideaApplication.getLanguage());
				application.setThinClient(ideaApplication.getThinClient());
				application.setFeasibilityScore(ideaApplication.getFeasibilityScore());
				application.setComments(ideaApplication.getComments());
				appListDB.add(application);
			}
		}
		ideaDomain.setApplicationList(appListDB);

		NoOfInputFields noOfInputFields = new NoOfInputFields();
		noOfInputFields.setNoOfInputFieldsId(Long.valueOf(idea.getNoOfInputFieldsId()));
		ideaDomain.setNoOfInputFields(noOfInputFields);

		ExHandlingPercent exHandlingPercent = new ExHandlingPercent();
		exHandlingPercent.setExHandlingPercentId(Long.valueOf(idea.getExHandlingPercentId()));
		ideaDomain.setExHandlingPercent(exHandlingPercent);

		NumOfApplication numOfApplication = new NumOfApplication();
		numOfApplication.setNumOfApplicationId(Long.valueOf(idea.getNumOfApplicationId()));
		ideaDomain.setNumOfApplication(numOfApplication);

		StabilityOfApp stabilityOfApp = new StabilityOfApp();
		stabilityOfApp.setStabilityOfAppId(Long.valueOf(idea.getStabilityOfAppId()));
		ideaDomain.setStabilityOfApp(stabilityOfApp);

		ideaDomain.setProcessOwner(idea.getProcessOwner());

		IdeaState ideaState = new IdeaState();
		ideaState.setIdeaStateId(1l);
		// if (idea.getIdeaStateId() == 1L)
		// ideaState.setIdeaStatus("Under Review");
		// else if (idea.getIdeaStateId() == 2L)
		// ideaState.setIdeaStatus("Approved");
		// else if (idea.getIdeaStateId() == 3L)
		// ideaState.setIdeaStatus("On Hold");
		// else if (idea.getIdeaStateId() == 4L)
		// ideaState.setIdeaStatus("Rejected");

		ideaDomain.setIdeaState(ideaState);
		ideaDomain.setSubmittedBy(currentLoggedInUserId);

		ideaDomain.setApproverId(idea.getApproverId());
		ideaDomain.setApprovedDate(null);
		ideaDomain.setSubmittedDate(new Date());

		return ideaDomain;
	}

}
