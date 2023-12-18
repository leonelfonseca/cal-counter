-- Table: public.product_order

-- DROP TABLE IF EXISTS public.product_order;

CREATE TABLE IF NOT EXISTS public.product_order
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    order_id integer NOT NULL,
    product_id integer NOT NULL,
    CONSTRAINT food_order_pkey PRIMARY KEY (id),
    CONSTRAINT fk_order_id FOREIGN KEY (order_id)
        REFERENCES public."order" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE RESTRICT
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.product_order
    OWNER to postgres;