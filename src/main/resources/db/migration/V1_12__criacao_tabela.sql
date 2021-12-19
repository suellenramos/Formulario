CREATE TABLE pergun_alternativa(
pergunta_id int8 NOT NULL,
alternativa_id int8 NOT NULL,
FOREIGN KEY (pergunta_id) REFERENCES public.pergunta(pergunta_id),
FOREIGN KEY (alternativa_id) REFERENCES public.alternativa(alternativa_id)
);