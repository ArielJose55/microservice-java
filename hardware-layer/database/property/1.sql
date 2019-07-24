--------------------------------------------------
----------- TABLA PROPIEDAD HORIZONTAL -----------
--------------------------------------------------


-- DROP SEQUENCE property."PROPIEDAD_HORIZONTAL_id_seq";

CREATE TABLE property."PROPIEDAD_HORIZONTAL"
(
    id 			bigint 			NOT NULL,
    nit 		character varying  	NOT NULL		UNIQUE,
    nombre_distintivo 	character varying	NOT NULL,
    CONSTRAINT 		ph_pkey			PRIMARY	KEY (id)
);
