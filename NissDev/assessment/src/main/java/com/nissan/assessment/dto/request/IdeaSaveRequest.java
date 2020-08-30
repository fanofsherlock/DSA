package com.nissan.assessment.dto.request;

import java.util.Date;
import java.util.List;

import com.nissan.assessment.dto.ApplicationDto;

public class IdeaSaveRequest {

	private String ideaId;

	private String ideaName;

	private Integer automationAreaId;

	private Integer automationCategoryId;

	private Integer automationSubCategoryId;

	private Integer regionId;

	private String description;

	private String painPointComments;

	private Integer automationGoalId;

	private Integer processStabilityChangeId;

	private Integer applicationStabilityChangeId;

	private String automationProfileComments;

	private Integer numberOfDaysWorked;

	private Integer workingHoursPerDay;

	private Integer averageEmpFullCostYearly;

	private Integer processFrequencyId;

	private Integer activityVolumAverageHrsPerYear;

	private Integer averageProcessingTimePerMin;

	private Double totalProcessingTimeHrsPerYear;

	private Integer averageErrorRatePercentVolume;

	private Double totalReworkTimeHrsPerYear;

	private Integer avgReviewTimePerTransaction;

	private Integer numOfEmployeesPerformingTask;

	private String totTimeNeededToPerformTask;

	private Integer fteRequired;

	private String costPerYearForProcess;

	private String processVolumetryComments;

	private Integer processPeaksId;

	private String avgNumberOfSteps;

	private Integer waysToCompleteProcessId;

	private String processWaysComments;

	private String digitalDataInPercentage;

	private Integer structuredDigitalDataInPercentageId;

	private String dataAndAppComments;

	// private Integer ideaApplicationId;

	List<ApplicationDto> applicationList;

	private Integer noOfInputFieldsId;

	private Integer exHandlingPercentId;

	private Integer numOfApplicationId;

	private Integer stabilityOfAppId;

	private String processOwner;

	private Long approverId;

	private Date savedDate;

	private String savedBy;

	public String getIdeaId() {
		return ideaId;
	}

	public void setIdeaId(String ideaId) {
		this.ideaId = ideaId;
	}

	public String getIdeaName() {
		return ideaName;
	}

	public void setIdeaName(String ideaName) {
		this.ideaName = ideaName;
	}

	public Integer getAutomationAreaId() {
		return automationAreaId;
	}

	public void setAutomationAreaId(Integer automationAreaId) {
		this.automationAreaId = automationAreaId;
	}

	public Integer getAutomationCategoryId() {
		return automationCategoryId;
	}

	public void setAutomationCategoryId(Integer automationCategoryId) {
		this.automationCategoryId = automationCategoryId;
	}

	public Integer getAutomationSubCategoryId() {
		return automationSubCategoryId;
	}

