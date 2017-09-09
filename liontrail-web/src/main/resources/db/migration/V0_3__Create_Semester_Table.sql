CREATE TABLE semester (
    id integer NOT NULL,
    class_registration_date date NOT NULL,
    drop_add_deadline_date date NOT NULL,
    first_class_date date NOT NULL,
    first_exam_date date NOT NULL,
    last_class_date date NOT NULL,
    last_exam_date date NOT NULL,
    season character varying(255) NOT NULL,
    year integer NOT NULL
);

CREATE SEQUENCE semester_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE ONLY semester
    ADD CONSTRAINT semester_pkey PRIMARY KEY (id);
    
ALTER TABLE ONLY semester
    ADD CONSTRAINT semester_unique UNIQUE (season, year);
    
    
insert into semester(id,class_registration_date,drop_add_deadline_date,first_class_date,first_exam_date,last_class_date,
last_exam_date,season,year) values (nextval('semester_id_seq'),'2017-07-20','2017-09-08','2017-08-21',
'2017-12-11','2017-12-08','2017-12-15','FALL',2017);

insert into semester(id,class_registration_date,drop_add_deadline_date,first_class_date,first_exam_date,last_class_date,
last_exam_date,season,year) values (nextval('semester_id_seq'),'2017-11-20','2017-01-08','2018-01-22',
'2018-05-07','2018-05-04','2018-05-11','SPRING',2018);