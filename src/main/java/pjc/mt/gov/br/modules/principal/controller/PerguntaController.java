package pjc.mt.gov.br.modules.principal.controller;

import pjc.mt.gov.br.modules.principal.dto.PerguntaNovoDTO;
import pjc.mt.gov.br.modules.principal.model.Pergunta;
import pjc.mt.gov.br.modules.principal.service.PerguntaService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import java.util.List;

@Path("/perguntas")
public class PerguntaController {

    @Inject
    PerguntaService perguntaService;

    @GET
    public List<Pergunta> list() {
        return Pergunta.listAll();
    }

    @POST
    @Transactional
    public Pergunta adiciona(PerguntaNovoDTO dto) {
        return perguntaService.salvar(dto);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        perguntaService.excluir(id);
    }
}




