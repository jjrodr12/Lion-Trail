--2017
insert into semester(id,admission_start,admission_stop,
class_registration_date,drop_add_deadline_date,first_class_date,
first_exam_date,last_class_date,last_exam_date,
season,year)
values (nextval('semester_id_seq'),'2017-01-01','2017-06-28',
'2017-07-20','2017-09-08','2017-08-21',
'2017-12-11','2017-12-08','2017-12-15',
'FALL',2017);

insert into semester(id,admission_start,admission_stop,
class_registration_date,drop_add_deadline_date,first_class_date,
first_exam_date,last_class_date,last_exam_date,
season,year)
values (nextval('semester_id_seq'),'2017-06-01','2017-11-28',
'2018-01-05','2018-02-21','2018-01-21',
'2018-06-11','2018-06-08','2018-06-15',
'SPRING',2018);

insert into semester(id,admission_start,admission_stop,
class_registration_date,drop_add_deadline_date,first_class_date,
first_exam_date,last_class_date,last_exam_date,
season,year)
values (nextval('semester_id_seq'),'2018-01-21','2018-03-31',
'2018-04-05','2018-07-10','2018-05-26',
'2018-07-25','2018-07-21','2018-07-31',
'SUMMER',2018);

--2018
insert into semester(id,admission_start,admission_stop,
class_registration_date,drop_add_deadline_date,first_class_date,
first_exam_date,last_class_date,last_exam_date,
season,year)
values (nextval('semester_id_seq'),'2018-01-01','2018-06-28',
'2018-07-20','2018-09-08','2018-08-21',
'2018-12-11','2018-12-08','2018-12-15',
'FALL',2018);

insert into semester(id,admission_start,admission_stop,
class_registration_date,drop_add_deadline_date,first_class_date,
first_exam_date,last_class_date,last_exam_date,
season,year)
values (nextval('semester_id_seq'),'2018-06-01','2018-11-28',
'2019-01-05','2019-02-21','2019-01-21',
'2019-06-11','2019-06-08','2019-06-15',
'SPRING',2019);

insert into semester(id,admission_start,admission_stop,
class_registration_date,drop_add_deadline_date,first_class_date,
first_exam_date,last_class_date,last_exam_date,
season,year)
values (nextval('semester_id_seq'),'2019-01-21','2019-03-31',
'2019-04-05','2019-07-10','2019-05-26',
'2019-07-25','2019-07-21','2019-07-31',
'SUMMER',2019);

--2019
insert into semester(id,admission_start,admission_stop,
class_registration_date,drop_add_deadline_date,first_class_date,
first_exam_date,last_class_date,last_exam_date,
season,year)
values (nextval('semester_id_seq'),'2019-01-01','2019-06-28',
'2019-07-20','2019-09-08','2019-08-21',
'2019-12-11','2019-12-08','2019-12-15',
'FALL',2019);

insert into semester(id,admission_start,admission_stop,
class_registration_date,drop_add_deadline_date,first_class_date,
first_exam_date,last_class_date,last_exam_date,
season,year)
values (nextval('semester_id_seq'),'2019-06-01','2019-11-28',
'2020-01-05','2020-02-21','2020-01-21',
'2020-06-11','2020-06-08','2020-06-15',
'SPRING',2020);

insert into semester(id,admission_start,admission_stop,
class_registration_date,drop_add_deadline_date,first_class_date,
first_exam_date,last_class_date,last_exam_date,
season,year)
values (nextval('semester_id_seq'),'2020-01-21','2020-03-31',
'2020-04-05','20200-07-10','2020-05-26',
'2020-07-25','2020-07-21','2020-07-31',
'SUMMER',2020);


insert into auth_user(username, password) values('admin','jGl25bVBBBW96Qi9Te4V37Fnqchz/Eu4qB9vKrRIqRg=');
insert into auth_user_role(username, role) values('admin','admin');

insert into auth_user(username, password) values('abc1','jGl25bVBBBW96Qi9Te4V37Fnqchz/Eu4qB9vKrRIqRg=');
insert into auth_user_role(username, role) values('abc1','admin');

insert into auth_user(username, password) values('rts1','XohImNooBHFR0OVvjcYpJ3NgPQ1qq73WKhHvch0VQtg=');
insert into auth_user_role(username, role) values('rts1','student');


