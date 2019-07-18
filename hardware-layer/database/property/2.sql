--------------------------------------------------
--- TABLA GESTION DE LA PROPIEDAD HORIZONTAL -----
--------------------------------------------------


-- DROP TABLE property."GESTION_PROPIEDAD_HORIZONTAL";

CREATE TABLE property."GESTION_PROPIEDAD_HORIZONTAL"
(
    numero_identificacion character varying COLLATE pg_catalog."default" NOT NULL,
    tipo_identificacion character varying COLLATE pg_catalog."default" NOT NULL,
    nit_propiedad_horizontal character varying COLLATE pg_catalog."default" NOT NULL,
    fecha_asignacion timestamp without time zone NOT NULL DEFAULT now(),
    CONSTRAINT "GESTION_PROPIEDAD_HORIZONTAL_pkey" PRIMARY KEY (nit_propiedad_horizontal)
        INCLUDE(numero_identificacion, tipo_identificacion),
    CONSTRAINT "GESTION_PROPIEDAD_HORIZONTAL_nit_propiedad_horizontal_fkey" FOREIGN KEY (nit_propiedad_horizontal)
        REFERENCES property."PROPIEDAD_HORIZONTAL" (nit) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE property."GESTION_PROPIEDAD_HORIZONTAL"
    OWNER to property;