--------------------------------------------------
---------- TABLA DISPONIBILIDAD HORARIA ----------
--------------------------------------------------

CREATE SEQUENCE property."DISPONIBILIDAD_HORARIA_id_seq";

CREATE TABLE property."DISPONIBILIDAD_HORARIA"
(
    id 							bigint 						NOT NULL DEFAULT nextval('"property"."DISPONIBILIDAD_HORARIA_id_seq"'::regclass),
    dia_semana 					integer						NOT NULL,		
    hora_inicial 				time without time zone		NOT NULL,
    hora_final 					time without time zone		NOT NULL,
    id_bien_comun 				integer						NOT NULL,
	CONSTRAINT 					dh_pkey						PRIMARY KEY (id),
	CONSTRAINT 					nit_pc_fkey					FOREIGN KEY (id_bien_comun)
        REFERENCES property."PROPIEDAD_COMUN" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
