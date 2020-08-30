package com.nissan.assessment.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.assessment.entities.AssessmentTollGateChecklist;
import com.nissan.assessment.entities.AutomationArea;
import com.nissan.assessment.entities.AutomationCategory;
import com.nissan.assessment.entities.AutomationGoal;
import com.nissan.assessment.entities.AutomationSubCategory;
import com.nissan.assessment.entities.DeploymentTollGateChecklist;
import com.nissan.assessment.entities.Document;
import com.nissan.assessment.entities.EnvironmentStability;
import com.nissan.assessment.entities.ExHandlingPercent;
import com.nissan.assessment.entities.Idea;
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
import com.nissan.assessment.repository.AssessmentTollGateChecklistRepo;
import com.nissan.assessment.repository.AutomationAreaRepository;
import com.nissan.assessment.repository.AutomationCategoryRepository;
import com.nissan.assessment.repository.AutomationGoalRepository;
import com.nissan.assessment.repository.AutomationSubCategoryRepository;
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
import com.nissan.assessment.service.MasterTableDataCreationService;
import com.nissan.assessment.service.MasterTableDataService;
import com.nissan.core.entities.Region;
import com.nissan.core.repository.RegionRepository;

@Service
public class MasterTableDataCreationServiceImpl implements MasterTableDataCreationService {

	@Autowired
	MasterTableDataService masterTables;

	@Autowired
	PhaseDocumentRepository phaseDocRepository;

	@Autowired
	IdeaStateRepository ideaStateRepository;

	@Autowired
	PhaseRepository phaseRepository;

	@Autowired
	DocumentRepository docsRepository;

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
	IdeaRepository ideaRepository;

	@Autowired
	AssessmentTollGateChecklistRepo assessmentTollGateChecklistRepository;

	@Autowired
	DeploymentTollGateChecklistRepo deploymentTollGateChecklistRepository;

	@Autowired
	NoOfInputFieldsRepository noOfInputFieldsRepository;

	@Autowired
	ExHandlingPercentRepository exHandlingPercentRepository;

	@Autowired
	NoOfApplicationRepository noOfApplicationRepository;

	@Autowired
	StabilityOfAppRepository stabilityOfAppRepository;

	@Autowired
	RegionRepository regionRepository;

	public void createPhaseDocument() {

		Phase phase = masterTables.getAllPhases().get(0);
		Document document = masterTables.getAllDocs().get(0);
		PhaseDocument phaseDocument = new PhaseDocument();
		phaseDocument.setPhaseDetails(phase);
		phaseDocument.setDocumentDetails(document);
		phaseDocRepository.save(phaseDocument);
	}

	public void createIdeaStates() {

		List<IdeaState> ideaStates = ideaStateRepository.findAll();

		if (ideaStates == null || ideaStates.isEmpty()) {
			IdeaState ideaState1 = new IdeaState();
			ideaState1.setIdeaStatus("underReview");

			IdeaState ideaState2 = new IdeaState();
			ideaState2.setIdeaStatus("approved");

			IdeaState ideaState3 = new IdeaState();
			ideaState3.setIdeaStatus("onHold");

			IdeaState ideaState4 = new IdeaState();
			ideaState4.setIdeaStatus("rejected");

			ideaStateRepository.save(ideaState1);
			ideaStateRepository.save(ideaState2);
			ideaStateRepository.save(ideaState3);
			ideaStateRepository.save(ideaState4);
		}

	}

	public void createPhaseData() {

		List<Phase> phases = phaseRepository.findAll();

		if (phases == null || phases.isEmpty()) {
			Phase phase1 = new Phase();
			phase1.setPhaseName("Analysis");
			phaseRepository.save(phase1);

			Phase phase2 = new Phase();
			phase2.setPhaseName("Design");
			phaseRepository.save(phase2);
		}
	}

	public void createDocument() {

		Document doc1 = new Document();
		doc1.setDocName("Analysis doc");
		doc1.setDocUrl("sampleURL");
		doc1.setMimeType(".xlxs");
		doc1.setOrganization("ABCD");
		docsRepository.save(doc1);

	}

