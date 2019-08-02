--------------------------------------------------
--- TABLA GESTION DE LA PROPIEDAD HORIZONTAL -----
--------------------------------------------------


-- DROP TABLE property."GESTION_PROPIEDAD_HORIZONTAL";

CREATE TABLE property."GESTION_PROPIEDAD_HORIZONTAL"
(
    numero_identificacion			varchar						NOT NULL,
    tipo_identificacion				varchar						NOT NULL,
    nit_propiedad_horizontal 		varchar						NOT NULL,
    fecha_asignacion 				timestamp without time zone	NOT NULL		DEFAULT now(),
    CONSTRAINT 						gph_pkey 					PRIMARY KEY 	(nit_propiedad_horizontal, numero_identificacion, tipo_identificacion),
    CONSTRAINT 						ghp_nit_ph_fkey 			FOREIGN KEY 	(nit_propiedad_horizontal)
        REFERENCES property."PROPIEDAD_HORIZONTAL" (nit) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
