--Inserting Job Title:
insert into job_title (job_title_name) values ('Functional manager');
insert into job_title (job_title_name) values ('Process owner');

--Inserting Business Unit:
insert into business_unit (business_unit_name) values ('RPA CoE');
insert into business_unit (business_unit_name) values ('RPA Delivery');

--Inserting Department:
insert into department (dept_name) values ('Delivery');
insert into department (dept_name) values ('Operations');
insert into department (dept_name) values ('Finance');
insert into department (dept_name) values ('Retail');

--Inserting Permission:
INSERT INTO permission(permission_name, permission_url) VALUES ('Get All Ideas', '/ideas');
INSERT INTO permission(permission_name, permission_url) VALUES ('Filter  the ideas', '/ideas/filter');
INSERT INTO permission(permission_name, permission_url) VALUES ('Get Ideas count', '/ideas/count');
INSERT INTO permission(permission_name, permission_url) VALUES ('Get Idea status', '/ideas/status');
INSERT INTO permission(permission_name, permission_url) VALUES ('Submit Idea', '/ideas/submit');
INSERT INTO permission(permission_name, permission_url) VALUES ('Save Idea', '/ideas/save');
INSERT INTO permission(permission_name, permission_url) VALUES ('Get Latest saved idea', '/ideas/latestSavedIdea');
INSERT INTO permission(permission_name, permission_url) VALUES ('Update Idea Status', '/ideas/updateIdeaStatus');


INSERT INTO permission(permission_name, permission_url) VALUES ('Create New User', '/users/addNewUser');
INSERT INTO permission(permission_name, permission_url) VALUES ('Get List of Users', '/users/getUserList');
INSERT INTO permission(permission_name, permission_url) VALUES ('Update Users', '/users/editUser');
INSERT INTO permission(permission_name, permission_url) VALUES ('Create role', '/users/addNewRole');
INSERT INTO permission(permission_name, permission_url) VALUES ('Activate User', '/users/activateUser');
INSERT INTO permission(permission_name, permission_url) VALUES ('Deactivate User', '/users/deactivateUser');
