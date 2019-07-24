--------------------------------------------------
-------------------- TABLA USUARIO  --------------
--------------------------------------------------

-- DROP TABLE person."USUARIO";

CREATE TABLE person."USUARIO"
(
	numero_identificacion	character varying			NOT NULL,
	tipo_identificacion 	character varying  			NOT NULL,
    username				character varying			NOT NULL,
    password				character varying			NOT NULL,
    fecha_registro 			timestamp without time zone NOT NULL 	DEFAULT now(),
    fecha_finalizacion		timestamp without time zone,    
    estado_usuario 			character varying 			NOT NULL,
    tipo_usuario			character varying 			NOT NULL,
    CONSTRAINT usuario_pk PRIMARY KEY (tipo_identificacion, numero_identificacion)
)