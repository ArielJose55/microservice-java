CREATE SEQUENCE public."NATURAL_PERSON_id_seq";

ALTER SEQUENCE public."NATURAL_PERSON_id_seq"
    OWNER TO person_user;

CREATE SEQUENCE public."RESIDENT_id_seq";

ALTER SEQUENCE public."RESIDENT_id_seq"
    OWNER TO person_user;

CREATE SEQUENCE public."PET_id_seq";

ALTER SEQUENCE public."PET_id_seq"
    OWNER TO person_user;

CREATE SEQUENCE public."USER_id_seq";

ALTER SEQUENCE public."USER_id_seq"
    OWNER TO person_user;

CREATE TYPE public."User State" AS ENUM
    ('ACTIVE', 'INACTIVE');

ALTER TYPE public."User State"
    OWNER TO person_user;

CREATE TABLE public."PERSON"
(
    identification character varying(25) COLLATE pg_catalog."default" NOT NULL,
    "typeIdentification" character varying(25) COLLATE pg_catalog."default",
    CONSTRAINT "PERSON_pkey" PRIMARY KEY (identification)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."PERSON"
    OWNER to person_user;


CREATE TABLE public."NATURAL_PERSON"
(
    id bigint NOT NULL DEFAULT nextval('"NATURAL_PERSON_id_seq"'::regclass),
    name character varying(120) COLLATE pg_catalog."default",
    last_name character varying(120) COLLATE pg_catalog."default",
    person_fk character varying(25) COLLATE pg_catalog."default",
    CONSTRAINT "NATURAL_PERSON_pkey" PRIMARY KEY (id),
    CONSTRAINT "NATURAL_PERSON_person_fk_key" UNIQUE (person_fk)
,
    CONSTRAINT "NATURAL_PERSON_person_fk_fkey" FOREIGN KEY (person_fk)
        REFERENCES public."PERSON" (identification) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."NATURAL_PERSON"
    OWNER to person_user;


CREATE TABLE public."RESIDENT"
(
    id bigint NOT NULL DEFAULT nextval('"RESIDENT_id_seq"'::regclass),
    type character varying(25) COLLATE pg_catalog."default",
    person_natural_fk character varying(25) COLLATE pg_catalog."default",
    CONSTRAINT "RESIDENT_pkey" PRIMARY KEY (id),
    CONSTRAINT "RESIDENT_person_natural_fk_key" UNIQUE (person_natural_fk)
,
    CONSTRAINT "RESIDENT_person_natural_fk_fkey" FOREIGN KEY (person_natural_fk)
        REFERENCES public."NATURAL_PERSON" (person_fk) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."RESIDENT"
    OWNER to person_user;

CREATE TABLE public."USER"
(
    id bigint NOT NULL DEFAULT nextval('"USER_id_seq"'::regclass),
    username character varying(35) COLLATE pg_catalog."default" NOT NULL,
    password character varying(255) COLLATE pg_catalog."default" NOT NULL,
    register_date timestamp without time zone NOT NULL DEFAULT now(),
    state "User State" NOT NULL DEFAULT 'ACTIVE'::"User State",
    person_fk character varying(25) COLLATE pg_catalog."default",
    CONSTRAINT "USER_pkey" PRIMARY KEY (id),
    CONSTRAINT "USER_username_key" UNIQUE (username)
,
    CONSTRAINT "USER_person_fk_fkey" FOREIGN KEY (person_fk)
        REFERENCES public."PERSON" (identification) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."USER"
    OWNER to person_user;


CREATE TABLE public."PET"
(
    id bigint NOT NULL DEFAULT nextval('"PET_id_seq"'::regclass),
    name character varying(75) COLLATE pg_catalog."default",
    species character varying(75) COLLATE pg_catalog."default",
    resident_fk character varying(21) COLLATE pg_catalog."default",
    CONSTRAINT "PET_pkey" PRIMARY KEY (id),
    CONSTRAINT "PET_resident_fk_fkey" FOREIGN KEY (resident_fk)
        REFERENCES public."RESIDENT" (person_natural_fk) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."PET"
    OWNER to person_user;

