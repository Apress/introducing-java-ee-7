-- CREATE AN EMPTY SCHEMA AND GRANT THE FOLLOWING PERMISSIONS
-- CREATE TABLE, CREATE SEQUENCE, CREATE VIEW, CREATE PROCEDURE, CREATE FUNCTION

-- RUN THIS SCRIPT IN THE SCHEMA THAT YOU CREATED

create table employee(
id			number primary key,
first		varchar2(30),
last		varchar2(30),
age			number,
job_id		number,
status		varchar2(50));

create sequence employee_pk_s
start with 1
increment by 1;


create table jobs(
job_id		number primary key,
title		varchar2(50),
division	varchar2(50),
salary		number);

create sequence jobs_pk_s
start with 1
increment by 1;

-- Populate tables with data

insert into jobs values(
jobs_pk_s.nextval,
'IT TITLE A',
'IT',
60000);

insert into jobs values(
jobs_pk_s.nextval,
'IT TITLE B',
'IT',
70000);

insert into jobs values(
jobs_pk_s.nextval,
'IT TITLE C',
'IT',
40000);

insert into jobs values(
jobs_pk_s.nextval,
'HR TITLE A',
'HR',
50000);

insert into jobs values(
jobs_pk_s.nextval,
'HR TITLE B',
'HR',
60000);

insert into jobs values(
jobs_pk_s.nextval,
'TITLE A',
'SALES',
65000);

insert into employee values(
employee_pk_s.nextval,
'JOE',
'DEVELOPER',
25,
(select job_id from jobs where title = 'IT TITLE C'));

insert into employee values(
employee_pk_s.nextval,
'JANE',
'DEVELOPER',
32,
(select job_id from jobs where title = 'IT TITLE A'));

insert into employee values(
employee_pk_s.nextval,
'BOB',
'SMITH',
25,
(select job_id from jobs where title = 'HR TITLE A'));
  return_val	varchar2(100);
  
  CREATE TABLE FACTORY (
ID		NUMBER PRIMARY KEY,
NAME	VARCHAR2(150));

CREATE TABLE PRODUCT (
ID		NUMBER PRIMARY KEY,
NAME	VARCHAR2(150),
PRODUCT_TYPE VARCHAR2(50),
DESCRIPTION VARCHAR2(2000),
COLOR		VARCHAR2(100),
FACTORY_ID NUMBER);

insert into factory values(
1,
'FACTORY ONE');

insert into product values(
1,
'ACME WIDGET BLUE',
'A',
'BLUE WIDGET',
'BLUE',
1);

insert into product values(
2,
'ACME WIDGET RED',
'A',
'RED WIDGET',
'RED',
1);

create table USERS (
ID		number PRIMARY KEY,
USER_ID     VARCHAR2(15),
USERNAME	VARCHAR2(50),
PASSWORD	VARCHAR2(30),
FIRSTNAME	VARCHAR2(50),
LASTNAME	VARCHAR2(50),
EMAIL		VARCHAR2(50));

create sequence users_s
start with 1
increment by 1;


create or replace procedure create_emp(firstname varchar2,
									lastname varchar2,
									status varchar2) as
begin
   insert into employee values(
    employee_pk_s.nextval,
    upper(firstname),
    upper(lastname),
	null,
	null,
	upper(status));
end;
/
