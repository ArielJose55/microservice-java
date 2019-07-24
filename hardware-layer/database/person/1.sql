--------------------------------------------------
--------------- TABLA PERSONA_NATURAL  -----------
--------------------------------------------------

-- DROP TABLE person."PERSONA_NATURAL";

CREATE TABLE person."PERSONA_NATURAL" (
	numero_identificacion			varchar		NOT NULL,
	tipo_identificacion 			varchar		NOT NULL,
	primer_apellido				varchar		NOT NULL,
	primer_nombre				varchar		NOT NULL,
	segundo_nombre				varchar		NULL,
	segundo_apellido 			varchar		NOT NULL,
	CONSTRAINT persona_natural_pkey PRIMARY KEY (tipo_identificacion, numero_identificacion)
);

