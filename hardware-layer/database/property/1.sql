--------------------------------------------------
----------- TABLA PROPIEDAD HORIZONTAL -----------
--------------------------------------------------


-- DROP SEQUENCE property."PROPIEDAD_HORIZONTAL_id_seq";

CREATE SEQUENCE property."PROPIEDAD_HORIZONTAL_id_seq";

ALTER SEQUENCE property."PROPIEDAD_HORIZONTAL_id_seq"
    OWNER TO property;

CREATE TABLE property."PROPIEDAD_HORIZONTAL"
(
    id bigint NOT NULL DEFAULT nextval('"PROPIEDAD_HORIZONTAL_id_seq"'::regclass),
    nit character varying COLLATE pg_catalog."default" NOT NULL,
    nombre_distintivo character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "PROPIEDAD_HORIZONTAL_pkey" PRIMARY KEY (id),
    CONSTRAINT "PROPIEDAD_HORIZONTAL_nit_key" UNIQUE (nit)

)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE property."PROPIEDAD_HORIZONTAL"
    OWNER to property;
