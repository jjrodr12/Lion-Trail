CREATE TABLE some_entity (
    id character varying(45) NOT NULL,
    enum_val character varying(15)
);

ALTER TABLE ONLY some_entity
    ADD CONSTRAINT some_entity_pkey PRIMARY KEY (id);