	public void createProcessFreq() {

		List<ProcessFrequency> frequecies = prcsFreqRepository.findAll();

		if (frequecies == null || frequecies.isEmpty()) {
			ProcessFrequency freq1 = new ProcessFrequency();
			freq1.setFreqDesc("Daily");
			prcsFreqRepository.save(freq1);

			ProcessFrequency freq2 = new ProcessFrequency();
			freq2.setFreqDesc("Weekly");
			prcsFreqRepository.save(freq2);

			ProcessFrequency freq3 = new ProcessFrequency();
			freq3.setFreqDesc("Bi-Weekly");
			prcsFreqRepository.save(freq3);
		}
	}

	public void createProcessPeeks() {
		List<ProcessPeaks> peaks = prcsPeekRepository.findAll();

		if (peaks == null || peaks.isEmpty()) {
			ProcessPeaks peek1 = new ProcessPeaks();
			peek1.setProcessPeekDetails("Regular (e.g. month closing)");
			prcsPeekRepository.save(peek1);

			ProcessPeaks peek2 = new ProcessPeaks();
			peek2.setProcessPeekDetails("Rare but predictable event (e.g. winter holidays/year closing)");
			prcsPeekRepository.save(peek2);

			ProcessPeaks peek3 = new ProcessPeaks();
			peek3.setProcessPeekDetails("Rare and unpredictable event");
			prcsPeekRepository.save(peek3);
		}
	}

	public void createWaysToComplete() {

		List<WaysToCompleteProcess> ways = waysToCompRepository.findAll();

		if (ways == null || ways.isEmpty()) {
			WaysToCompleteProcess way1 = new WaysToCompleteProcess();
			way1.setWaysToCompletePrcsDesc("Process is completed the same way every time");
			waysToCompRepository.save(way1);

			WaysToCompleteProcess way2 = new WaysToCompleteProcess();
			way2.setWaysToCompletePrcsDesc("There are >=2 but <5 ways to complete the process");
			waysToCompRepository.save(way2);

			WaysToCompleteProcess way3 = new WaysToCompleteProcess();
			way3.setWaysToCompletePrcsDesc("There are >=5 but <8 ways to complete the process");
			waysToCompRepository.save(way3);
		}
	}

	public void createStructuredDataInput() {

		List<StructDigitalDataInput> inputs = inputRepository.findAll();

		if (inputs == null || inputs.isEmpty()) {
			StructDigitalDataInput inp1 = new StructDigitalDataInput();
			inp1.setStructDataInputDesc(">=80%");
			inputRepository.save(inp1);

			StructDigitalDataInput inp2 = new StructDigitalDataInput();
			inp2.setStructDataInputDesc("60%-80%");
			inputRepository.save(inp2);

			StructDigitalDataInput inp3 = new StructDigitalDataInput();
			inp3.setStructDataInputDesc("40%-60%");
			inputRepository.save(inp3);
		}
	}

