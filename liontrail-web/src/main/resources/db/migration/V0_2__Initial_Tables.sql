CREATE TABLE admission (
    cohort_id integer NOT NULL,
    cohort_size integer,
    major_id integer NOT NULL,
    semetser_id integer NOT NULL
);

CREATE TABLE admission_student (
    cohort integer NOT NULL,
    student integer NOT NULL
);

CREATE TABLE application (
    id integer NOT NULL,
    status integer NOT NULL,
    major_id integer NOT NULL,
    semester_id integer NOT NULL,
    student_id integer NOT NULL
);

CREATE SEQUENCE application_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE auth_user (
    username character varying(50) NOT NULL,
    password character varying(255)
);

CREATE TABLE auth_user_role (
    username character varying(50) NOT NULL,
    role character varying(255) NOT NULL
);

CREATE TABLE building (
    id integer NOT NULL,
    department character varying(60) NOT NULL,
    name character varying(70) NOT NULL,
    occupancy_limit integer NOT NULL,
    CONSTRAINT building_occupancy_limit_check CHECK ((occupancy_limit >= 1))
);

CREATE SEQUENCE building_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE class (
    id integer NOT NULL,
    frequency character varying(50) NOT NULL,
    online boolean NOT NULL,
    size integer NOT NULL,
    start_time time without time zone NOT NULL,
    stop_time time without time zone NOT NULL,
    course_id integer NOT NULL,
    instructor_id integer NOT NULL,
    room integer NOT NULL,
    semester_id integer NOT NULL
);

CREATE SEQUENCE class_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE SEQUENCE cohort_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    
CREATE TABLE class_enrollment (
    id integer NOT NULL,
    grade character varying(5) NOT NULL,
    class_id integer NOT NULL,
    student_id integer NOT NULL
);

CREATE SEQUENCE class_enrollment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE course (
    id integer NOT NULL,
    credits integer NOT NULL,
    department character varying(15) NOT NULL,
    description character varying(255) NOT NULL,
    name character varying(60) NOT NULL,
    number integer NOT NULL,
    CONSTRAINT course_credits_check CHECK ((credits >= 1))
);

CREATE SEQUENCE course_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE course_prerequisites (
    parent_course integer NOT NULL,
    required_course integer NOT NULL
);

CREATE TABLE department (
    id character varying(60) NOT NULL,
    name character varying(60) NOT NULL,
    dean integer NOT NULL
);

CREATE TABLE instructor (
    user_id integer NOT NULL
);

CREATE TABLE liontrail_user (
    user_id integer NOT NULL,
    first_name character varying(255) NOT NULL,
    last_name character varying(255) NOT NULL,
    middle_name character varying(255) NOT NULL,
    username character varying(50) NOT NULL
);

CREATE TABLE major (
    id integer NOT NULL,
    degree_level character varying(5) NOT NULL,
    name character varying(50) NOT NULL,
    department_id character varying(60) NOT NULL
);

CREATE TABLE major_course (
    major_id integer NOT NULL,
    course_id integer NOT NULL
);

CREATE TABLE major_group (
    id integer NOT NULL,
    size integer NOT NULL,
    major integer,
    CONSTRAINT major_group_size_check CHECK ((size >= 0))
);

CREATE TABLE major_group_course (
    group_id integer NOT NULL,
    course_id integer NOT NULL
);

CREATE SEQUENCE major_group_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE SEQUENCE major_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE room (
    id integer NOT NULL,
    capacity integer,
    type character varying(40) NOT NULL,
    building integer,
    CONSTRAINT room_capacity_check CHECK ((capacity >= 0))
);

CREATE SEQUENCE room_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE student (
    user_id integer NOT NULL
);

CREATE SEQUENCE user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE ONLY admission
    ADD CONSTRAINT admission_pkey PRIMARY KEY (cohort_id);

ALTER TABLE ONLY application
    ADD CONSTRAINT application_pkey PRIMARY KEY (id);

ALTER TABLE ONLY auth_user
    ADD CONSTRAINT auth_user_pkey PRIMARY KEY (username);

ALTER TABLE ONLY auth_user_role
    ADD CONSTRAINT auth_user_role_pkey PRIMARY KEY (username);

ALTER TABLE ONLY building
    ADD CONSTRAINT building_pkey PRIMARY KEY (id);

ALTER TABLE ONLY class
    ADD CONSTRAINT class_pkey PRIMARY KEY (id);
    
ALTER TABLE ONLY class_enrollment
    ADD CONSTRAINT class_enrollment_pkey PRIMARY KEY (id);

ALTER TABLE ONLY course
    ADD CONSTRAINT course_pkey PRIMARY KEY (id);

ALTER TABLE ONLY course_prerequisites
    ADD CONSTRAINT course_prerequisites_pkey PRIMARY KEY (parent_course, required_course);

ALTER TABLE ONLY department
    ADD CONSTRAINT department_pkey PRIMARY KEY (id);

ALTER TABLE ONLY instructor
    ADD CONSTRAINT instructor_pkey PRIMARY KEY (user_id);

ALTER TABLE ONLY liontrail_user
    ADD CONSTRAINT liontrail_user_pkey PRIMARY KEY (user_id);

ALTER TABLE ONLY major_group_course
    ADD CONSTRAINT major_group_course_pkey PRIMARY KEY (group_id, course_id);

