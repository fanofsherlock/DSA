package com.nissan.assessment.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nissan.assessment.dto.ApplicationDto;
import com.nissan.assessment.dto.request.IdeaSaveRequest;
import com.nissan.assessment.entities.AutomationArea;
import com.nissan.assessment.entities.AutomationCategory;
import com.nissan.assessment.entities.AutomationGoal;
import com.nissan.assessment.entities.AutomationSubCategory;
import com.nissan.assessment.entities.EnvironmentStability;
import com.nissan.assessment.entities.ExHandlingPercent;
import com.nissan.assessment.entities.IdeaApplication;
import com.nissan.assessment.entities.IdeaSave;
import com.nissan.assessment.entities.NoOfInputFields;
import com.nissan.assessment.entities.NumOfApplication;
import com.nissan.assessment.entities.ProcessFrequency;
import com.nissan.assessment.entities.ProcessPeaks;
import com.nissan.assessment.entities.StabilityOfApp;
import com.nissan.assessment.entities.StructDigitalDataInput;
import com.nissan.assessment.entities.WaysToCompleteProcess;
import com.nissan.core.entities.Region;

public class IdeaSaveRequestConverter {

	public static IdeaSave getSavedIdeaDomain(IdeaSaveRequest ideaSaveRequest, Long currentLoggedInUserId) {

		IdeaSave savedIdeaDomain = new IdeaSave();

		if (isNotNull(ideaSaveRequest.getIdeaName()))
			savedIdeaDomain.setIdeaName(ideaSaveRequest.getIdeaName());

		if (isNotNull(ideaSaveRequest.getAutomationAreaId())) {
			AutomationArea area = new AutomationArea();
			area.setAutomationAreaId(Long.valueOf(ideaSaveRequest.getAutomationAreaId()));
			savedIdeaDomain.setAutomationArea(area);
		}
		if (isNotNull(ideaSaveRequest.getAutomationCategoryId())) {
			AutomationCategory autoCategory = new AutomationCategory();
			autoCategory.setAutomationCatId(Long.valueOf(ideaSaveRequest.getAutomationCategoryId()));
			savedIdeaDomain.setAutomationCategory(autoCategory);
		}
		if (isNotNull(ideaSaveRequest.getAutomationSubCategoryId())) {
			AutomationSubCategory subCategory = new AutomationSubCategory();
			subCategory.setAutomationSubCatId(Long.valueOf(ideaSaveRequest.getAutomationSubCategoryId()));
			savedIdeaDomain.setAutomationSubCategory(subCategory);
		}
		if (isNotNull(ideaSaveRequest.getRegionId())) {
			Region region = new Region();
			region.setRegionId(Long.valueOf(ideaSaveRequest.getRegionId()));
			savedIdeaDomain.setRegion(region);
		}
		if (isNotNull(ideaSaveRequest.getDescription()))
			savedIdeaDomain.setDescription(ideaSaveRequest.getDescription());

		if (isNotNull(ideaSaveRequest.getPainPointComments()))
			savedIdeaDomain.setPainPointComments(ideaSaveRequest.getPainPointComments());

		if (isNotNull(ideaSaveRequest.getAutomationGoalId())) {
			AutomationGoal goal = new AutomationGoal();
			goal.setAutomationGoalId(Long.valueOf(ideaSaveRequest.getAutomationGoalId()));
			savedIdeaDomain.setAutomationGoals(goal);
		}

		if (isNotNull(ideaSaveRequest.getProcessStabilityChangeId())) {
			EnvironmentStability processStability = new EnvironmentStability();
			processStability.setEnvStabilityId(Long.valueOf(ideaSaveRequest.getProcessStabilityChangeId()));
			savedIdeaDomain.setProcessStabilityChange(processStability);
		}

		if (isNotNull(ideaSaveRequest.getApplicationStabilityChangeId())) {
			EnvironmentStability appStability = new EnvironmentStability();
			appStability.setEnvStabilityId(Long.valueOf(ideaSaveRequest.getApplicationStabilityChangeId()));
			savedIdeaDomain.setApplicationStabilityChange(appStability);
		}

		if (isNotNull(ideaSaveRequest.getAutomationProfileComments()))
			savedIdeaDomain.setAutomationProfileComments(ideaSaveRequest.getAutomationProfileComments());

		if (isNotNull(ideaSaveRequest.getNumberOfDaysWorked()))
			savedIdeaDomain.setNumberOfDaysWorked(ideaSaveRequest.getNumberOfDaysWorked());

		if (isNotNull(ideaSaveRequest.getWorkingHoursPerDay()))
			savedIdeaDomain.setWorkingHoursPerDay(ideaSaveRequest.getWorkingHoursPerDay());

		if (isNotNull(ideaSaveRequest.getAverageEmpFullCostYearly()))
			savedIdeaDomain.setAverageEmpFullCostYearly(ideaSaveRequest.getAverageEmpFullCostYearly());

		if (isNotNull(ideaSaveRequest.getProcessFrequencyId())) {
			ProcessFrequency frequency = new ProcessFrequency();
			frequency.setFreqId(Long.valueOf(ideaSaveRequest.getProcessFrequencyId()));
			savedIdeaDomain.setProcessFrequency(frequency);
		}
		if (isNotNull(ideaSaveRequest.getActivityVolumAverageHrsPerYear()))
			savedIdeaDomain.setActivityVolumAverageHrsPerYear(ideaSaveRequest.getActivityVolumAverageHrsPerYear());

		if (isNotNull(ideaSaveRequest.getAverageProcessingTimePerMin()))
			savedIdeaDomain.setAverageProcessingTimePerMin(ideaSaveRequest.getAverageProcessingTimePerMin());

		if (isNotNull(ideaSaveRequest.getTotalProcessingTimeHrsPerYear()))
			savedIdeaDomain.setTotalProcessingTimeHrsPerYear(ideaSaveRequest.getTotalProcessingTimeHrsPerYear());

		if (isNotNull(ideaSaveRequest.getAverageErrorRatePercentVolume()))
			savedIdeaDomain.setAverageErrorRatePercentVolume(ideaSaveRequest.getAverageErrorRatePercentVolume());

		if (isNotNull(ideaSaveRequest.getTotalReworkTimeHrsPerYear()))
			savedIdeaDomain.setTotalReworkTimeHrsPerYear(ideaSaveRequest.getTotalReworkTimeHrsPerYear());

		if (isNotNull(ideaSaveRequest.getAvgReviewTimePerTransaction()))
			savedIdeaDomain.setAvgReviewTimePerTransaction(ideaSaveRequest.getAvgReviewTimePerTransaction());

		if (isNotNull(ideaSaveRequest.getNumOfEmployeesPerformingTask()))
			savedIdeaDomain.setNumOfEmployeesPerformingTask(ideaSaveRequest.getNumOfEmployeesPerformingTask());

		if (isNotNull(ideaSaveRequest.getTotTimeNeededToPerformTask()))
			savedIdeaDomain.setTotTimeNeededToPerformTask(ideaSaveRequest.getTotTimeNeededToPerformTask());

		if (isNotNull(ideaSaveRequest.getFteRequired()))
			savedIdeaDomain.setFteRequired(ideaSaveRequest.getFteRequired());

		if (isNotNull(ideaSaveRequest.getCostPerYearForProcess()))
			savedIdeaDomain.setCostPerYearForProcess(ideaSaveRequest.getCostPerYearForProcess());

		if (isNotNull(ideaSaveRequest.getProcessVolumetryComments()))
			savedIdeaDomain.setProcessVolumetryComments(ideaSaveRequest.getProcessVolumetryComments());

		if (isNotNull(ideaSaveRequest.getProcessPeaksId())) {
			ProcessPeaks peaks = new ProcessPeaks();
			peaks.setProcessPeekId(Long.valueOf(ideaSaveRequest.getProcessPeaksId()));
			savedIdeaDomain.setProcessPeaks(peaks);
		}

		if (isNotNull(ideaSaveRequest.getAvgNumberOfSteps()))
			savedIdeaDomain.setAvgNumberOfSteps(ideaSaveRequest.getAvgNumberOfSteps());

		if (isNotNull(ideaSaveRequest.getWaysToCompleteProcessId())) {
			WaysToCompleteProcess waysToComplete = new WaysToCompleteProcess();
			waysToComplete.setWaysToCompletePrcsId(Long.valueOf(ideaSaveRequest.getWaysToCompleteProcessId()));
			savedIdeaDomain.setWaysToCompleteProcess(waysToComplete);
		}

		if (isNotNull(ideaSaveRequest.getProcessWaysComments()))
			savedIdeaDomain.setProcessWaysComments(ideaSaveRequest.getProcessWaysComments());

		if (isNotNull(ideaSaveRequest.getDigitalDataInPercentage()))
			savedIdeaDomain.setDigitalDataInPercentage(ideaSaveRequest.getDigitalDataInPercentage());

		if (isNotNull(ideaSaveRequest.getStructuredDigitalDataInPercentageId())) {
			StructDigitalDataInput inp = new StructDigitalDataInput();
			inp.setStructDataInputId(Long.valueOf(ideaSaveRequest.getStructuredDigitalDataInPercentageId()));
			savedIdeaDomain.setStructuredDigitalDataInPercentage(inp);
		}

		if (isNotNull(ideaSaveRequest.getDataAndAppComments()))
			savedIdeaDomain.setDataAndAppComments(ideaSaveRequest.getDataAndAppComments());
		// ideaDomain.setIdeaApplication(idea.getIdeaApplicationId());

		List<ApplicationDto> appList = ideaSaveRequest.getApplicationList();
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
		savedIdeaDomain.setApplicationList(appListDB);

		if (isNotNull(ideaSaveRequest.getNoOfInputFieldsId())) {
			NoOfInputFields noOfInputFields = new NoOfInputFields();
			noOfInputFields.setNoOfInputFieldsId(Long.valueOf(ideaSaveRequest.getNoOfInputFieldsId()));
			savedIdeaDomain.setNoOfInputFields(noOfInputFields);
		}

		if (isNotNull(ideaSaveRequest.getExHandlingPercentId())) {
			ExHandlingPercent exHandlingPercent = new ExHandlingPercent();
			exHandlingPercent.setExHandlingPercentId(Long.valueOf(ideaSaveRequest.getExHandlingPercentId()));
			savedIdeaDomain.setExHandlingPercent(exHandlingPercent);
		}

		if (isNotNull(ideaSaveRequest.getNumOfApplicationId())) {
			NumOfApplication numOfApplication = new NumOfApplication();
			numOfApplication.setNumOfApplicationId(Long.valueOf(ideaSaveRequest.getNumOfApplicationId()));
			savedIdeaDomain.setNumOfApplication(numOfApplication);
		}
		if (isNotNull(ideaSaveRequest.getStabilityOfAppId())) {
			StabilityOfApp stabilityOfApp = new StabilityOfApp();
			stabilityOfApp.setStabilityOfAppId(Long.valueOf(ideaSaveRequest.getStabilityOfAppId()));
			savedIdeaDomain.setStabilityOfApp(stabilityOfApp);
		}

		if (isNotNull(ideaSaveRequest.getProcessOwner()))
			savedIdeaDomain.setProcessOwner(ideaSaveRequest.getProcessOwner());

		savedIdeaDomain.setSavedBy(currentLoggedInUserId);
		savedIdeaDomain.setSavedDate(new Date());

		return savedIdeaDomain;
	}