	public void createIdeas() {
		Idea idea1 = new Idea();
		idea1.setIdeaName("HR Strategy and Automation");

		AutomationArea area = masterTables.getAllAutomationAreas().get(1);
		AutomationCategory cat = masterTables.getAllAutomationCategories().get(0);
		AutomationSubCategory subCat = masterTables.getAllAutomationSubCategories().get(0);
		idea1.setAutomationArea(area);
		idea1.setAutomationCategory(cat);
		idea1.setAutomationSubCategory(subCat);

		Region region = new Region();
		region.setRegionName("Chennai");
		idea1.setRegion(region);

		idea1.setDescription("Lorem Ipsum");
		idea1.setPainPointComments("Lorem Ipsum");

		AutomationGoal goal = masterTables.getAllAutomationReasons().get(0);
		idea1.setAutomationGoals(goal);

		EnvironmentStability processStabilityChange = masterTables.getProcessStabilityChange().get(0);
		EnvironmentStability appStabilityChange = masterTables.getAppStabilityChange().get(0);
		idea1.setProcessStabilityChange(processStabilityChange);
		idea1.setApplicationStabilityChange(appStabilityChange);
		idea1.setAutomationProfileComments("Lorem Ipsum");
		idea1.setNumberOfDaysWorked(25);
		idea1.setWorkingHoursPerDay(6);
		idea1.setAverageEmpFullCostYearly(250);

		ProcessFrequency prcsFreq = masterTables.getProcessFreq().get(0);
		idea1.setProcessFrequency(prcsFreq);

		idea1.setActivityVolumAverageHrsPerYear(3);
		idea1.setAverageProcessingTimePerMin(3);
		idea1.setAverageErrorRatePercentVolume(4);
		idea1.setTotalReworkTimeHrsPerYear(4.0);

		idea1.setProcessVolumetryComments("Lorem Ipsum");

		ProcessPeaks peak = masterTables.getProcessPeaks().get(0);
		idea1.setProcessPeaks(peak);

		idea1.setAvgNumberOfSteps(50);

		WaysToCompleteProcess ways = masterTables.getWaysToComplete().get(0);

		idea1.setWaysToCompleteProcess(ways);
		idea1.setProcessWaysComments("Lorem Ipsum");
		idea1.setDigitalDataInPercentage(70);

		StructDigitalDataInput inp = masterTables.getStructuredDataInput().get(0);
		idea1.setStructuredDigitalDataInPercentage(inp);

		idea1.setDataAndAppComments("App and Comments");
		idea1.setIdeaState(masterTables.getAllIdeaState().get(0));
		// idea1.setSubmittedBy("AAAA");

		idea1.setApproverId(8l);

		idea1.setSubmittedDate(new Date());

		idea1.setApprovedDate(new Date());

		idea1.setApplicationList(masterTables.getIdeaApplications());

		List<PhaseDocument> phaseDocument = masterTables.getAllPhaseDocument();

		idea1.setPhaseDocument(phaseDocument);
		ideaRepository.save(idea1);

	}

	public void createEnvironmentStabilityTable() {

		List<EnvironmentStability> envs = envRepository.findAll();

		if (envs == null || envs.isEmpty()) {
			EnvironmentStability env1 = new EnvironmentStability();
			env1.setEnvStabilityDesc("No changes expected");
			envRepository.save(env1);

			EnvironmentStability env2 = new EnvironmentStability();
			env2.setEnvStabilityDesc("Minor change expected");
			envRepository.save(env2);

			EnvironmentStability env3 = new EnvironmentStability();
			env3.setEnvStabilityDesc("Some change expected");
			envRepository.save(env3);

			EnvironmentStability env4 = new EnvironmentStability();
			env4.setEnvStabilityDesc("Several changes expected");
			envRepository.save(env4);

			EnvironmentStability env5 = new EnvironmentStability();
			env5.setEnvStabilityDesc("Major changes expected");
			envRepository.save(env5);
		}

	}

	public void createIdeaApplication() {

		IdeaApplication ideaApplication1 = new IdeaApplication();
		IdeaApplication ideaApplication2 = new IdeaApplication();

		ideaApplication1.setApplicationName("App1");
		ideaApplication1.setVersionNo("v1.2");
		ideaApplication1.setLanguage("Java");
		ideaApplication1.setThinClient(true);
		ideaApplication1.setFeasibilityScore(80);
		ideaApplication1.setComments("SampleCOmment");
		ideaAppRepository.save(ideaApplication1);

		ideaApplication2.setApplicationName("App2");
		ideaApplication2.setVersionNo("1.3");
		ideaApplication2.setLanguage("Java2");
		ideaApplication2.setThinClient(false);
		ideaApplication2.setFeasibilityScore(80);
		ideaApplication2.setComments("SampleCOmment2");
		ideaAppRepository.save(ideaApplication2);

	}

	public void createAutomationReason() {

		List<AutomationGoal> goals = reasonRepository.findAll();

		if (goals == null || goals.isEmpty()) {
			AutomationGoal reason1 = new AutomationGoal();
			reason1.setAutomationGoalName("Cost");
			reasonRepository.save(reason1);

			AutomationGoal reason2 = new AutomationGoal();
			reason2.setAutomationGoalName("Quality");
			reasonRepository.save(reason2);

			AutomationGoal reason3 = new AutomationGoal();
			reason3.setAutomationGoalName("Productivity");
			reasonRepository.save(reason3);
		}
	}