ALTER TABLE ONLY major_group
    ADD CONSTRAINT major_group_pkey PRIMARY KEY (id);

ALTER TABLE ONLY major
    ADD CONSTRAINT major_pkey PRIMARY KEY (id);

ALTER TABLE ONLY room
    ADD CONSTRAINT room_pkey PRIMARY KEY (id);

ALTER TABLE ONLY student
    ADD CONSTRAINT student_pkey PRIMARY KEY (user_id);

ALTER TABLE ONLY department
    ADD CONSTRAINT unique_department_name UNIQUE (name);

ALTER TABLE ONLY major
    ADD CONSTRAINT unique_major UNIQUE (department_id, name);

ALTER TABLE ONLY liontrail_user
    ADD CONSTRAINT unique_liontrail_user UNIQUE (username);
    
ALTER TABLE ONLY class_enrollment
    ADD CONSTRAINT fk_class_enrollment_unique UNIQUE (class_id, student_id);

ALTER TABLE ONLY course
    ADD CONSTRAINT unique_course UNIQUE (department, number);

ALTER TABLE ONLY application
    ADD CONSTRAINT unique_application UNIQUE (student_id, major_id, semester_id);

ALTER TABLE ONLY building
    ADD CONSTRAINT unique_building UNIQUE (name);

ALTER TABLE ONLY class
    ADD CONSTRAINT fk_class_to_semester FOREIGN KEY (semester_id) REFERENCES semester(id);

ALTER TABLE ONLY class_enrollment
    ADD CONSTRAINT fk_class_enrollment_to_class FOREIGN KEY (class_id) REFERENCES class(id);
    
ALTER TABLE ONLY class_enrollment
    ADD CONSTRAINT fk_class_enrollement_to_student FOREIGN KEY (student_id) REFERENCES student(user_id);

ALTER TABLE ONLY major_course
    ADD CONSTRAINT fk_major_course_to_major FOREIGN KEY (major_id) REFERENCES major(id);

ALTER TABLE ONLY student
    ADD CONSTRAINT fk_student_to_liontrail_user FOREIGN KEY (user_id) REFERENCES liontrail_user(user_id);

ALTER TABLE ONLY application
    ADD CONSTRAINT fk_application_to_semester FOREIGN KEY (semester_id) REFERENCES semester(id);

ALTER TABLE ONLY major
    ADD CONSTRAINT fk_major_to_department FOREIGN KEY (department_id) REFERENCES department(id);

ALTER TABLE ONLY course_prerequisites
    ADD CONSTRAINT fk_course_prereq_to_parent_course FOREIGN KEY (parent_course) REFERENCES course(id);

ALTER TABLE ONLY admission
    ADD CONSTRAINT fk_admission_to_semester FOREIGN KEY (semetser_id) REFERENCES semester(id);

ALTER TABLE ONLY class
    ADD CONSTRAINT fk_class_to_instructor FOREIGN KEY (instructor_id) REFERENCES instructor(user_id);

ALTER TABLE ONLY admission_student
    ADD CONSTRAINT fk_admission_student_to_student FOREIGN KEY (student) REFERENCES student(user_id);

ALTER TABLE ONLY admission_student
    ADD CONSTRAINT fk_admission_student_to_admission FOREIGN KEY (cohort) REFERENCES admission(cohort_id);

ALTER TABLE ONLY admission
    ADD CONSTRAINT fk_admission_to_major FOREIGN KEY (major_id) REFERENCES major(id);

ALTER TABLE ONLY major_group_course
    ADD CONSTRAINT fk_major_course_group_to_major_group FOREIGN KEY (group_id) REFERENCES major_group(id);

ALTER TABLE ONLY course_prerequisites
    ADD CONSTRAINT fk_course_prereq_to_required_course FOREIGN KEY (required_course) REFERENCES course(id);

ALTER TABLE ONLY application
    ADD CONSTRAINT fk_application_to_student FOREIGN KEY (student_id) REFERENCES student(user_id);

ALTER TABLE ONLY application
    ADD CONSTRAINT fk_application_to_major FOREIGN KEY (major_id) REFERENCES major(id);

ALTER TABLE ONLY major_group
    ADD CONSTRAINT f_major_group_to_major FOREIGN KEY (major) REFERENCES major(id);

ALTER TABLE ONLY major_group_course
    ADD CONSTRAINT fk_major_group_course_to_course FOREIGN KEY (course_id) REFERENCES course(id);

ALTER TABLE ONLY class
    ADD CONSTRAINT fk_class_to_course FOREIGN KEY (course_id) REFERENCES course(id);

ALTER TABLE ONLY room
    ADD CONSTRAINT fk_room_to_building FOREIGN KEY (building) REFERENCES building(id);

ALTER TABLE ONLY major_course
    ADD CONSTRAINT fk_major_course_to_course FOREIGN KEY (course_id) REFERENCES course(id);

ALTER TABLE ONLY class
    ADD CONSTRAINT fk_class_to_room FOREIGN KEY (room) REFERENCES room(id);

ALTER TABLE ONLY instructor
    ADD CONSTRAINT fk_instructor_to_liontrail_user FOREIGN KEY (user_id) REFERENCES liontrail_user(user_id);

ALTER TABLE ONLY department
    ADD CONSTRAINT fk_department_to_instructor FOREIGN KEY (dean) REFERENCES instructor(user_id);