insert into department(id, name) values('ENGINEERING','College of Engineering');
insert into department(id, name) values('ARTS','College of Arts');
insert into department(id, name) values('BUSINESS','Smeal College of Business');
insert into department(id, name) values('MEDICINE','Hershey College of Medicine');
insert into department(id, name) values('LAW','Dickson Law School');
insert into department(id, name) values('MATH','College of Math');

--ENGINEERING
insert into major(id, abbreviation, degree_level, name, department_id)
    values(nextval('major_id_seq'), 'SWENG', 'BS', 'Software Engineering', 'ENGINEERING');
insert into major(id, abbreviation, degree_level, name, department_id)
    values(nextval('major_id_seq'), 'SWENG', 'MS', 'Software Engineering', 'ENGINEERING');
insert into major(id, abbreviation, degree_level, name, department_id)
    values(nextval('major_id_seq'), 'CMPSCI', 'BS', 'Computer Science', 'ENGINEERING');
insert into major(id, abbreviation, degree_level, name, department_id)
    values(nextval('major_id_seq'), 'EE', 'BS', 'Electrical Engineering', 'ENGINEERING');

--ARTS
insert into major(id, abbreviation, degree_level, name, department_id)
    values(nextval('major_id_seq'), 'PAINT', 'BS', 'Painting', 'ARTS');
insert into major(id, abbreviation, degree_level, name, department_id)
    values(nextval('major_id_seq'), 'PHOTO', 'BS', 'Photography', 'ARTS');
insert into major(id, abbreviation, degree_level, name, department_id)
    values(nextval('major_id_seq'), 'POTT', 'BS', 'Pottery', 'ARTS');

--BUSINESS
insert into major(id, abbreviation, degree_level, name, department_id)
    values(nextval('major_id_seq'), 'BUS', 'BS', 'Business', 'BUSINESS');
insert into major(id, abbreviation, degree_level, name, department_id)
    values(nextval('major_id_seq'), 'FIN', 'BS', 'Finance', 'BUSINESS');
insert into major(id, abbreviation, degree_level, name, department_id)
    values(nextval('major_id_seq'), 'MKT', 'BS', 'Marketing', 'BUSINESS');

--MEDICINE
insert into major(id, abbreviation, degree_level, name, department_id)
    values(nextval('major_id_seq'), 'MED', 'MD', 'Medicine', 'MEDICINE');

--LAW
insert into major(id, abbreviation, degree_level, name, department_id)
    values(nextval('major_id_seq'), 'LAW', 'JD', 'Law', 'LAW');

--MATH
insert into major(id, abbreviation, degree_level, name, department_id)
    values(nextval('major_id_seq'), 'MAT', 'BS', 'Math', 'MATH');
insert into major(id, abbreviation, degree_level, name, department_id)
    values(nextval('major_id_seq'), 'APM', 'BS', 'Applied Math', 'MATH');
insert into major(id, abbreviation, degree_level, name, department_id)
    values(nextval('major_id_seq'), 'MAT', 'MS', 'Math', 'MATH');

--SWENG-U
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 1, 101, 3, 'Intro to Software Engineering',
	'This course provides an overview of the discipline of Software Engineering');
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 1, 110, 3, 'Basic Programming',
	'This course provides an introduction to fundamentals of programming');
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 1, 210, 3, 'Object Oriented Programming',
	'This course provides an introduction to Object Oriented Programming');

insert into course_prerequisites(parent_course, required_course) values(2, 1);
insert into course_prerequisites(parent_course, required_course) values(3, 2);

insert into major_course(major_id,course_id) values (1,1);
insert into major_course(major_id,course_id) values (1,2);
insert into major_course(major_id,course_id) values (1,3);

insert into major_group(id, size, major) values(nextval('major_group_id_seq'), 3, 1);

insert into major_group_course(group_id,course_id) values(1,1);
insert into major_group_course(group_id,course_id) values(1,2);
insert into major_group_course(group_id,course_id) values(1,3);

--SWENG-G
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 2, 501, 3, 'Advance applications of Software Engineering',
	'This course provides an overview of the discipline of Software Engineering');
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 2, 510, 3, 'Advance Programming',
	'This course provides an introduction to fundamentals of programming');
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 2, 610, 3, 'Object Oriented Design',
	'This course provides an introduction to Object Oriented Programming');

insert into course_prerequisites(parent_course, required_course) values(4, 3);
insert into course_prerequisites(parent_course, required_course) values(5, 4);
insert into course_prerequisites(parent_course, required_course) values(6, 5);