	public void createAutomationCategory() {

		List<AutomationCategory> categories = catgryRepository.findAll();

		if (categories == null || categories.isEmpty()) {
			AutomationCategory cat1 = new AutomationCategory();
			cat1.setAutomationCatName("Accounts Receivable - Order to Bid");
			cat1.setAutomationAreaId(1l);
			catgryRepository.save(cat1);

			AutomationCategory cat2 = new AutomationCategory();
			cat2.setAutomationCatName("Accounts Receivable - Order to Contract");
			cat2.setAutomationAreaId(1l);
			catgryRepository.save(cat2);

			AutomationCategory cat3 = new AutomationCategory();
			cat3.setAutomationCatName("Accounts Receivable - Deliver to Invoice");
			cat3.setAutomationAreaId(1l);
			catgryRepository.save(cat3);

			AutomationCategory cat4 = new AutomationCategory();
			cat4.setAutomationCatName("Accounts Payable - Order to Reception");
			cat4.setAutomationAreaId(1l);
			catgryRepository.save(cat4);

			AutomationCategory cat5 = new AutomationCategory();
			cat5.setAutomationCatName("Record to Report -  Financial Planning & Analysis");
			cat5.setAutomationAreaId(1l);
			catgryRepository.save(cat5);

			AutomationCategory cat6 = new AutomationCategory();
			cat6.setAutomationCatName("Others");
			cat6.setAutomationAreaId(1l);
			catgryRepository.save(cat6);

			AutomationCategory cat7 = new AutomationCategory();
			cat7.setAutomationCatName("Create HR Strategy and Process");
			cat7.setAutomationAreaId(2l);
			catgryRepository.save(cat7);

			AutomationCategory cat8 = new AutomationCategory();
			cat8.setAutomationCatName("Recruit and Onboard Employees");
			cat8.setAutomationAreaId(2l);
			catgryRepository.save(cat8);

			AutomationCategory cat9 = new AutomationCategory();
			cat9.setAutomationCatName("Create IT Strategy");
			cat9.setAutomationAreaId(3l);
			catgryRepository.save(cat9);

			AutomationCategory cat10 = new AutomationCategory();
			cat10.setAutomationCatName("Deploy IT Solutions");
			cat10.setAutomationAreaId(3l);
			catgryRepository.save(cat10);

			AutomationCategory cat11 = new AutomationCategory();
			cat11.setAutomationCatName("Drafting and document management");
			cat11.setAutomationAreaId(4l);
			catgryRepository.save(cat11);

			AutomationCategory cat12 = new AutomationCategory();
			cat12.setAutomationCatName("Intellectual Property");
			cat12.setAutomationAreaId(4l);
			catgryRepository.save(cat12);

			AutomationCategory cat13 = new AutomationCategory();
			cat13.setAutomationCatName("Develop Marketing Strategy");
			cat13.setAutomationAreaId(5l);
			catgryRepository.save(cat13);

			AutomationCategory cat14 = new AutomationCategory();
			cat14.setAutomationCatName("Develop Sales Strategy");
			cat14.setAutomationAreaId(5l);
			catgryRepository.save(cat14);
		}

	}

	public void createAutomationAreaData() {
		List<AutomationArea> automationAreas = areaRepository.findAll();

		if (automationAreas == null || automationAreas.isEmpty()) {
			AutomationArea area = new AutomationArea();
			area.setAutomationAreaName("Finance & Accounting");
			areaRepository.save(area);
			AutomationArea area1 = new AutomationArea();
			area1.setAutomationAreaName("Human Resources");
			areaRepository.save(area1);
			AutomationArea area2 = new AutomationArea();
			area2.setAutomationAreaName("Information Technology");
			areaRepository.save(area2);
			AutomationArea area3 = new AutomationArea();
			area3.setAutomationAreaName("Legal");
			areaRepository.save(area3);
			AutomationArea area4 = new AutomationArea();
			area4.setAutomationAreaName("Sales and Marketing");
			areaRepository.save(area4);
			AutomationArea area5 = new AutomationArea();
			area5.setAutomationAreaName("Others");
			areaRepository.save(area5);
		}
	}