	private static boolean isNotNull(Object object) {
		return object != null;
	}

	public static IdeaSave updateIdeaDomain(IdeaSave domainToUpdate, IdeaSaveRequest ideaSaveRequest,
			Long currentLoggedInUser) {

		if (isNotNull(ideaSaveRequest.getIdeaName()))
			domainToUpdate.setIdeaName(ideaSaveRequest.getIdeaName());

		if (isNotNull(ideaSaveRequest.getAutomationAreaId())) {
			AutomationArea area = new AutomationArea();
			area.setAutomationAreaId(Long.valueOf(ideaSaveRequest.getAutomationAreaId()));
			domainToUpdate.setAutomationArea(area);
		}
		if (isNotNull(ideaSaveRequest.getAutomationCategoryId())) {
			AutomationCategory autoCategory = new AutomationCategory();
			autoCategory.setAutomationCatId(Long.valueOf(ideaSaveRequest.getAutomationCategoryId()));
			domainToUpdate.setAutomationCategory(autoCategory);
		}
		if (isNotNull(ideaSaveRequest.getAutomationSubCategoryId())) {
			AutomationSubCategory subCategory = new AutomationSubCategory();
			subCategory.setAutomationSubCatId(Long.valueOf(ideaSaveRequest.getAutomationSubCategoryId()));
			domainToUpdate.setAutomationSubCategory(subCategory);
		}
		if (isNotNull(ideaSaveRequest.getRegionId())) {
			Region region = new Region();
			region.setRegionId(Long.valueOf(ideaSaveRequest.getRegionId()));
			domainToUpdate.setRegion(region);
		}
		if (isNotNull(ideaSaveRequest.getDescription()))
			domainToUpdate.setDescription(ideaSaveRequest.getDescription());

		if (isNotNull(ideaSaveRequest.getPainPointComments()))
			domainToUpdate.setPainPointComments(ideaSaveRequest.getPainPointComments());

		if (isNotNull(ideaSaveRequest.getAutomationGoalId())) {
			AutomationGoal goal = new AutomationGoal();
			goal.setAutomationGoalId(Long.valueOf(ideaSaveRequest.getAutomationGoalId()));
			domainToUpdate.setAutomationGoals(goal);
		}

		if (isNotNull(ideaSaveRequest.getProcessStabilityChangeId())) {
			EnvironmentStability processStability = new EnvironmentStability();
			processStability.setEnvStabilityId(Long.valueOf(ideaSaveRequest.getProcessStabilityChangeId()));
			domainToUpdate.setProcessStabilityChange(processStability);
		}

		if (isNotNull(ideaSaveRequest.getApplicationStabilityChangeId())) {
			EnvironmentStability appStability = new EnvironmentStability();
			appStability.setEnvStabilityId(Long.valueOf(ideaSaveRequest.getApplicationStabilityChangeId()));
			domainToUpdate.setApplicationStabilityChange(appStability);
		}

		if (isNotNull(ideaSaveRequest.getAutomationProfileComments()))
			domainToUpdate.setAutomationProfileComments(ideaSaveRequest.getAutomationProfileComments());

		if (isNotNull(ideaSaveRequest.getNumberOfDaysWorked()))
			domainToUpdate.setNumberOfDaysWorked(ideaSaveRequest.getNumberOfDaysWorked());

		if (isNotNull(ideaSaveRequest.getWorkingHoursPerDay()))
			domainToUpdate.setWorkingHoursPerDay(ideaSaveRequest.getWorkingHoursPerDay());

		if (isNotNull(ideaSaveRequest.getAverageEmpFullCostYearly()))
			domainToUpdate.setAverageEmpFullCostYearly(ideaSaveRequest.getAverageEmpFullCostYearly());

		if (isNotNull(ideaSaveRequest.getProcessFrequencyId())) {
			ProcessFrequency frequency = new ProcessFrequency();
			frequency.setFreqId(Long.valueOf(ideaSaveRequest.getProcessFrequencyId()));
			domainToUpdate.setProcessFrequency(frequency);
		}
		if (isNotNull(ideaSaveRequest.getActivityVolumAverageHrsPerYear()))
			domainToUpdate.setActivityVolumAverageHrsPerYear(ideaSaveRequest.getActivityVolumAverageHrsPerYear());

		if (isNotNull(ideaSaveRequest.getAverageProcessingTimePerMin()))
			domainToUpdate.setAverageProcessingTimePerMin(ideaSaveRequest.getAverageProcessingTimePerMin());

		if (isNotNull(ideaSaveRequest.getTotalProcessingTimeHrsPerYear()))
			domainToUpdate.setTotalProcessingTimeHrsPerYear(ideaSaveRequest.getTotalProcessingTimeHrsPerYear());

		if (isNotNull(ideaSaveRequest.getAverageErrorRatePercentVolume()))
			domainToUpdate.setAverageErrorRatePercentVolume(ideaSaveRequest.getAverageErrorRatePercentVolume());

		if (isNotNull(ideaSaveRequest.getTotalReworkTimeHrsPerYear()))
			domainToUpdate.setTotalReworkTimeHrsPerYear(ideaSaveRequest.getTotalReworkTimeHrsPerYear());

		if (isNotNull(ideaSaveRequest.getAvgReviewTimePerTransaction()))
			domainToUpdate.setAvgReviewTimePerTransaction(ideaSaveRequest.getAvgReviewTimePerTransaction());

		if (isNotNull(ideaSaveRequest.getNumOfEmployeesPerformingTask()))
			domainToUpdate.setNumOfEmployeesPerformingTask(ideaSaveRequest.getNumOfEmployeesPerformingTask());

		if (isNotNull(ideaSaveRequest.getTotTimeNeededToPerformTask()))
			domainToUpdate.setTotTimeNeededToPerformTask(ideaSaveRequest.getTotTimeNeededToPerformTask());

		if (isNotNull(ideaSaveRequest.getFteRequired()))
			domainToUpdate.setFteRequired(ideaSaveRequest.getFteRequired());

		if (isNotNull(ideaSaveRequest.getCostPerYearForProcess()))
			domainToUpdate.setCostPerYearForProcess(ideaSaveRequest.getCostPerYearForProcess());

		if (isNotNull(ideaSaveRequest.getProcessVolumetryComments()))
			domainToUpdate.setProcessVolumetryComments(ideaSaveRequest.getProcessVolumetryComments());

		if (isNotNull(ideaSaveRequest.getProcessPeaksId())) {
			ProcessPeaks peaks = new ProcessPeaks();
			peaks.setProcessPeekId(Long.valueOf(ideaSaveRequest.getProcessPeaksId()));
			domainToUpdate.setProcessPeaks(peaks);
		}

		if (isNotNull(ideaSaveRequest.getAvgNumberOfSteps()))
			domainToUpdate.setAvgNumberOfSteps(ideaSaveRequest.getAvgNumberOfSteps());

		if (isNotNull(ideaSaveRequest.getWaysToCompleteProcessId())) {
			WaysToCompleteProcess waysToComplete = new WaysToCompleteProcess();
			waysToComplete.setWaysToCompletePrcsId(Long.valueOf(ideaSaveRequest.getWaysToCompleteProcessId()));
			domainToUpdate.setWaysToCompleteProcess(waysToComplete);
		}

		if (isNotNull(ideaSaveRequest.getProcessWaysComments()))
			domainToUpdate.setProcessWaysComments(ideaSaveRequest.getProcessWaysComments());

		if (isNotNull(ideaSaveRequest.getDigitalDataInPercentage()))
			domainToUpdate.setDigitalDataInPercentage(ideaSaveRequest.getDigitalDataInPercentage());

		if (isNotNull(ideaSaveRequest.getStructuredDigitalDataInPercentageId())) {
			StructDigitalDataInput inp = new StructDigitalDataInput();
			inp.setStructDataInputId(Long.valueOf(ideaSaveRequest.getStructuredDigitalDataInPercentageId()));
			domainToUpdate.setStructuredDigitalDataInPercentage(inp);
		}

		if (isNotNull(ideaSaveRequest.getDataAndAppComments()))
			domainToUpdate.setDataAndAppComments(ideaSaveRequest.getDataAndAppComments());
		// ideaDomain.setIdeaApplication(idea.getIdeaApplicationId());

		List<ApplicationDto> appList = ideaSaveRequest.getApplicationList();
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
		domainToUpdate.setApplicationList(appListDB);

		if (isNotNull(ideaSaveRequest.getNoOfInputFieldsId())) {
			NoOfInputFields noOfInputFields = new NoOfInputFields();
			noOfInputFields.setNoOfInputFieldsId(Long.valueOf(ideaSaveRequest.getNoOfInputFieldsId()));
			domainToUpdate.setNoOfInputFields(noOfInputFields);
		}

		if (isNotNull(ideaSaveRequest.getExHandlingPercentId())) {
			ExHandlingPercent exHandlingPercent = new ExHandlingPercent();
			exHandlingPercent.setExHandlingPercentId(Long.valueOf(ideaSaveRequest.getExHandlingPercentId()));
			domainToUpdate.setExHandlingPercent(exHandlingPercent);
		}

		if (isNotNull(ideaSaveRequest.getNumOfApplicationId())) {
			NumOfApplication numOfApplication = new NumOfApplication();
			numOfApplication.setNumOfApplicationId(Long.valueOf(ideaSaveRequest.getNumOfApplicationId()));
			domainToUpdate.setNumOfApplication(numOfApplication);
		}
		if (isNotNull(ideaSaveRequest.getStabilityOfAppId())) {
			StabilityOfApp stabilityOfApp = new StabilityOfApp();
			stabilityOfApp.setStabilityOfAppId(Long.valueOf(ideaSaveRequest.getStabilityOfAppId()));
			domainToUpdate.setStabilityOfApp(stabilityOfApp);
		}

		if (isNotNull(ideaSaveRequest.getProcessOwner()))
			domainToUpdate.setProcessOwner(ideaSaveRequest.getProcessOwner());

		domainToUpdate.setSavedBy(currentLoggedInUser);
		domainToUpdate.setSavedDate(new Date());

		return domainToUpdate;
	}

}