insert into major_course(major_id,course_id) values (2,4);
insert into major_course(major_id,course_id) values (2,5);
insert into major_course(major_id,course_id) values (2,6);

insert into major_group(id, size, major) values(nextval('major_group_id_seq'), 3, 2);

insert into major_group_course(group_id,course_id) values(1,4);
insert into major_group_course(group_id,course_id) values(1,5);
insert into major_group_course(group_id,course_id) values(1,6);

--CS
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 3, 101, 3, 'Programming with Python',
	'An introduction to programming using an intreperted langauge.');
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 3, 210, 3, 'Data Structures',
	'Provides an overview to common data structures and their analysis');
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 3, 310, 3, 'Algorithims',
	'Provides an overview to common algorithims and their analysis');

insert into course_prerequisites(parent_course, required_course) values(3, 8);
insert into course_prerequisites(parent_course, required_course) values(3, 9);

insert into major_course(major_id,course_id) values (3,7);
insert into major_course(major_id,course_id) values (3,8);
insert into major_course(major_id,course_id) values (3,9);

insert into major_group(id, size, major) values(nextval('major_group_id_seq'), 3, 3);

insert into major_group_course(group_id,course_id) values(2,7);
insert into major_group_course(group_id,course_id) values(2,8);
insert into major_group_course(group_id,course_id) values(2,9);

--EE
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 4, 110, 3, 'Electronic Priniciples',
	'Foundations of electronics');
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 4, 215, 3, 'Digital Design Fundamentals',
	'Foundations of digital design');
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 4, 340, 3, 'Power Systems Analysis',
	'In depth evaluation of power systems.');

insert into course_prerequisites(parent_course, required_course) values(11, 10);
insert into course_prerequisites(parent_course, required_course) values(12, 11);

insert into major_course(major_id,course_id) values (4,10);
insert into major_course(major_id,course_id) values (4,11);
insert into major_course(major_id,course_id) values (4,12);

insert into major_group(id, size, major) values(nextval('major_group_id_seq'), 3, 4);

insert into major_group_course(group_id,course_id) values(3,10);
insert into major_group_course(group_id,course_id) values(3,11);
insert into major_group_course(group_id,course_id) values(3,12);

--PAINT
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 5, 101, 3, 'Intro to Painting',
	'An introduction to Painting ');
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 5, 220, 3, 'Painting People',
	'An overview of painting people');
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 5, 350, 3, 'Underwater Painting',
	'This class aims to teach students how to paint while submerged in water.');

insert into course_prerequisites(parent_course, required_course) values(14, 13);
insert into course_prerequisites(parent_course, required_course) values(15, 14);

insert into major_course(major_id,course_id) values (5,13);
insert into major_course(major_id,course_id) values (5,14);
insert into major_course(major_id,course_id) values (5,15);

insert into major_group(id, size, major) values(nextval('major_group_id_seq'), 3, 5);

insert into major_group_course(group_id,course_id) values(4,13);
insert into major_group_course(group_id,course_id) values(4,14);
insert into major_group_course(group_id,course_id) values(4,15);

--PHOTO
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 6, 101, 3, 'Intro to Photography',
	'An introduction to Photography. ');
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 6, 220, 3, 'Photographing People',
	'An overview of photographing people');
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 6, 350, 3, 'Selfies',
	'This class aims to teach students how to take pictures of themselves.');

insert into course_prerequisites(parent_course, required_course) values(17, 16);
insert into course_prerequisites(parent_course, required_course) values(18, 17);

insert into major_course(major_id,course_id) values (6,16);
insert into major_course(major_id,course_id) values (6,17);
insert into major_course(major_id,course_id) values (6,18);

insert into major_group(id, size, major) values(nextval('major_group_id_seq'), 3, 6);

insert into major_group_course(group_id,course_id) values(5,16);
insert into major_group_course(group_id,course_id) values(5,17);
insert into major_group_course(group_id,course_id) values(5,18);

--POTT
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 7, 101, 3, 'Intro to Pottery',
	'An introduction to Pottery. ');
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 7, 230, 3, 'Advance Pottery',
	'An overview of photographing people');
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 7, 410, 3, 'Pottery Studo',
	'This class allows students to explore the medium of Pottery and showcase their work.');

insert into course_prerequisites(parent_course, required_course) values(20, 19);
insert into course_prerequisites(parent_course, required_course) values(21, 20);

insert into major_course(major_id,course_id) values (7,19);
insert into major_course(major_id,course_id) values (7,20);
insert into major_course(major_id,course_id) values (7,21);

