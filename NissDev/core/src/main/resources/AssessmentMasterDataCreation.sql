--Inserting Automation Area:

insert into automation_area (automation_area_name) values ('Finance & Accounting');
insert into automation_area (automation_area_name) values ('Human Resources');
insert into automation_area (automation_area_name) values ('Information Technology');
insert into automation_area (automation_area_name) values ('Legal');
insert into automation_area (automation_area_name) values ('Sales and Marketing');
insert into automation_area (automation_area_name) values ('Others');

--Inserting Automation Category:

insert into automation_category (automation_area_id,automation_cat_name) values (1,'Accounts Receivable - Order to Bid');
insert into automation_category (automation_area_id,automation_cat_name) values (1,'Accounts Receivable - Order to Contract');
insert into automation_category (automation_area_id,automation_cat_name) values (1,'Accounts Receivable - Deliver to Invoice');
insert into automation_category (automation_area_id,automation_cat_name) values (1,'Accounts Payable - Order to Reception');
insert into automation_category (automation_area_id,automation_cat_name) values (1,'Record to Report -  Financial Planning & Analysis');
insert into automation_category (automation_area_id,automation_cat_name) values (1,'Others');
insert into automation_category (automation_area_id,automation_cat_name) values (2,'Create HR Strategy and Process');
insert into automation_category (automation_area_id,automation_cat_name) values (2,'Recruit and Onboard Employees');
insert into automation_category (automation_area_id,automation_cat_name) values (3,'Create IT Strategy');
insert into automation_category (automation_area_id,automation_cat_name) values (3,'Deploy IT Solutions');
insert into automation_category (automation_area_id,automation_cat_name) values (4,'Drafting and document management');
insert into automation_category (automation_area_id,automation_cat_name) values (4,'Intellectual Property');
insert into automation_category (automation_area_id,automation_cat_name) values (5,'Develop Marketing Strategy');
insert into automation_category (automation_area_id,automation_cat_name) values (5,'Develop Sales Strategy');

--Inserting Automation Sub Category:
insert into automation_sub_category (automation_cat_id, automation_sub_cat_name) values (1,'Opportunity Identification');
insert into automation_sub_category (automation_cat_id, automation_sub_cat_name) values (1,'Customer Evaluation');
insert into automation_sub_category (automation_cat_id, automation_sub_cat_name) values (2,'Pricing Review');
insert into automation_sub_category (automation_cat_id, automation_sub_cat_name) values (2,'Terms and Conditions Review');
insert into automation_sub_category (automation_cat_id, automation_sub_cat_name) values (3,'Sales Order Processing');
insert into automation_sub_category (automation_cat_id, automation_sub_cat_name) values (3,'Initiate Contract Form');
insert into automation_sub_category (automation_cat_id, automation_sub_cat_name) values (4,'Good and Service Reception');
insert into automation_sub_category (automation_cat_id, automation_sub_cat_name) values (4,'System capitalization for fixed assets');
insert into automation_sub_category (automation_cat_id, automation_sub_cat_name) values (5,'Revenue Budget Preparation');
insert into automation_sub_category (automation_cat_id, automation_sub_cat_name) values (5,'Revenue Budget Review');
insert into automation_sub_category (automation_cat_id, automation_sub_cat_name) values (7,'Identify staffing needs');
insert into automation_sub_category (automation_cat_id, automation_sub_cat_name) values (7,'Develop hiring plans');
insert into automation_sub_category (automation_cat_id, automation_sub_cat_name) values (8,'Create and Post Job Description');
insert into automation_sub_category (automation_cat_id, automation_sub_cat_name) values (8,'Source Candidates');
insert into automation_sub_category (automation_cat_id, automation_sub_cat_name) values (9,'Develop enterprise IT strategy');
insert into automation_sub_category (automation_cat_id, automation_sub_cat_name) values (9,'Manage IT Portfolio');
insert into automation_sub_category (automation_cat_id, automation_sub_cat_name) values (10,'Plan and implement changes');
insert into automation_sub_category (automation_cat_id, automation_sub_cat_name) values (10,'Plan and manage releases');
insert into automation_sub_category (automation_cat_id, automation_sub_cat_name) values (11,'Contract Creation');
insert into automation_sub_category (automation_cat_id, automation_sub_cat_name) values (11,'Contract Negotiation');
insert into automation_sub_category (automation_cat_id, automation_sub_cat_name) values (12,'Legal Holds ');
insert into automation_sub_category (automation_cat_id, automation_sub_cat_name) values (12,'Processing Data');
insert into automation_sub_category (automation_cat_id, automation_sub_cat_name) values (13,'Define Pricing Strategy');
insert into automation_sub_category (automation_cat_id, automation_sub_cat_name) values (13,'Define and manage channel strategy');
insert into automation_sub_category (automation_cat_id, automation_sub_cat_name) values (14,'Develop Sales forecast');
insert into automation_sub_category (automation_cat_id, automation_sub_cat_name) values (14,'Establish sales goals and measures');


