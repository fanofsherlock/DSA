package com.nissan.assessment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.assessment.entities.AssessmentTollGateCheckListIdeaReview;
import com.nissan.assessment.entities.AssessmentTollGateChecklist;
import com.nissan.assessment.entities.AutomationArea;
import com.nissan.assessment.entities.AutomationCategory;
import com.nissan.assessment.entities.AutomationGoal;
import com.nissan.assessment.entities.AutomationSubCategory;
import com.nissan.assessment.entities.DeploymentTollGateCheckListIdeaReview;
import com.nissan.assessment.entities.DeploymentTollGateChecklist;
import com.nissan.assessment.entities.EnvironmentStability;
import com.nissan.assessment.entities.ExHandlingPercent;
import com.nissan.assessment.entities.NoOfInputFields;
import com.nissan.assessment.entities.NumOfApplication;
import com.nissan.assessment.entities.ProcessFrequency;
import com.nissan.assessment.entities.ProcessPeaks;
import com.nissan.assessment.entities.StabilityOfApp;
import com.nissan.assessment.entities.StructDigitalDataInput;
import com.nissan.assessment.entities.WaysToCompleteProcess;
import com.nissan.assessment.service.MasterTableDataCreationService;
import com.nissan.assessment.service.MasterTableDataService;
import com.nissan.core.entities.Region;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/core")
@Api(value = "Automation and Process Data for Assessment", description = "Operations pertaining to Automation and Process Data")
public class MasterDataController {

	@Autowired
	private MasterTableDataService masterTables;

	@Autowired
	private MasterTableDataCreationService masterTablesCreate;

	private static Logger logger = LoggerFactory.getLogger(MasterDataController.class);

