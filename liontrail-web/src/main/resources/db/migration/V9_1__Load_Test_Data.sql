insert into semester(id,adminssion_start,adminssion_stop,class_registration_date,drop_add_deadline_date,first_class_date,first_exam_date,last_class_date,
last_exam_date,season,year) values (nextval('semester_id_seq'),'2017-01-01','207-05-31','2017-07-20','2017-09-08','2017-08-21',
'2017-12-11','2017-12-08','2017-12-15','FALL',2017);

insert into semester(id,adminssion_start,adminssion_stop,class_registration_date,drop_add_deadline_date,first_class_date,first_exam_date,last_class_date,
last_exam_date,season,year) values (nextval('semester_id_seq'),'2017-06-01','2017-08-31','2017-11-20','2017-01-08','2018-01-22',
'2018-05-07','2018-05-04','2018-05-11','SPRING',2018);

insert into auth_user(username, password) values('admin','jGl25bVBBBW96Qi9Te4V37Fnqchz/Eu4qB9vKrRIqRg=');
insert into auth_user_role(username, role) values('admin','admin');

insert into department(id, name) values('ENGINEERING','College of Engineering');
insert into department(id, name) values('ARTS','College of Arts');
insert into department(id, name) values('BUSINESS','Smeal College of Business');
insert into department(id, name) values('MEDICINE','Hershey College of Medicine');
insert into department(id, name) values('LAW','Dickson Law School');
insert into department(id, name) values('MATH','College of Math');

insert into major(id, abbreviation, degree_level, name, department_id)
    values(nextval('major_id_seq'), 'SWENG', 'BS', 'Software Engineering', 'ENGINEERING');
insert into major(id, abbreviation, degree_level, name, department_id)
    values(nextval('major_id_seq'), 'SWENG', 'MS', 'Software Engineering', 'ENGINEERING');
insert into major(id, abbreviation, degree_level, name, department_id)
    values(nextval('major_id_seq'), 'CMPSCI', 'BS', 'Computer Science', 'ENGINEERING');
insert into major(id, abbreviation, degree_level, name, department_id)
    values(nextval('major_id_seq'), 'EE', 'BS', 'Electrical Engineering', 'ENGINEERING');
    
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 1, 101, 3, 'Intro to Software Engineering',
	'This course provides an overview of the discipline of Software Engineering');
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 1, 110, 3, 'Basic Programming',
	'This course provides an introduction to fundamentals of programming');
insert into course(id, major_id, number, credits, name, description)
	values(nextval('course_id_seq'), 1, 210, 3, 'Object Oriented Programming',
	'This course provides an introduction to Object Oriented Programming');
	

insert into course_prerequisites(parent_course, required_course) values(3, 2);

insert into major_course(major_id,course_id) values (1,2);
insert into major_course(major_id,course_id) values (1,3);

insert into major_group(id, size, major) values(nextval('major_group_id_seq'), 2, 1);

insert into major_group_course(group_id,course_id) values(1,1);
insert into major_group_course(group_id,course_id) values(1,2);
insert into major_group_course(group_id,course_id) values(1,3);

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

