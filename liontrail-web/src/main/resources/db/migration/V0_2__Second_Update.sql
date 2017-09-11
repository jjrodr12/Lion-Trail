--create child table
CREATE TABLE child_entity (
    id character varying(255) NOT NULL,
    color_col character varying(15),
    parent_id integer NOT NULL
);

--create parent table
CREATE TABLE parent_entity (
    id integer NOT NULL,
    some_enum integer,
    other_value character varying(40),
    some_value character varying(30) NOT NULL
);

--create sequence for id
CREATE SEQUENCE parent_entity_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

--add primary key constraints
ALTER TABLE ONLY child_entity
    ADD CONSTRAINT child_entity_pkey PRIMARY KEY (id);
ALTER TABLE ONLY parent_entity
    ADD CONSTRAINT parent_entity_pkey PRIMARY KEY (id);

--add unique constraints
ALTER TABLE ONLY parent_entity
    ADD CONSTRAINT parent_other_unique UNIQUE (other_value);
ALTER TABLE ONLY parent_entity
    ADD CONSTRAINT parent_some_enum_unique UNIQUE (some_value, some_enum);

--add foreign key constraint
ALTER TABLE ONLY child_entity
    ADD CONSTRAINT parent_child_fk FOREIGN KEY (parent_id) REFERENCES parent_entity(id);

