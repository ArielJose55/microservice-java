--------------------------------------------------
----------- TABLA PROPIEDAD HORIZONTAL -----------
--------------------------------------------------


-- DROP SEQUENCE property."PROPIEDAD_HORIZONTAL_id_seq";
-- DROP TABLE property."PROPIEDAD_HORIZONTAL";

CREATE SEQUENCE property."PROPIEDAD_HORIZONTAL_id_seq";

CREATE TABLE property."PROPIEDAD_HORIZONTAL"
(
    id 					bigint 			NOT NULL 		DEFAULT nextval('"property"."PROPIEDAD_HORIZONTAL_id_seq"'::regclass),
    nit 				varchar  		NOT NULL		UNIQUE,
    nombre_distintivo 	varchar			NOT NULL,
    CONSTRAINT 			ph_pkey			PRIMARY	KEY (id)
);
