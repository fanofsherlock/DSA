package com.nissan.assessment.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.nissan.assessment.util.IdeaSequenceIdGenerator;
import com.nissan.core.entities.Region;

@Entity
@Table
public class Idea {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idea_seq")
	@GenericGenerator(name = "idea_seq", strategy = "com.nissan.assessment.util.IdeaSequenceIdGenerator", parameters = {
			@Parameter(name = IdeaSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name = IdeaSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "IDEA"),
			@Parameter(name = IdeaSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%06d") })
	private String ideaId;

	// private Long ideaId;

	@Column
	private String ideaName;

	@ManyToOne
	private AutomationArea automationArea;

	@ManyToOne
	private AutomationCategory automationCategory;

	@ManyToOne
	private AutomationSubCategory automationSubCategory;

	@ManyToOne
	private Region region;

	@Column(length = 1000)
	private String description;

	@Column(length = 500)
	private String painPointComments;

	@ManyToOne
	private AutomationGoal automationGoals;

	@ManyToOne
	private EnvironmentStability processStabilityChange;

	@ManyToOne
	private EnvironmentStability applicationStabilityChange;

	@Column(length = 500)
	private String automationProfileComments;

	@Column
	private Integer numberOfDaysWorked;

	@Column
	private Integer workingHoursPerDay;

	@Column
	private Integer averageEmpFullCostYearly;

	@ManyToOne
	private ProcessFrequency processFrequency;

	@Column
	private Integer activityVolumAverageHrsPerYear;

	@Column
	private Integer averageProcessingTimePerMin;

	@Column
	private Double totalProcessingTimeHrsPerYear;

	@Column
	private Integer averageErrorRatePercentVolume;

	@Column
	private Double totalReworkTimeHrsPerYear;

	@Column
	private Integer avgReviewTimePerTransaction;

	@Column
	private Integer numOfEmployeesPerformingTask;

	@Column
	private String totTimeNeededToPerformTask;

	@Column
	private Integer fteRequired;

	@Column
	private String costPerYearForProcess;

	@Column(length = 500)
	private String processVolumetryComments;

	@ManyToOne
	private ProcessPeaks processPeaks;

	@Column
	private Integer avgNumberOfSteps;

	@ManyToOne
	private WaysToCompleteProcess waysToCompleteProcess;

	@ManyToOne
	private NoOfInputFields noOfInputFields;

	@ManyToOne
	private ExHandlingPercent exHandlingPercent;

	@ManyToOne
	private NumOfApplication numOfApplication;

	@ManyToOne
	private StabilityOfApp stabilityOfApp;

	@Column(length = 500)
	private String processWaysComments;

	@Column
	private Integer digitalDataInPercentage;

	@ManyToOne
	private StructDigitalDataInput structuredDigitalDataInPercentage;

	@Column(length = 500)
	private String dataAndAppComments;

	@OneToMany(cascade = CascadeType.ALL)
	private List<IdeaApplication> applicationList;

	// @ManyToOne
	// @JoinColumn(name = "ideaStateId", referencedColumnName = "ideaStateId")
	// private IdeaState ideaState;

	@ManyToOne
	@JoinColumn(name = "ideaState", referencedColumnName = "ideaStateId")
	private IdeaState ideaState;

	@Column
	private Long submittedBy;

	@Column
	private Long approverId;

	@Column
	private Date submittedDate;

	@Column
	private Date approvedDate;

	// @JoinColumn(name = "phaseDocId", referencedColumnName = "phaseDocId")
	@OneToMany
	private List<PhaseDocument> phaseDocument;

	@Column
	private String processOwner;

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

	public List<IdeaApplication> getApplicationList() {
		return applicationList;
	}

	public void setApplicationList(List<IdeaApplication> applicationList) {
		this.applicationList = applicationList;
	}

	public IdeaState getIdeaState() {
		return ideaState;
	}

	public void setIdeaState(IdeaState ideaState) {
		this.ideaState = ideaState;
	}

	public Long getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(Long submittedBy) {
		this.submittedBy = submittedBy;
	}

	public Long getApproverId() {
		return approverId;
	}

	public void setApproverId(Long approverId) {
		this.approverId = approverId;
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

	public List<PhaseDocument> getPhaseDocument() {
		return phaseDocument;
	}

	public void setPhaseDocument(List<PhaseDocument> phaseDocument) {
		this.phaseDocument = phaseDocument;
	}

	public String getProcessOwner() {
		return processOwner;
	}

	public void setProcessOwner(String processOwner) {
		this.processOwner = processOwner;
	}

}
