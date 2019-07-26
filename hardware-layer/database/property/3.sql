--------------------------------------------------
------------- TABLA PROPIEDAD_COMUN --------------
--------------------------------------------------

-- DROP TABLE property."PROPIEDAD_COMUN";

CREATE SEQUENCE property."PROPIEDAD_COMUN_id_seq";

CREATE TABLE property."PROPIEDAD_COMUN"
(
    id							bigint 					NOT NULL	 DEFAULT nextval('"property"."PROPIEDAD_COMUN_id_seq"'::regclass),
    nombre 						varchar 				NOT NULL,
    esencial					boolean					NOT NULL,
    nit_propiedad_horizontal 	varchar					NOT NULL,
    CONSTRAINT 					pc_pkey				 	PRIMARY KEY (id),
    CONSTRAINT 					nit_ph_fkey				FOREIGN KEY (nit_propiedad_horizontal)
        REFERENCES property."PROPIEDAD_HORIZONTAL" (nit) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)