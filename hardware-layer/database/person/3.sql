--------------------------------------------------
-------------------- TABLA PERSONA_JURIDICA  --------------
--------------------------------------------------

-- DROP TABLE public."PERSONA_JURIDICA";

CREATE TABLE person."PERSONA_JURIDICA"
(
    nit 			varchar				NOT NULL,
    razon_social	varchar				NOT NULL,
    objeto_social	varchar				NOT NULL,
    CONSTRAINT 		pj_pkey				PRIMARY KEY (nit)
);