insert into major_group(id, size, major) values(nextval('major_group_id_seq'), 3, 7);

insert into major_group_course(group_id,course_id) values(6,19);
insert into major_group_course(group_id,course_id) values(6,20);
insert into major_group_course(group_id,course_id) values(6,21);

--BUS
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 8, 101, 3, 'Intro to Business',
	'An introduction to business. ');
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 8, 240, 3, 'Operating and Planning',
	'An overview of operations and planning in the modern day work place.');
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 8, 351, 3, 'Management',
	'Project based course covering concepts in management.');

insert into course_prerequisites(parent_course, required_course) values(23, 22);
insert into course_prerequisites(parent_course, required_course) values(24, 23);

insert into major_course(major_id,course_id) values (8,22);
insert into major_course(major_id,course_id) values (8,23);
insert into major_course(major_id,course_id) values (8,24);

insert into major_group(id, size, major) values(nextval('major_group_id_seq'), 3, 8);

insert into major_group_course(group_id,course_id) values(7,22);
insert into major_group_course(group_id,course_id) values(7,23);
insert into major_group_course(group_id,course_id) values(7,24);

--FIN
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 9, 110, 3, 'Intro to Finance',
	'An introduction to finance. ');
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 9, 240, 3, 'Financial Modeling',
	'Numerical methods used in modern day finance.');
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 9, 351, 3, 'Advance Excel',
	'Excel is a a mainstay in finance and with ne features continues to be a required tool
	for every professional in finance today.');

insert into course_prerequisites(parent_course, required_course) values(26, 25);
insert into course_prerequisites(parent_course, required_course) values(27, 26);

insert into major_course(major_id,course_id) values (9,25);
insert into major_course(major_id,course_id) values (9,26);
insert into major_course(major_id,course_id) values (9,27);

insert into major_group(id, size, major) values(nextval('major_group_id_seq'), 3, 9);

insert into major_group_course(group_id,course_id) values(8,25);
insert into major_group_course(group_id,course_id) values(8,26);
insert into major_group_course(group_id,course_id) values(8,27);

--MKT
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 10, 110, 3, 'Intro to Marketing',
	'An introduction to finance. ');
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 10, 240, 3, 'Marketing Research',
	'Research methods used in Marketing.');
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 10, 351, 3, 'Business to Busineess Marketing.',
	'Overview of techniques used in B2B marketing stargeties.');

insert into course_prerequisites(parent_course, required_course) values(29, 28);
insert into course_prerequisites(parent_course, required_course) values(30, 29);

insert into major_course(major_id,course_id) values (10,28);
insert into major_course(major_id,course_id) values (10,29);
insert into major_course(major_id,course_id) values (10,30);

insert into major_group(id, size, major) values(nextval('major_group_id_seq'), 3, 10);

insert into major_group_course(group_id,course_id) values(9,28);
insert into major_group_course(group_id,course_id) values(9,29);
insert into major_group_course(group_id,course_id) values(9,30);

--MED
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 11, 510, 3, 'Anatomy and Physiology',
	'Systems view of mamilian A&P.');
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 11, 640, 3, 'Ethics',
	'In depth overview of governing ethics in medicine');
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 11, 751, 3, 'Clinical internship',
	'This course allows the student to earn coursework credit while gaining clinical experience.');

insert into course_prerequisites(parent_course, required_course) values(32, 31);
insert into course_prerequisites(parent_course, required_course) values(33, 32);


insert into major_group(id, size, major) values(nextval('major_group_id_seq'), 3, 11);

insert into major_group_course(group_id,course_id) values(10,31);
insert into major_group_course(group_id,course_id) values(10,32);
insert into major_group_course(group_id,course_id) values(10,33);

--LAW
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 12, 515, 3, 'Legal Research',
	'Research methods used in law.');
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 12, 540, 3, 'Ethics',
	'In depth overview of governing ethics in law');
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 12, 751, 3, 'Legal Practicum',
	'This course allows the student to earn coursework credit while gaining legal experience.');

insert into course_prerequisites(parent_course, required_course) values(35, 34);
insert into course_prerequisites(parent_course, required_course) values(36, 35);

insert into major_group(id, size, major) values(nextval('major_group_id_seq'), 3, 12);

insert into major_group_course(group_id,course_id) values(11,34);
insert into major_group_course(group_id,course_id) values(11,35);
insert into major_group_course(group_id,course_id) values(11,36);