	public void setAutomationSubCategoryId(Integer automationSubCategoryId) {
		this.automationSubCategoryId = automationSubCategoryId;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPainPointComments() {
		return painPointComments;
	}

	public void setPainPointComments(String painPointComments) {
		this.painPointComments = painPointComments;
	}

	public Integer getAutomationGoalId() {
		return automationGoalId;
	}

	public void setAutomationGoalId(Integer automationGoalId) {
		this.automationGoalId = automationGoalId;
	}

	public Integer getProcessStabilityChangeId() {
		return processStabilityChangeId;
	}

	public void setProcessStabilityChangeId(Integer processStabilityChangeId) {
		this.processStabilityChangeId = processStabilityChangeId;
	}

	public Integer getApplicationStabilityChangeId() {
		return applicationStabilityChangeId;
	}

	public void setApplicationStabilityChangeId(Integer applicationStabilityChangeId) {
		this.applicationStabilityChangeId = applicationStabilityChangeId;
	}

	public String getAutomationProfileComments() {
		return automationProfileComments;
	}

	public void setAutomationProfileComments(String automationProfileComments) {
		this.automationProfileComments = automationProfileComments;
	}

	public Integer getNumberOfDaysWorked() {
		return numberOfDaysWorked;
	}

	public void setNumberOfDaysWorked(Integer numberOfDaysWorked) {
		this.numberOfDaysWorked = numberOfDaysWorked;
	}

	public Integer getWorkingHoursPerDay() {
		return workingHoursPerDay;
	}

	public void setWorkingHoursPerDay(Integer workingHoursPerDay) {
		this.workingHoursPerDay = workingHoursPerDay;
	}

	public Integer getAverageEmpFullCostYearly() {
		return averageEmpFullCostYearly;
	}

	public void setAverageEmpFullCostYearly(Integer averageEmpFullCostYearly) {
		this.averageEmpFullCostYearly = averageEmpFullCostYearly;
	}

	public Integer getProcessFrequencyId() {
		return processFrequencyId;
	}

	public void setProcessFrequencyId(Integer processFrequencyId) {
		this.processFrequencyId = processFrequencyId;
	}

	public Integer getActivityVolumAverageHrsPerYear() {
		return activityVolumAverageHrsPerYear;
	}

	public void setActivityVolumAverageHrsPerYear(Integer activityVolumAverageHrsPerYear) {
		this.activityVolumAverageHrsPerYear = activityVolumAverageHrsPerYear;
	}

	public Integer getAverageProcessingTimePerMin() {
		return averageProcessingTimePerMin;
	}

	public void setAverageProcessingTimePerMin(Integer averageProcessingTimePerMin) {
		this.averageProcessingTimePerMin = averageProcessingTimePerMin;
	}

	public Double getTotalProcessingTimeHrsPerYear() {
		return totalProcessingTimeHrsPerYear;
	}

	public void setTotalProcessingTimeHrsPerYear(Double totalProcessingTimeHrsPerYear) {
		this.totalProcessingTimeHrsPerYear = totalProcessingTimeHrsPerYear;
	}

	public Integer getAverageErrorRatePercentVolume() {
		return averageErrorRatePercentVolume;
	}

	public void setAverageErrorRatePercentVolume(Integer averageErrorRatePercentVolume) {
		this.averageErrorRatePercentVolume = averageErrorRatePercentVolume;
	}

	public Double getTotalReworkTimeHrsPerYear() {
		return totalReworkTimeHrsPerYear;
	}

	public void setTotalReworkTimeHrsPerYear(Double totalReworkTimeHrsPerYear) {
		this.totalReworkTimeHrsPerYear = totalReworkTimeHrsPerYear;
	}

	public String getProcessVolumetryComments() {
		return processVolumetryComments;
	}

	public void setProcessVolumetryComments(String processVolumetryComments) {
		this.processVolumetryComments = processVolumetryComments;
	}

	public Integer getProcessPeaksId() {
		return processPeaksId;
	}

	public void setProcessPeaksId(Integer processPeaksId) {
		this.processPeaksId = processPeaksId;
	}

	public String getAvgNumberOfSteps() {
		return avgNumberOfSteps;
	}

	public void setAvgNumberOfSteps(String avgNumberOfSteps) {
		this.avgNumberOfSteps = avgNumberOfSteps;
	}

	public Integer getWaysToCompleteProcessId() {
		return waysToCompleteProcessId;
	}

	public void setWaysToCompleteProcessId(Integer waysToCompleteProcessId) {
		this.waysToCompleteProcessId = waysToCompleteProcessId;
	}

	public String getProcessWaysComments() {
		return processWaysComments;
	}

	public void setProcessWaysComments(String processWaysComments) {
		this.processWaysComments = processWaysComments;
	}

	public String getDigitalDataInPercentage() {
		return digitalDataInPercentage;
	}

	public void setDigitalDataInPercentage(String digitalDataInPercentage) {
		this.digitalDataInPercentage = digitalDataInPercentage;
	}

	public Integer getStructuredDigitalDataInPercentageId() {
		return structuredDigitalDataInPercentageId;
	}

	public void setStructuredDigitalDataInPercentageId(Integer structuredDigitalDataInPercentageId) {
		this.structuredDigitalDataInPercentageId = structuredDigitalDataInPercentageId;
	}

	public String getDataAndAppComments() {
		return dataAndAppComments;
	}

	public void setDataAndAppComments(String dataAndAppComments) {
		this.dataAndAppComments = dataAndAppComments;
	}

	public List<ApplicationDto> getApplicationList() {
		return applicationList;
	}

	public void setApplicationList(List<ApplicationDto> applicationList) {
		this.applicationList = applicationList;
	}

	public Integer getNoOfInputFieldsId() {
		return noOfInputFieldsId;
	}

	public void setNoOfInputFieldsId(Integer noOfInputFieldsId) {
		this.noOfInputFieldsId = noOfInputFieldsId;
	}

	public Integer getExHandlingPercentId() {
		return exHandlingPercentId;
	}

	public void setExHandlingPercentId(Integer exHandlingPercentId) {
		this.exHandlingPercentId = exHandlingPercentId;
	}

	public Integer getNumOfApplicationId() {
		return numOfApplicationId;
	}

	public void setNumOfApplicationId(Integer numOfApplicationId) {
		this.numOfApplicationId = numOfApplicationId;
	}

	public Integer getStabilityOfAppId() {
		return stabilityOfAppId;
	}

	public void setStabilityOfAppId(Integer stabilityOfAppId) {
		this.stabilityOfAppId = stabilityOfAppId;
	}

	public String getProcessOwner() {
		return processOwner;
	}

	public void setProcessOwner(String processOwner) {
		this.processOwner = processOwner;
	}

	public Date getSavedDate() {
		return savedDate;
	}

	public void setSavedDate(Date savedDate) {
		this.savedDate = savedDate;
	}

	public String getSavedBy() {
		return savedBy;
	}

	public void setSavedBy(String savedBy) {
		this.savedBy = savedBy;
	}

	public Integer getAvgReviewTimePerTransaction() {
		return avgReviewTimePerTransaction;
	}

	public void setAvgReviewTimePerTransaction(Integer avgReviewTimePerTransaction) {
		this.avgReviewTimePerTransaction = avgReviewTimePerTransaction;
	}

	public Integer getNumOfEmployeesPerformingTask() {
		return numOfEmployeesPerformingTask;
	}

	public void setNumOfEmployeesPerformingTask(Integer numOfEmployeesPerformingTask) {
		this.numOfEmployeesPerformingTask = numOfEmployeesPerformingTask;
	}

	public String getTotTimeNeededToPerformTask() {
		return totTimeNeededToPerformTask;
	}

	public void setTotTimeNeededToPerformTask(String totTimeNeededToPerformTask) {
		this.totTimeNeededToPerformTask = totTimeNeededToPerformTask;
	}

	public Integer getFteRequired() {
		return fteRequired;
	}

	public void setFteRequired(Integer fteRequired) {
		this.fteRequired = fteRequired;
	}

	public String getCostPerYearForProcess() {
		return costPerYearForProcess;
	}

	public void setCostPerYearForProcess(String costPerYearForProcess) {
		this.costPerYearForProcess = costPerYearForProcess;
	}

	public Long getApproverId() {
		return approverId;
	}

	public void setApproverId(Long approverId) {
		this.approverId = approverId;
	}

}
