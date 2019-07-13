--------------------------------------------------
----------- TABLE HORIZONTAL PROPERTY  -----------
--------------------------------------------------
CREATE SEQUENCE property."HORIZONTAL_PROPERTY_id_seq";

ALTER SEQUENCE property."HORIZONTAL_PROPERTY_id_seq"
    OWNER TO property;

CREATE TABLE property."HORIZONTAL_PROPERTY"
(
    id bigint NOT NULL DEFAULT nextval('"HORIZONTAL_PROPERTY_id_seq"'::regclass),
    distinctive_name character varying COLLATE pg_catalog."default",
    legal_person_fk character varying COLLATE pg_catalog."default",
    CONSTRAINT "HORIZONTAL_PROPERTY_pkey" PRIMARY KEY (id),
    CONSTRAINT "HORIZONTAL_PROPERTY_legal_person_fk_key" UNIQUE (legal_person_fk)

)
WITH ( 
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE property."HORIZONTAL_PROPERTY"
    OWNER to property;


--------------------------------------------------
--------------- TABLE COMMON PROPERTY  -----------
--------------------------------------------------
CREATE SEQUENCE property."COMMON_PROPERTY_id_seq";

ALTER SEQUENCE property."COMMON_PROPERTY_id_seq"
    OWNER TO property;

CREATE TABLE public."COMMON_PROPERTY"
(
    id bigint NOT NULL DEFAULT nextval('"COMMON_PROPERTY_id_seq"'::regclass),
    name character varying COLLATE pg_catalog."default",
    essential boolean,
    nit_horizantal_property character varying COLLATE pg_catalog."default",
    CONSTRAINT "COMMON_PROPERTY_pkey" PRIMARY KEY (id),
    CONSTRAINT "COMMON_PROPERTY_nit_horizantal_property_fkey" FOREIGN KEY (nit_horizantal_property)
        REFERENCES property."HORIZONTAL_PROPERTY" (legal_person_fk) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE property."COMMON_PROPERTY"
    OWNER to property;
