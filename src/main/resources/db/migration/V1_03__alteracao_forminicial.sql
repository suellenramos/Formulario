ALTER TABLE public.formulario_pjc DROP COLUMN pes_id;
ALTER TABLE public.formulario_pjc ADD ambiente_id int8 NOT NULL;
ALTER TABLE public.formulario_pjc ADD CONSTRAINT formulario_pjc_fk FOREIGN KEY (ambiente_id) REFERENCES public.ambiente(ambiente_id);

ALTER TABLE public.pergunta ADD formulario_pjc_id int8 NOT NULL;
ALTER TABLE public.pergunta ADD CONSTRAINT pergunta_fk FOREIGN KEY (formulario_pjc_id) REFERENCES public.formulario_pjc(formulario_pjc_id);

ALTER TABLE public.alternativa ADD pergunta_id int8 NOT NULL;
ALTER TABLE public.alternativa ADD resposta_id int8 NOT NULL;
ALTER TABLE public.alternativa ADD CONSTRAINT alternativa_fk FOREIGN KEY (pergunta_id) REFERENCES public.pergunta(pergunta_id);
ALTER TABLE public.alternativa ADD CONSTRAINT alternativa_fk_1 FOREIGN KEY (resposta_id) REFERENCES public.resposta(resposta_id);

ALTER TABLE public.resposta DROP COLUMN pergunta_id;
ALTER TABLE public.resposta ADD formulario_pjc_id int8 NOT NULL;
ALTER TABLE public.resposta ADD pes_id int8 NOT NULL;
ALTER TABLE public.resposta ADD CONSTRAINT resposta_fk FOREIGN KEY (pes_id) REFERENCES public.pessoa(pes_id);
ALTER TABLE public.resposta ADD CONSTRAINT resposta_fk_1 FOREIGN KEY (formulario_pjc_id) REFERENCES public.formulario_pjc(formulario_pjc_id);
ALTER TABLE public.resposta ADD CONSTRAINT resposta_fk_2 FOREIGN KEY (alternativa_id) REFERENCES public.alternativa(alternativa_id);




