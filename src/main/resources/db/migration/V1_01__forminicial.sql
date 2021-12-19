CREATE TABLE public.alternativa (
	alternativa_id int8 NOT NULL,
	alter_descricao varchar(500) NOT NULL,
	CONSTRAINT alternativa_pk PRIMARY KEY (alternativa_id)
);

CREATE TABLE public.ambiente (
	ambiente_id int8 NOT NULL,
	amb_descricao varchar(150) NOT NULL,
	CONSTRAINT ambiente_pk PRIMARY KEY (ambiente_id)
);

CREATE TABLE public.pessoa (
	pes_id int8 NOT NULL,
	pes_nome varchar(200) NOT NULL,
	pes_matricula varchar(200) NOT NULL,
	pes_unidade varchar(200) NOT NULL,
	CONSTRAINT pessoa_pk PRIMARY KEY (pes_id)
);

CREATE TABLE public.departamento (
	departamento_id int8 NOT NULL,
	ambiente_id int8 NOT NULL,
	dep_descricao varchar(150) NOT NULL,
	CONSTRAINT departamento_pk PRIMARY KEY (departamento_id),
	CONSTRAINT ambiente_id_fk FOREIGN KEY (ambiente_id) REFERENCES ambiente(ambiente_id)
);

CREATE TABLE public.pergunta (
	pergunta_id int8 NOT NULL,
	departamento_id int8 NOT NULL,
	perg_descricao varchar(500) NOT NULL,
	CONSTRAINT pergunta_pk PRIMARY KEY (pergunta_id),
	CONSTRAINT departamento_fk FOREIGN KEY (departamento_id) REFERENCES departamento(departamento_id)
);

CREATE TABLE public.resposta (
	resposta_id int8 NOT NULL,
	pergunta_id int8 NOT NULL,
	alternativa_id int8 NOT NULL,
	resposta bool NULL,
	CONSTRAINT resposta_pk PRIMARY KEY (resposta_id),
	CONSTRAINT alternativa_fk FOREIGN KEY (alternativa_id) REFERENCES alternativa(alternativa_id),
	CONSTRAINT pergunta_fk FOREIGN KEY (pergunta_id) REFERENCES pergunta(pergunta_id)
);

CREATE TABLE public.formulario_pjc (
	formulario_pjc_id int8 NOT NULL,
	form_nome varchar(500) NOT NULL,
	resposta_id int8 NOT NULL,
	pes_id int8 NOT NULL,
	CONSTRAINT formulario_pjc_pk PRIMARY KEY (formulario_pjc_id),
	CONSTRAINT pessoa_id_fk FOREIGN KEY (pes_id) REFERENCES pessoa(pes_id),
	CONSTRAINT resposta_id_fk FOREIGN KEY (resposta_id) REFERENCES resposta(resposta_id)
);