--Inserting Environment Stability

insert into environment_stability (env_stability_desc) values ('No changes expected');
insert into environment_stability (env_stability_desc) values ('Minor change expected');
insert into environment_stability (env_stability_desc) values ('Some change expected');
insert into environment_stability (env_stability_desc) values ('Several changes expected');
insert into environment_stability (env_stability_desc) values ('Major changes expected');


-- Inserting Idea states

insert into idea_state (idea_status) values ('underReview');
insert into idea_state (idea_status) values ('approved');
insert into idea_state (idea_status) values ('onHold');
insert into idea_state (idea_status) values ('rejected');


-- Inserting phases
insert into phase (phase_name) values ('Analysis');
insert into phase (phase_name) values ('Design');


-- Inserting Automation goals
insert into automation_goal (automation_goal_name) values ('Cost');
insert into automation_goal (automation_goal_name) values ('Quality');
insert into automation_goal (automation_goal_name) values ('Productivity');

-- Inserting Process frequency
insert into process_frequency (freq_desc) values ('Daily');
insert into process_frequency (freq_desc) values ('Weekly');
insert into process_frequency (freq_desc) values ('Monthly');


-- Inserting Process peaks
insert into process_peaks (process_peek_details) values ('Regular (e.g. month closing)');
insert into process_peaks (process_peek_details) values ('Rare but predictable event (e.g. winter holidays/year closing)');
insert into process_peaks (process_peek_details) values ('Rare and unpredictable event');


-- Inserting Ways to complete process
insert into ways_to_complete_process (ways_to_complete_prcs_desc) values ('Process is completed the same way every time');
insert into ways_to_complete_process (ways_to_complete_prcs_desc) values ('There are >=2 but <5 ways to complete the process');
insert into ways_to_complete_process (ways_to_complete_prcs_desc) values ('There are >=5 but <8 ways to complete the process');

-- Inserting Structured Digital data input
insert into struct_digital_data_input (struct_data_input_desc) values ('>=80%');
insert into struct_digital_data_input (struct_data_input_desc) values ('60%-80%');
insert into struct_digital_data_input (struct_data_input_desc) values ('40%-60%');

-- Inserting Documents
insert into document (doc_name,doc_url,mime_type,organization) values ('Analysis doc','sampleURL','.xlxs','ABCD');

-- Inserting Phase Document
insert into phase_document (doc_id,phase_id)  values (1,1);

-- Inserting Number of fields to input
insert into no_of_input_fields (no_of_input_fields_desc) values ('Less than 30');
insert into no_of_input_fields (no_of_input_fields_desc) values ('Between 31 to 60');
insert into no_of_input_fields (no_of_input_fields_desc) values ('Greater than 60');

-- Inserting Exception handling percentage
insert into ex_handling_percent (ex_handling_percent_desc) values ('Less than 2%');
insert into ex_handling_percent (ex_handling_percent_desc) values ('Between 3% to 10%');
insert into ex_handling_percent (ex_handling_percent_desc) values ('Greater than 10%');

-- Inserting Number of application
insert into num_of_application (num_of_application_desc) values ('Less Than 3');
insert into num_of_application (num_of_application_desc) values ('Between 4 to 5');
insert into num_of_application (num_of_application_desc) values ('Greater than 6');

-- Inserting Stability of application
insert into stability_of_app (stability_of_app_desc) values ('Less than 50% Uptime');
insert into stability_of_app (stability_of_app_desc) values ('Less than 75% Uptime');
insert into stability_of_app (stability_of_app_desc) values ('Greater than 90% Uptime');


-- Inserting Region
insert into region (region_name) values ('Bangalore');
insert into region (region_name) values ('Chennai');
insert into region (region_name) values ('Trivandram');
insert into region (region_name) values ('Mumbai');
insert into region (region_name) values ('Hyderabad');
insert into region (region_name) values ('Singapore');
insert into region (region_name) values ('Japan');
insert into region (region_name) values ('China');