	@ApiOperation(value = "Get List of all Automation Areas", response = List.class)
	@RequestMapping(value = "/getAllAutomationAreas", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<AutomationArea> getAreaResponse() {
		logger.debug("MasterDataController: START : getAreaResponse ");
		return masterTables.getAllAutomationAreas();
	}

	@ApiOperation(value = "Get List of all Automation Categories", response = List.class)
	@RequestMapping(value = "/getAllAutomationCategories", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<AutomationCategory> getCategoryResponse() {
		logger.debug("MasterDataController: START : getCategoryResponse ");
		return masterTables.getAllAutomationCategories();
	}

	@ApiOperation(value = "Get List of all Automation Sub Categories", response = List.class)
	@RequestMapping(value = "/getAllAutomationSubCategories", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<AutomationSubCategory> getSubCategoryResponse() {
		logger.debug("MasterDataController: START : getSubCategoryResponse ");
		return masterTables.getAllAutomationSubCategories();
	}

	@ApiOperation(value = "Get List of all Automation Goals", response = List.class)
	@RequestMapping(value = "/getAllAutomationGoals", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<AutomationGoal> getAutomationReasons() {
		return masterTables.getAllAutomationReasons();
	}

	@ApiOperation(value = "Get List of all Process Frequencies", response = List.class)
	@RequestMapping(value = "/getProcessFreq", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<ProcessFrequency> getProcessFreq() {
		return masterTables.getProcessFreq();
	}

	@ApiOperation(value = "Get List of all Process Peaks", response = List.class)
	@RequestMapping(value = "/getProcessPeaks", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<ProcessPeaks> getProcessPeaks() {
		return masterTables.getProcessPeaks();
	}

	@ApiOperation(value = "Get Ways to Complete", response = List.class)
	@RequestMapping(value = "/getWaysToComplete", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<WaysToCompleteProcess> getWaysToComplete() {
		return masterTables.getWaysToComplete();
	}

	@ApiOperation(value = "Get Structured Data Input", response = List.class)
	@RequestMapping(value = "/getStructuredDataInput", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<StructDigitalDataInput> getStructuredDataInput() {
		return masterTables.getStructuredDataInput();
	}

	@ApiOperation(value = "Get Number of Fields to Input the Process", response = List.class)
	@RequestMapping(value = "/getNoOfInputFieldsToProcess", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<NoOfInputFields> getNoOfInputFields() {
		return masterTables.getNoOfInputFields();
	}

	@ApiOperation(value = "Get Exception Handling Percentage", response = List.class)
	@RequestMapping(value = "/getExHandlingPercentage", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<ExHandlingPercent> getExHandlingPercent() {
		return masterTables.getExHandlingPercent();
	}

	@ApiOperation(value = "Get Number of Applications", response = List.class)
	@RequestMapping(value = "/getNoOfApplications", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<NumOfApplication> getNoOfApplication() {
		return masterTables.getNoOfApplication();
	}

	@ApiOperation(value = "Get Stability of Applications", response = List.class)
	@RequestMapping(value = "/getStabilityOfApplications", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<StabilityOfApp> getStabilityOfApplications() {
		return masterTables.getStabilityOfApplications();
	}

	@ApiOperation(value = "Get Environment Stability Labels", response = List.class)
	@RequestMapping(value = "/getEnvironmentStability", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<EnvironmentStability> getEnvStability() {
		return masterTables.getEnvStabilityStatus();
	}

	@ApiOperation(value = "Get Assessment Toll Gate Review CheckList Items", response = List.class)
	@RequestMapping(value = "/getAssessmentTollGateReviewCheckList", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<AssessmentTollGateChecklist> getAssessmentTollGateReviewCheckList() {
		return masterTables.getAssessmentTollGateChecklist();
	}

	@ApiOperation(value = "Get Toll Gate Review CheckList Items", response = List.class)
	@RequestMapping(value = "/getDeploymentTollGateReviewCheckList", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<DeploymentTollGateChecklist> getDeploymentTollGateReviewCheckList() {
		return masterTables.getDeploymentTollGateChecklist();
	}

	@ApiOperation(value = "Get Assessment Toll Gate Idea Reviews data", response = List.class)
	@RequestMapping(value = "/getAssessmentTollGateIdeaReviews", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<AssessmentTollGateCheckListIdeaReview> getAssessmentIdeaReview() {
		return masterTables.getAssessmentTollGateCheckListIdeaReview();
	}

	@ApiOperation(value = "Get List of regions", response = List.class)
	@RequestMapping(value = "/getAllRegions", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Region> getAllRegions() {
		return masterTables.getAllRegions();
	}

	@ApiOperation(value = "Get Deployment Toll Gate Idea Reviews data", response = List.class)
	@RequestMapping(value = "/getDeploymentTollGateIdeaReviews", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<DeploymentTollGateCheckListIdeaReview> getDeploymentIdeaReview() {
		return masterTables.getDeploymentTollGateCheckListIdeaReview();
	}

	@PostMapping("/createMasterData")
	public void createMasterData() {
		logger.debug("MasterDataController: START : createMasterData thru Create ");
		masterTablesCreate.createAutomationAreaData();
		masterTablesCreate.createEnvironmentStabilityTable();
		masterTablesCreate.createIdeaStates();
		masterTablesCreate.createPhaseData();
		masterTablesCreate.createDocument();
		masterTablesCreate.createPhaseDocument();
		masterTablesCreate.createAutomationCategory();
		masterTablesCreate.createAutomationSubCategory();
		masterTablesCreate.createAutomationReason();
		masterTablesCreate.createProcessFreq();
		masterTablesCreate.createProcessPeeks();
		masterTablesCreate.createWaysToComplete();
		masterTablesCreate.createStructuredDataInput();
		masterTablesCreate.createAssessmentTollGateCheckList();
		masterTablesCreate.createDeploymentTollGateCheckList();
		masterTablesCreate.createNumOfFieldsToInputPrcs();
		masterTablesCreate.createExHandlingPercent();
		masterTablesCreate.createNumofApplications();
		masterTablesCreate.createStabilityOfApps();
		masterTablesCreate.createRegions();

		// masterTablesCreate.createIdeas();

		logger.debug("MasterDataController: END : createMasterData thru Create");
	}
}