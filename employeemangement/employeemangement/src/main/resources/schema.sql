DROP TABLE IF EXISTS departments;

create table departments
(
 department_id int,
 location_id int,
 status bit,
 date_added datetime,
 primary key(department_id)
);

DROP TABLE IF EXISTS languages;

create table languages
(
language_id int,
name varchar(32),
code varchar(5),
primary key(language_id)
);

DROP TABLE IF EXISTS department_languages;

 create table department_languages
 (
  department_id int,
  language_id int,
  description varchar(255),
  name varchar(255),
  primary key(department_id,language_id),
  foreign key (department_id) references departments(department_id),
  foreign key (language_id) references languages(language_id)
 );

 DROP TABLE IF EXISTS employees;

create table employees
(
 employee_id int,
 department_id int,
 firstname varchar(45),
 lastname varchar(45),
 primary key(employee_id),
 foreign key(department_id) references departments(department_id)
);

