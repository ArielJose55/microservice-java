--------------------------------------------------
------------------ TABLA RESIDENTE  --------------
--------------------------------------------------

-- DROP TABLE person."RESIDENTE";

CREATE TABLE person."RESIDENTE"
(
	numero_identificacion			varchar				NOT NULL,
	tipo_identificacion 			varchar	  			NOT NULL,
	plantilla_huella				varchar				NOT NULL 			UNIQUE,
	codigo_seguridad				varchar				NOT	NULL,
	titular							boolean				NOT NULL			DEFAULT false,
	CONSTRAINT persona_residente_pk PRIMARY KEY (tipo_identificacion, numero_identificacion)
)