--------------------------------------------------
-------------- TABLA DISPOSITIVO -----------------
--------------------------------------------------

-- DROP TABLE property."DISPOSITIVO";

CREATE TABLE property."DISPOSITIVO"
(
    serial				uuid				NOT NULL,
    nombre 				varchar				NOT NULL,
    tipo_dispositivo	varchar				NOT NULL,
    estado_dispositivo	varchar				NOT NULL,
    id_propiedad_comun	integer				NOT NULL,
    CONSTRAINT 			dispositivo_pkey 	PRIMARY KEY (serial),
    CONSTRAINT 			id_pc_fkey			FOREIGN KEY (id_propiedad_comun)
        REFERENCES property."PROPIEDAD_COMUN" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)