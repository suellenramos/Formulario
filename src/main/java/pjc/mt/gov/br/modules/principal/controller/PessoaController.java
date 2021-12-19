package pjc.mt.gov.br.modules.principal.controller;

import pjc.mt.gov.br.modules.principal.dto.PessoaNovoDTO;

import pjc.mt.gov.br.modules.principal.model.Pessoa;
import pjc.mt.gov.br.modules.principal.service.PessoaService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import java.util.List;

@Path("/pessoas")
public class PessoaController {

    @Inject
    PessoaService pessoaService;

    @GET
    public List<Pessoa> list() {
        return Pessoa.listAll();
    }

    @POST
    @Transactional
    public Pessoa adiciona(PessoaNovoDTO dto) {
        return pessoaService.salvar(dto);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        pessoaService.excluir(id);
    }

}