--APM
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 13, 115, 3, 'Foundations of Applied Mathematics',
	'An overview of methods used in applied mathematics');
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 13, 240, 3, 'Computational Methods',
	'This course explore computing used to solve applied problems');
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 13, 451, 3, 'Numerical Analysis',
	'Numerical analysis is the study of algorithms that use numerical approximation
	(as opposed to general symbolic manipulations) for the problems of mathematical
	analysis (as distinguished from discrete mathematics).');

insert into course_prerequisites(parent_course, required_course) values(38, 37);
insert into course_prerequisites(parent_course, required_course) values(39, 38);


insert into major_group(id, size, major) values(nextval('major_group_id_seq'), 3, 13);

insert into major_group_course(group_id,course_id) values(12,37);
insert into major_group_course(group_id,course_id) values(12,38);
insert into major_group_course(group_id,course_id) values(12,39);

--MAT-U
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 14, 100, 3, 'College Mathematics',
	'A foundation of mathematics for math majors.');
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 14, 225, 3, 'Probability Theory',
	'is the branch of mathematics concerned with probability.');
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 14, 451, 3, 'Dynamic Systems.',
	'A study of the nature and behavior of solutions of linear and nonlinear systems
	of differential and difference equations through mathematical analysis and the use of available
	menu-driven PC software.');

insert into course_prerequisites(parent_course, required_course) values(41, 40);
insert into course_prerequisites(parent_course, required_course) values(42, 41);


insert into major_group(id, size, major) values(nextval('major_group_id_seq'), 3, 14);

insert into major_group_course(group_id,course_id) values(13,40);
insert into major_group_course(group_id,course_id) values(13,41);
insert into major_group_course(group_id,course_id) values(13,42);

--MAT-G
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 15, 520, 3, 'Computational Mathematics',
	'In depth coverage of computional methods for numerical problem solving.');
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 15, 631, 3, 'Nonlinear Phenomena',
	'which, in contrast to a linear system, cannot be explained by a
	mathematical relationship of proportionality (that is, a linear
	relationship between two variables). ');
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 15, 651, 3, 'Advance Probability Theory',
	'is the branch of mathematics concerned with probability-GR.');

insert into course_prerequisites(parent_course, required_course) values(43, 38);
insert into course_prerequisites(parent_course, required_course) values(44, 42);
insert into course_prerequisites(parent_course, required_course) values(45, 41);


insert into major_group(id, size, major) values(nextval('major_group_id_seq'), 3, 15);

insert into major_group_course(group_id,course_id) values(13,43);
insert into major_group_course(group_id,course_id) values(13,44);
insert into major_group_course(group_id,course_id) values(13,45);

insert into building(id, name, occupancy_limit, department) values (nextval('building_id_seq'), 'Hammond', 3000, 'ENGINEERING');
insert into building(id, name, occupancy_limit, department) values (nextval('building_id_seq'), 'Willard', 5000, 'ARTS');
insert into building(id, name, occupancy_limit, department) values (nextval('building_id_seq'), 'Business', 1500, 'BUSINESS');
insert into building(id, name, occupancy_limit, department) values (nextval('building_id_seq'), 'Life Science', 700, 'MEDICINE');
insert into building(id, name, occupancy_limit, department) values (nextval('building_id_seq'), 'Law', 1000, 'LAW');
insert into building(id, name, occupancy_limit, department) values (nextval('building_id_seq'), 'McAlister', 1300, 'MATH');

insert into room(id, building, number, type, capacity) values(nextval('room_id_seq'), 1, 101, 'CLASSROOM', 40);
insert into room(id, building, number, type, capacity) values(nextval('room_id_seq'), 1, 102, 'CLASSROOM', 35);
insert into room(id, building, number, type, capacity) values(nextval('room_id_seq'), 1, 103, 'OFFICE', 20);
insert into room(id, building, number, type, capacity) values(nextval('room_id_seq'), 1, 104, 'BATHROOM', 20);
insert into room(id, building, number, type, capacity) values(nextval('room_id_seq'), 1, 105, 'CLASSROOM', 250);
insert into room(id, building, number, type, capacity) values(nextval('room_id_seq'), 1, 201, 'CLASSROOM', 500);

