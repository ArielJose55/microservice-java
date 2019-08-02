--------------------------------------------------
---------------- TABLA RESERVA  ------------------
--------------------------------------------------

-- DROP SEQUENCE person."RESERVA_id_reserva_seq";
-- DROP TABLE person."PERSONA_JURIDICA";


CREATE SEQUENCE person."RESERVA_id_reserva_seq";

CREATE TABLE person."RESERVA"
(
    id_reserva 					bigint 							NOT NULL 			DEFAULT nextval('"person"."RESERVA_id_reserva_seq"'::regclass),
    descripcion 				varchar							NOT NULL,
    estado_reserva 				varchar							NOT NULL,
    fecha_inicio 				timestamp without time zone		NOT NULL,
    fecha_finalizacion 			timestamp without time zone		NOT NULL,
    bien_comun 					integer							NOT NULL,
	numero_identificacion		varchar							NOT NULL,
	tipo_identificacion 		varchar  						NOT NULL,
	CONSTRAINT 					r_pkey							PRIMARY KEY (id_reserva)
)