	public void createAutomationSubCategory() {
		AutomationSubCategory subCat1 = new AutomationSubCategory();
		AutomationSubCategory subCat2 = new AutomationSubCategory();
		AutomationSubCategory subCat3 = new AutomationSubCategory();
		AutomationSubCategory subCat4 = new AutomationSubCategory();
		AutomationSubCategory subCat5 = new AutomationSubCategory();
		AutomationSubCategory subCat6 = new AutomationSubCategory();
		AutomationSubCategory subCat7 = new AutomationSubCategory();
		AutomationSubCategory subCat8 = new AutomationSubCategory();
		AutomationSubCategory subCat9 = new AutomationSubCategory();
		AutomationSubCategory subCat10 = new AutomationSubCategory();
		AutomationSubCategory subCat11 = new AutomationSubCategory();
		AutomationSubCategory subCat12 = new AutomationSubCategory();
		AutomationSubCategory subCat13 = new AutomationSubCategory();
		AutomationSubCategory subCat14 = new AutomationSubCategory();
		AutomationSubCategory subCat15 = new AutomationSubCategory();
		AutomationSubCategory subCat16 = new AutomationSubCategory();
		AutomationSubCategory subCat17 = new AutomationSubCategory();
		AutomationSubCategory subCat18 = new AutomationSubCategory();
		AutomationSubCategory subCat19 = new AutomationSubCategory();
		AutomationSubCategory subCat20 = new AutomationSubCategory();
		AutomationSubCategory subCat21 = new AutomationSubCategory();
		AutomationSubCategory subCat22 = new AutomationSubCategory();
		AutomationSubCategory subCat23 = new AutomationSubCategory();
		AutomationSubCategory subCat24 = new AutomationSubCategory();
		AutomationSubCategory subCat25 = new AutomationSubCategory();
		AutomationSubCategory subCat26 = new AutomationSubCategory();

		subCat1.setAutomationSubCatName("Opportunity Identification");
		subCat2.setAutomationSubCatName("Customer Evaluation");
		subCat3.setAutomationSubCatName("Pricing Review");
		subCat4.setAutomationSubCatName("Terms and Conditions Review");
		subCat5.setAutomationSubCatName("Sales Order Processing");
		subCat6.setAutomationSubCatName("Initiate Contract Form");
		subCat7.setAutomationSubCatName("Good and Service Reception");
		subCat8.setAutomationSubCatName("System capitalization for fixed assets");
		subCat9.setAutomationSubCatName("Revenue Budget Preparation");
		subCat10.setAutomationSubCatName("Revenue Budget Review");
		subCat11.setAutomationSubCatName("Identify staffing needs");
		subCat12.setAutomationSubCatName("Develop hiring plans");
		subCat13.setAutomationSubCatName("Create and Post Job Description");
		subCat14.setAutomationSubCatName("Source Candidates");
		subCat15.setAutomationSubCatName("Develop enterprise IT strategy");
		subCat16.setAutomationSubCatName("Manage IT Portfolio");
		subCat17.setAutomationSubCatName("Plan and implement changes");
		subCat18.setAutomationSubCatName("Plan and manage releases");
		subCat19.setAutomationSubCatName("Contract Creation");
		subCat20.setAutomationSubCatName("Contract Negotiation");
		subCat21.setAutomationSubCatName("Legal Holds ");
		subCat22.setAutomationSubCatName("Processing Data");
		subCat23.setAutomationSubCatName("Define Pricing Strategy");
		subCat24.setAutomationSubCatName("Define and manage channel strategy");
		subCat25.setAutomationSubCatName("Develop Sales forecast");
		subCat26.setAutomationSubCatName("Establish sales goals and measures");

		subCat1.setAutomationCatId(1l);
		subCat2.setAutomationCatId(1l);
		subCat3.setAutomationCatId(2l);
		subCat4.setAutomationCatId(2l);
		subCat5.setAutomationCatId(3l);
		subCat6.setAutomationCatId(3l);
		subCat7.setAutomationCatId(4l);
		subCat8.setAutomationCatId(4l);
		subCat9.setAutomationCatId(5l);
		subCat10.setAutomationCatId(5l);
		subCat11.setAutomationCatId(7l);
		subCat12.setAutomationCatId(7l);
		subCat13.setAutomationCatId(8l);
		subCat14.setAutomationCatId(8l);
		subCat15.setAutomationCatId(9l);
		subCat16.setAutomationCatId(9l);
		subCat17.setAutomationCatId(10l);
		subCat18.setAutomationCatId(10l);
		subCat19.setAutomationCatId(11l);
		subCat20.setAutomationCatId(11l);
		subCat21.setAutomationCatId(12l);
		subCat22.setAutomationCatId(12l);
		subCat23.setAutomationCatId(13l);
		subCat24.setAutomationCatId(13l);
		subCat25.setAutomationCatId(14l);
		subCat26.setAutomationCatId(14l);

		List<AutomationSubCategory> list = new ArrayList<AutomationSubCategory>();
		list.add(subCat1);
		list.add(subCat2);
		list.add(subCat3);
		list.add(subCat4);
		list.add(subCat5);
		list.add(subCat6);
		list.add(subCat7);
		list.add(subCat8);
		list.add(subCat9);
		list.add(subCat10);
		list.add(subCat11);
		list.add(subCat12);
		list.add(subCat13);
		list.add(subCat14);
		list.add(subCat15);
		list.add(subCat16);
		list.add(subCat17);
		list.add(subCat18);
		list.add(subCat19);
		list.add(subCat20);
		list.add(subCat21);
		list.add(subCat22);
		list.add(subCat23);
		list.add(subCat24);
		list.add(subCat25);
		list.add(subCat26);

		List<AutomationSubCategory> subCategories = subCatgryRepository.findAll();

		if (subCategories == null || subCategories.isEmpty())
			subCatgryRepository.saveAll(list);

	}

