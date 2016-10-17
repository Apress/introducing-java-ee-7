-- Configure and register derbydb for your Glassfish and Netbeans
-- installations using these guidelines: http://netbeans.org/kb/docs/ide/java-db.html

-- Create Derby database named acme
-- CREATE new user named acmeuser
-- Connect to acmeuser and execute the following script


create table employee(
id			NUMERIC primary key,
firstname		varchar(30),
lastname		varchar(30),
age			NUMERIC,
job_id		NUMERIC,
status		varchar(50));

create sequence employee_pk_s
start with 1
increment by 1;


create table jobs(
job_id		NUMERIC primary key,
title		varchar2(50),
division	varchar2(50),
salary		NUMERIC);

create sequence jobs_pk_s
start with 1
increment by 1;

-- Populate tables with data

insert into jobs values(
next value for jobs_pk_s,
'IT TITLE A',
'IT',
60000);

insert into jobs values(
next value for jobs_pk_s,
'IT TITLE B',
'IT',
70000);

insert into jobs values(
next value for jobs_pk_s,
'IT TITLE C',
'IT',
40000);

insert into jobs values(
next value for jobs_pk_s,
'HR TITLE A',
'HR',
50000);

insert into jobs values(
next value for jobs_pk_s,
'HR TITLE B',
'HR',
60000);

insert into jobs values(
next value for jobs_pk_s,
'TITLE A',
'SALES',
65000);

insert into employee values(
next value for employee_pk_s,
'JOE',
'DEVELOPER',
25,
(select job_id from jobs where title = 'IT TITLE C'));

insert into employee values(
next value for employee_pk_s,
'JANE',
'DEVELOPER',
32,
(select job_id from jobs where title = 'IT TITLE A'),
'INACTIVE');

insert into employee values(
next value for employee_pk_s,
'BOB',
'SMITH',
25,
(select job_id from jobs where title = 'HR TITLE A'),
'ACTIVE');

CREATE PROCEDURE CREATE_EMP(
    IN firstName varchar(32),
    IN lastName varchar(32),
    IN status varchar(32))
    PARAMETER STYLE JAVA
    LANGUAGE JAVA
    DYNAMIC RESULT SETS 0
    EXTERNAL NAME 'org.javaee7.chapter04.db.StoredProcedures.createEmp';

CREATE TABLE FACTORY (
ID		NUMERIC PRIMARY KEY,
NAME	VARCHAR(150));

CREATE TABLE PRODUCT (
ID		NUMERIC PRIMARY KEY,
NAME	VARCHAR(150),
PRODUCT_TYPE VARCHAR(50),
DESCRIPTION VARCHAR(2000),
COLOR		VARCHAR(100),
FACTORY_ID NUMERIC);

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
ID		NUMERIC PRIMARY KEY,
USER_ID     VARCHAR(15),
USERNAME	VARCHAR(50),
PASSWORD	VARCHAR(30),
FIRSTNAME	VARCHAR(50),
LASTNAME	VARCHAR(50),
EMAIL		VARCHAR(50));

create sequence users_s
start with 1
increment by 1;
