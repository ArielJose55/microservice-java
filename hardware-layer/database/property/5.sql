--------------------------------------------------
------- TABLA GESTION PROPIEDAD PRIVADA --- ------
--------------------------------------------------

-- DROP TABLE property."GESTION_PROPIEDAD_PRIVADA";

CREATE TABLE property."GESTION_PROPIEDAD_PRIVADA"
(
    numero_identificacion				varchar							NOT NULL,
    tipo_identificacion					varchar							NOT NULL,
    id_propiedad_privada				integer							NOT NULL,
    fecha_inicio						timestamp without time zone 	NOT NULL	DEFAULT now(),
	CONSTRAINT 							gpp_pkey 						PRIMARY KEY (id_propiedad_privada, numero_identificacion, tipo_identificacion),
    CONSTRAINT 							gpp_id_pp_fkey 					FOREIGN KEY (id_propiedad_privada)
        REFERENCES property."PROPIEDAD_COMUN" (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)