	@Override
	public void createAssessmentTollGateCheckList() {

		List<AssessmentTollGateChecklist> list = new ArrayList<AssessmentTollGateChecklist>();
		AssessmentTollGateChecklist tg1 = new AssessmentTollGateChecklist();
		tg1.setChecklistItemId(1L);
		tg1.setChecklistItemLabel("Checklist Item 1");

		AssessmentTollGateChecklist tg2 = new AssessmentTollGateChecklist();
		tg2.setChecklistItemId(2L);
		tg2.setChecklistItemLabel("Checklist Item 2");

		AssessmentTollGateChecklist tg3 = new AssessmentTollGateChecklist();
		tg3.setChecklistItemId(3L);
		tg3.setChecklistItemLabel("Checklist Item 3");

		AssessmentTollGateChecklist tg4 = new AssessmentTollGateChecklist();
		tg4.setChecklistItemId(4L);
		tg4.setChecklistItemLabel("Checklist Item 4");

		list.add(tg1);
		list.add(tg2);
		list.add(tg3);
		list.add(tg4);

		assessmentTollGateChecklistRepository.saveAll(list);
	}

	@Override
	public void createDeploymentTollGateCheckList() {
		List<DeploymentTollGateChecklist> list = new ArrayList<>();
		DeploymentTollGateChecklist tg1 = new DeploymentTollGateChecklist();
		tg1.setChecklistItemId(1L);
		tg1.setChecklistItemLabel("Checklist Item 1");

		DeploymentTollGateChecklist tg2 = new DeploymentTollGateChecklist();
		tg2.setChecklistItemId(2L);
		tg2.setChecklistItemLabel("Checklist Item 2");

		DeploymentTollGateChecklist tg3 = new DeploymentTollGateChecklist();
		tg3.setChecklistItemId(3L);
		tg3.setChecklistItemLabel("Checklist Item 3");

		DeploymentTollGateChecklist tg4 = new DeploymentTollGateChecklist();
		tg4.setChecklistItemId(4L);
		tg4.setChecklistItemLabel("Checklist Item 4");

		list.add(tg1);
		list.add(tg2);
		list.add(tg3);
		list.add(tg4);

		deploymentTollGateChecklistRepository.saveAll(list);

	}

