CREATE SEQUENCE public."DISPOSITIVO_id_seq";

ALTER SEQUENCE public."DISPOSITIVO_id_seq"
    OWNER TO device_user;

CREATE SEQUENCE public."HISTORIAL_ACCESO_PEATONAL_id_seq";

ALTER SEQUENCE public."HISTORIAL_ACCESO_PEATONAL_id_seq"
    OWNER TO device_user;
	
CREATE TYPE public."device type" AS ENUM
    ('ACTIVO', 'MANTENIMIENTO', 'DEFECTUOSO', 'INACTIVO');

ALTER TYPE public."device type"
    OWNER TO device_user;
	
CREATE TYPE public."historial access type" AS ENUM
    ('AUTOMATICO', 'MANUAL');

ALTER TYPE public."historial access type"
    OWNER TO device_user;
	
CREATE TABLE public."DISPOSITIVO"
(
    id bigint NOT NULL DEFAULT nextval('"DISPOSITIVO_id_seq"'::regclass),
    name character varying(150) COLLATE pg_catalog."default",
    serial character varying(45) COLLATE pg_catalog."default",
    bien_comun integer,
    state "device type" DEFAULT 'ACTIVO'::"device type",
    CONSTRAINT "DISPOSITIVO_pkey" PRIMARY KEY (id),
    CONSTRAINT "DISPOSITIVO_bien_comun_id_key" UNIQUE (bien_comun),
    CONSTRAINT "DISPOSITIVO_hash_key" UNIQUE (serial)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."DISPOSITIVO"
    OWNER to device_user;
	
--- TABLA DE HISTORICOS DE ACCESO PEATONAL
CREATE TABLE public."HISTORIAL_ACCESO_PEATONAL"
(
    id bigint NOT NULL DEFAULT nextval('"HISTORIAL_ACCESO_PEATONAL_id_seq"'::regclass),
    fecha_ingreso timestamp(6) without time zone,
    identificacion character varying(21) COLLATE pg_catalog."default",
    bien_comun_fk integer,
    tipo "historial access type" DEFAULT 'AUTOMATICO'::"historial access type",
    CONSTRAINT "HISTORIAL_ACCESO_PEATONAL_pkey" PRIMARY KEY (id),
    CONSTRAINT "HISTORIAL_ACCESO_PEATONAL_identificacion_key" UNIQUE (identificacion),
    CONSTRAINT "HISTORIAL_ACCESO_PEATONAL_bien_comun_fk_fkey" FOREIGN KEY (bien_comun_fk)
        REFERENCES public."DISPOSITIVO" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."HISTORIAL_ACCESO_PEATONAL"
    OWNER to device_user;

