ALTER TABLE public.pergun_alternativa ADD pergunta_id int8 NOT NULL;
ALTER TABLE public.pergun_alternativa ADD alternativa_id int8 NOT NULL;
ALTER TABLE public.pergun_alternativa ADD CONSTRAINT pergun_alternativa_fk FOREIGN KEY (pergunta_id) REFERENCES public.pergunta(pergunta_id);
ALTER TABLE public.pergun_alternativa ADD CONSTRAINT pergun_alternativa_fk_1 FOREIGN KEY (alternativa_id) REFERENCES public.alternativa(alternativa_id);