	@Override
	public void createNumOfFieldsToInputPrcs() {

		List<NoOfInputFields> noOfInputFields = noOfInputFieldsRepository.findAll();

		if (noOfInputFields == null || noOfInputFields.isEmpty()) {
			NoOfInputFields noOfInputFields1 = new NoOfInputFields();
			noOfInputFields1.setNoOfInputFieldsDesc("Less than 30");
			noOfInputFieldsRepository.save(noOfInputFields1);

			NoOfInputFields noOfInputFields2 = new NoOfInputFields();
			noOfInputFields2.setNoOfInputFieldsDesc("Between 31 to 60");
			noOfInputFieldsRepository.save(noOfInputFields2);

			NoOfInputFields noOfInputFields3 = new NoOfInputFields();
			noOfInputFields3.setNoOfInputFieldsDesc("Greater than 60");
			noOfInputFieldsRepository.save(noOfInputFields3);
		}

	}

	@Override
	public void createExHandlingPercent() {

		List<ExHandlingPercent> exHandlingPercents = exHandlingPercentRepository.findAll();

		if (exHandlingPercents == null || exHandlingPercents.isEmpty()) {
			ExHandlingPercent exHandlingPercent1 = new ExHandlingPercent();
			exHandlingPercent1.setExHandlingPercentDesc("Less than 2%");
			exHandlingPercentRepository.save(exHandlingPercent1);

			ExHandlingPercent exHandlingPercent2 = new ExHandlingPercent();
			exHandlingPercent2.setExHandlingPercentDesc("Between 3% to 10%");
			exHandlingPercentRepository.save(exHandlingPercent2);

			ExHandlingPercent exHandlingPercent3 = new ExHandlingPercent();
			exHandlingPercent3.setExHandlingPercentDesc("Greater than 10%");
			exHandlingPercentRepository.save(exHandlingPercent3);
		}
	}

	@Override
	public void createNumofApplications() {

		List<NumOfApplication> numOfApplications = noOfApplicationRepository.findAll();

		if (numOfApplications == null || numOfApplications.isEmpty()) {
			NumOfApplication numOfApplication1 = new NumOfApplication();
			numOfApplication1.setNumOfApplicationDesc("Less Than 3");
			noOfApplicationRepository.save(numOfApplication1);

			NumOfApplication numOfApplication2 = new NumOfApplication();
			numOfApplication2.setNumOfApplicationDesc("Between 4 to 5");
			noOfApplicationRepository.save(numOfApplication2);

			NumOfApplication numOfApplication3 = new NumOfApplication();
			numOfApplication3.setNumOfApplicationDesc("Greater than 6");
			noOfApplicationRepository.save(numOfApplication3);
		}
	}

	@Override
	public void createStabilityOfApps() {
		List<StabilityOfApp> stabilityOfApps = stabilityOfAppRepository.findAll();

		if (stabilityOfApps == null || stabilityOfApps.isEmpty()) {
			StabilityOfApp stabilityOfApp1 = new StabilityOfApp();
			stabilityOfApp1.setStabilityOfAppDesc("Less than 50% Uptime");
			stabilityOfAppRepository.save(stabilityOfApp1);

			StabilityOfApp stabilityOfApp2 = new StabilityOfApp();
			stabilityOfApp2.setStabilityOfAppDesc("Less than 75% Uptime");
			stabilityOfAppRepository.save(stabilityOfApp2);

			StabilityOfApp stabilityOfApp3 = new StabilityOfApp();
			stabilityOfApp3.setStabilityOfAppDesc("Greater than 90% Uptime");
			stabilityOfAppRepository.save(stabilityOfApp3);
		}
	}

	@Override
	public void createRegions() {

		List<Region> regions = regionRepository.findAll();

		if (regions == null || regions.isEmpty()) {
			Region region1 = new Region();
			region1.setRegionName("Bangalore");
			regionRepository.save(region1);

			Region region2 = new Region();
			region2.setRegionName("Chennai");
			regionRepository.save(region2);

			Region region3 = new Region();
			region3.setRegionName("Trivandram");
			regionRepository.save(region3);

			Region region4 = new Region();
			region4.setRegionName("Mumbai");
			regionRepository.save(region4);

			Region region5 = new Region();
			region5.setRegionName("Hyderabad");
			regionRepository.save(region5);

			Region region6 = new Region();
			region6.setRegionName("Singapore");
			regionRepository.save(region6);

			Region region7 = new Region();
			region7.setRegionName("China");
			regionRepository.save(region7);

		}
	}

}
