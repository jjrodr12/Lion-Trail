insert into semester(id,adminssion_start,adminssion_stop,class_registration_date,drop_add_deadline_date,first_class_date,first_exam_date,last_class_date,
last_exam_date,season,year) values (nextval('semester_id_seq'),'2017-01-01','207-05-31','2017-07-20','2017-09-08','2017-08-21',
'2017-12-11','2017-12-08','2017-12-15','FALL',2017);

insert into semester(id,adminssion_start,adminssion_stop,class_registration_date,drop_add_deadline_date,first_class_date,first_exam_date,last_class_date,
last_exam_date,season,year) values (nextval('semester_id_seq'),'2017-06-01','2017-08-31','2017-11-20','2017-01-08','2018-01-22',
'2018-05-07','2018-05-04','2018-05-11','SPRING',2018);

insert into auth_user(username, password) values('admin','jGl25bVBBBW96Qi9Te4V37Fnqchz/Eu4qB9vKrRIqRg=');
insert into auth_user_role(username, role) values('admin','admin')