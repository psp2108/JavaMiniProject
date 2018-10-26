#-------------------------------------------
#DATABASE :: railwayconcession 
#--------------------------------------------

#    CREATION OF STUDENT PROFILE TABLE
	
create table Student_Profile(
sap_id varchar(12) NOT NULL,
student_name varchar(255) NOT NULL,
password varchar(255) NOT NULL,
email varchar(255) NOT NULL,
hometown varchar(255) NOT NULL,
department varchar(255) NOT NULL,
PRIMARY KEY(sap_id)
);

#-----------------------------------------------
#	CREATION OF railwayconcession table

create table rail_concess(
sap_id varchar(12) NOT NULL,
rc_id int NOT NULL AUTO_INCREMENT,
request_date date,
class_type int,
approved_from date,
approved_till date,
status int DEFAULT 0,
PRIMARY KEY(rc_id),
FOREIGN KEY (sap_id) REFERENCES student_profile(sap_id)
);