package pjc.mt.gov.br.modules.principal.controller;

import pjc.mt.gov.br.modules.principal.dto.AlternativaNovoDTO;
import pjc.mt.gov.br.modules.principal.model.Alternativa;
import pjc.mt.gov.br.modules.principal.service.AlternativaService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import java.util.List;

@Path("/alternativas")
public class AlternativaController {

    @Inject
    AlternativaService alternativaService;

    @GET
    public List<Alternativa> list() {
        return Alternativa.listAll();
    }

    @POST
    @Transactional
    public Alternativa adiciona(AlternativaNovoDTO dto) {
        return alternativaService.salvar(dto);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        alternativaService.excluir(id);
    }
}