insert into room(id, building, number, type, capacity) values(nextval('room_id_seq'), 2, 101, 'CLASSROOM', 25);
insert into room(id, building, number, type, capacity) values(nextval('room_id_seq'), 2, 102, 'CLASSROOM', 600);
insert into room(id, building, number, type, capacity) values(nextval('room_id_seq'), 2, 103, 'CLASSROOM', 550);
insert into room(id, building, number, type, capacity) values(nextval('room_id_seq'), 2, 104, 'CLASSROOM', 550);

insert into liontrail_user(user_id,first_name,last_name,middle_name,username) values(nextval('user_id_seq'),'Albert','Charles','Bravo','abc1');
insert into employee(user_id) values(1);
insert into liontrail_user(user_id,first_name,last_name,middle_name,username) values(nextval('user_id_seq'),'Bravo','Delta','Charlie','bcd1');
insert into employee(user_id) values(2);

insert into liontrail_user(user_id,first_name,last_name,middle_name,username) values(nextval('user_id_seq'),'First','Student','One','fos1');
insert into student(user_id) values(3);

insert into liontrail_user(user_id,first_name,last_name,middle_name,username) values(nextval('user_id_seq'),'Admin','Admin','Admin','admin');
insert into employee(user_id) values(4);

insert into liontrail_user(user_id,first_name,last_name,middle_name,username) values(nextval('user_id_seq'),'Robert','Student','Test','rts1');
insert into student(user_id) values(5);

insert into application(id, essay, gpa, highschool, status, major_id, semester_id, student_id)
values(nextval('application_id_seq'), 'I think I should be accepted because I am good', 3.3, 'Midtown Highschool', 'SUBMITTED', 1, 1, 3);

insert into admission(cohort_id, cohort_size, major_id, semetser_id) values(nextval('cohort_id_seq'), 25, 1, 1);


-- Classes
insert into class(id, semester_id, course_id, instructor_id, start_time, stop_time, room, online, size)
	values(nextval('class_id_seq'), 1, 1, 1, '02:30', '03:30', 1, true, 20);
insert into class_day(class_id, day) values (1, 'TUESDAY');
	insert into class_day(class_id, day) values (1, 'THURSDAY');

insert into class(id, semester_id, course_id, instructor_id, start_time, stop_time, room, online, size)
	values(nextval('class_id_seq'), 1, 1, 1, '02:30', '03:30', 1, true, 20);
insert into class_day(class_id, day) values (2, 'MONDAY');
	insert into class_day(class_id, day) values (2, 'WEDNESDAY');

insert into class(id, semester_id, course_id, instructor_id, start_time, stop_time, room, online, size)
	values(nextval('class_id_seq'), 1, 2, 1, '02:30', '05:30', 1, true, 20);
insert into class_day(class_id, day) values (3, 'WEDNESDAY');

insert into class(id, semester_id, course_id, instructor_id, start_time, stop_time, room, online, size)
	values(nextval('class_id_seq'), 1, 3, 1, '01:30', '02:30', 1, true, 20);
insert into class_day(class_id, day) values (4, 'WEDNESDAY');
	insert into class_day(class_id, day) values (4, 'FRIDAY');

insert into class(id, semester_id, course_id, instructor_id, start_time, stop_time, room, online, size)
	values(nextval('class_id_seq'), 1, 4, 1, '05:00', '08:00', 1, true, 20);
insert into class_day(class_id, day) values (5, 'FRIDAY');

insert into class(id, semester_id, course_id, instructor_id, start_time, stop_time, room, online, size)
	values(nextval('class_id_seq'), 1, 4, 1, '05:00', '08:00', 1, true, 20);
insert into class_day(class_id, day) values (6, 'FRIDAY');

insert into class(id, semester_id, course_id, instructor_id, start_time, stop_time, room, online, size)
	values(nextval('class_id_seq'), 1, 4, 1, '05:00', '08:00', 1, true, 20);
insert into class_day(class_id, day) values (7, 'FRIDAY');

insert into class(id, semester_id, course_id, instructor_id, start_time, stop_time, room, online, size)
	values(nextval('class_id_seq'), 1, 5, 1, '12:00', '03:00', 1, true, 20);
insert into class_day(class_id, day) values (8, 'MONDAY');

insert into class(id, semester_id, course_id, instructor_id, start_time, stop_time, room, online, size)
	values(nextval('class_id_seq'), 1, 5, 1, '12:00', '03:00', 1, true, 20);
insert into class_day(class_id, day) values (9, 'TUESDAY');

-- Class Enrollment
insert into class_enrollment(id, class_id, student_id, grade)
 values(nextval('class_enrollment_id_seq'), 1, 5, '');