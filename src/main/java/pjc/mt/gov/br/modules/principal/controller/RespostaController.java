package pjc.mt.gov.br.modules.principal.controller;

import pjc.mt.gov.br.modules.principal.dto.RespostaNovoDTO;
import pjc.mt.gov.br.modules.principal.model.Pergunta;
import pjc.mt.gov.br.modules.principal.model.Resposta;
import pjc.mt.gov.br.modules.principal.service.RespostaService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import java.util.List;
import java.util.stream.Collectors;

@Path("/respostas")
public class RespostaController {

    @Inject
    RespostaService respostaService;

    @GET
    public List<Resposta> listar() {
        return Resposta.listAll();
    }


    @GET
    @Path("/por-pergunta/{perguntaId}")
    public List<Resposta> listarPorPerguntas(@PathParam("perguntaId") Long perguntaId) {
        Pergunta pergunta = Pergunta.findById(perguntaId);
        var idAlternativa = pergunta.getAlternativas()
                .stream().map(a -> a.getId()).collect(Collectors.toList());
        return Resposta.buscarResposta(idAlternativa);
    }

    @POST
    @Transactional
    public List<Resposta> adiciona(List<RespostaNovoDTO> listDTO) {
        return respostaService.salvar(listDTO);

    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        respostaService.excluir(id);
    }
}
