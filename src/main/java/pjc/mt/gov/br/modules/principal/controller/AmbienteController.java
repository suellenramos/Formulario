package pjc.mt.gov.br.modules.principal.controller;

import pjc.mt.gov.br.modules.principal.dto.AmbienteNovoDTO;
import pjc.mt.gov.br.modules.principal.model.Ambiente;
import pjc.mt.gov.br.modules.principal.service.AmbienteService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import java.util.List;

@Path("/ambientes")
public class AmbienteController {

    @Inject
    AmbienteService ambienteService;

    @GET
    public List<Ambiente> list() {
        return Ambiente.listAll();
    }

    @POST
    @Transactional
    public Ambiente adiciona(AmbienteNovoDTO dto) {
        return ambienteService.salvar(dto);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        ambienteService.excluir(id);
    }
}
