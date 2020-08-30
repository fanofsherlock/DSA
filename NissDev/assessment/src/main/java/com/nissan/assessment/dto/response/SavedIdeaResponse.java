package com.nissan.assessment.dto.response;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.nissan.assessment.dto.ApplicationDto;
import com.nissan.assessment.entities.AutomationArea;
import com.nissan.assessment.entities.AutomationCategory;
import com.nissan.assessment.entities.AutomationGoal;
import com.nissan.assessment.entities.AutomationSubCategory;
import com.nissan.assessment.entities.Document;
import com.nissan.assessment.entities.EnvironmentStability;
import com.nissan.assessment.entities.ExHandlingPercent;
import com.nissan.assessment.entities.IdeaState;
import com.nissan.assessment.entities.NoOfInputFields;
import com.nissan.assessment.entities.NumOfApplication;
import com.nissan.assessment.entities.PhaseDocument;
import com.nissan.assessment.entities.ProcessFrequency;
import com.nissan.assessment.entities.ProcessPeaks;
import com.nissan.assessment.entities.StabilityOfApp;
import com.nissan.assessment.entities.StructDigitalDataInput;
import com.nissan.assessment.entities.WaysToCompleteProcess;
import com.nissan.core.entities.Region;

public class SavedIdeaResponse {

	private String ideaId;

	private String ideaName;

	private AutomationArea automationArea;

	private AutomationCategory automationCategory;

	private AutomationSubCategory automationSubCategory;

	private Region region;

	private String description;

	private String painPointComments;

	private AutomationGoal automationGoals;

	private EnvironmentStability processStabilityChange;

	private EnvironmentStability applicationStabilityChange;

	private String automationProfileComments;

	private Integer numberOfDaysWorked;

	private Integer workingHoursPerDay;

	private Integer averageEmpFullCostYearly;

	private ProcessFrequency processFrequency;

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

	private ProcessPeaks processPeaks;

	private Integer avgNumberOfSteps;

	private WaysToCompleteProcess waysToCompleteProcess;

	private String processWaysComments;

	private Integer digitalDataInPercentage;

	private StructDigitalDataInput structuredDigitalDataInPercentage;

	private String dataAndAppComments;

	private List<ApplicationDto> applicationList;

	private IdeaState ideaState;

	private NoOfInputFields noOfInputFields;

	private ExHandlingPercent exHandlingPercent;

	private NumOfApplication numOfApplication;

	private StabilityOfApp stabilityOfApp;

	private String processOwner;

	private String submittedBy;

	private String approvedBy;

	private Date submittedDate;

	private Date approvedDate;

	private List<Document> Documents;

	public void processPhaseDocs(List<PhaseDocument> list) {
		Documents = list.parallelStream().map(e -> e.getDocumentDetails()).collect(Collectors.toList());
	}

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

	public AutomationArea getAutomationArea() {
		return automationArea;
	}

	public void setAutomationArea(AutomationArea automationArea) {
		this.automationArea = automationArea;
	}

	public AutomationCategory getAutomationCategory() {
		return automationCategory;
	}

	public void setAutomationCategory(AutomationCategory automationCategory) {
		this.automationCategory = automationCategory;
	}

	public AutomationSubCategory getAutomationSubCategory() {
		return automationSubCategory;
	}

	public void setAutomationSubCategory(AutomationSubCategory automationSubCategory) {
		this.automationSubCategory = automationSubCategory;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
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

	public AutomationGoal getAutomationGoals() {
		return automationGoals;
	}

	public void setAutomationGoals(AutomationGoal automationGoals) {
		this.automationGoals = automationGoals;
	}

	public EnvironmentStability getProcessStabilityChange() {
		return processStabilityChange;
	}

	public void setProcessStabilityChange(EnvironmentStability processStabilityChange) {
		this.processStabilityChange = processStabilityChange;
	}

	public EnvironmentStability getApplicationStabilityChange() {
		return applicationStabilityChange;
	}

	public void setApplicationStabilityChange(EnvironmentStability applicationStabilityChange) {
		this.applicationStabilityChange = applicationStabilityChange;
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

	public ProcessFrequency getProcessFrequency() {
		return processFrequency;
	}

	public void setProcessFrequency(ProcessFrequency processFrequency) {
		this.processFrequency = processFrequency;
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

	public ProcessPeaks getProcessPeaks() {
		return processPeaks;
	}

	public void setProcessPeaks(ProcessPeaks processPeaks) {
		this.processPeaks = processPeaks;
	}

	public Integer getAvgNumberOfSteps() {
		return avgNumberOfSteps;
	}

	public void setAvgNumberOfSteps(Integer avgNumberOfSteps) {
		this.avgNumberOfSteps = avgNumberOfSteps;
	}

	public WaysToCompleteProcess getWaysToCompleteProcess() {
		return waysToCompleteProcess;
	}

	public void setWaysToCompleteProcess(WaysToCompleteProcess waysToCompleteProcess) {
		this.waysToCompleteProcess = waysToCompleteProcess;
	}

	public String getProcessWaysComments() {
		return processWaysComments;
	}

	public void setProcessWaysComments(String processWaysComments) {
		this.processWaysComments = processWaysComments;
	}

	public Integer getDigitalDataInPercentage() {
		return digitalDataInPercentage;
	}

	public void setDigitalDataInPercentage(Integer digitalDataInPercentage) {
		this.digitalDataInPercentage = digitalDataInPercentage;
	}

	public StructDigitalDataInput getStructuredDigitalDataInPercentage() {
		return structuredDigitalDataInPercentage;
	}

	public void setStructuredDigitalDataInPercentage(StructDigitalDataInput structuredDigitalDataInPercentage) {
		this.structuredDigitalDataInPercentage = structuredDigitalDataInPercentage;
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

	public IdeaState getIdeaState() {
		return ideaState;
	}

	public void setIdeaState(IdeaState ideaState) {
		this.ideaState = ideaState;
	}

	public String getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Date getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public List<Document> getDocuments() {
		return Documents;
	}

	public void setDocuments(List<Document> documents) {
		Documents = documents;
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

	public NoOfInputFields getNoOfInputFields() {
		return noOfInputFields;
	}

	public void setNoOfInputFields(NoOfInputFields noOfInputFields) {
		this.noOfInputFields = noOfInputFields;
	}

	public ExHandlingPercent getExHandlingPercent() {
		return exHandlingPercent;
	}

	public void setExHandlingPercent(ExHandlingPercent exHandlingPercent) {
		this.exHandlingPercent = exHandlingPercent;
	}

	public NumOfApplication getNumOfApplication() {
		return numOfApplication;
	}

	public void setNumOfApplication(NumOfApplication numOfApplication) {
		this.numOfApplication = numOfApplication;
	}

	public StabilityOfApp getStabilityOfApp() {
		return stabilityOfApp;
	}

	public void setStabilityOfApp(StabilityOfApp stabilityOfApp) {
		this.stabilityOfApp = stabilityOfApp;
	}

	public String getProcessOwner() {
		return processOwner;
	}

	public void setProcessOwner(String processOwner) {
		this.processOwner = processOwner;
	}

}
