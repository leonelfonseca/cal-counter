-- Table: public.product

-- DROP TABLE IF EXISTS public.product;

CREATE TABLE IF NOT EXISTS public.product
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name integer,
    calories integer,
    type character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT food_pkey PRIMARY KEY (id),
    CONSTRAINT unq_name UNIQUE (name)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.product
    OWNER to postgres;