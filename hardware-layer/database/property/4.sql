--------------------------------------------------
------------- TABLA PROPIEDAD PRIVADA ------------
--------------------------------------------------

-- DROP TABLE property."PROPIEDAD_PRIVADA";

CREATE SEQUENCE property."PROPIEDAD_PRIVADA_id_seq";

CREATE TABLE property."PROPIEDAD_PRIVADA"
(
    id							bigint					NOT NULL	DEFAULT nextval('"property"."PROPIEDAD_PRIVADA_id_seq"'::regclass),
    ubicacion					varchar					NOT NULL,
    nit_propiedad_horizontal	varchar					NOT NULL,
    CONSTRAINT 					pp_pkey					PRIMARY KEY (id),
    CONSTRAINT 					nit_ph_fkey				FOREIGN KEY (nit_propiedad_horizontal)
        REFERENCES property."PROPIEDAD_HORIZONTAL" (nit) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);