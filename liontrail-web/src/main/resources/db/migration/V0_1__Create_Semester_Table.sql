CREATE TABLE semester (
    id integer NOT NULL,
    admission_start date NOT NULL,
    admission_stop date NOT NULL,
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
