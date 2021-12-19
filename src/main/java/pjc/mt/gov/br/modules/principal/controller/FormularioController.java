package pjc.mt.gov.br.modules.principal.controller;

import pjc.mt.gov.br.modules.principal.dto.FormularioPjcNovoDTO;
import pjc.mt.gov.br.modules.principal.model.FormularioPjc;
import pjc.mt.gov.br.modules.principal.service.FormularioPjcService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import java.util.List;

@Path("/formularios")
public class FormularioController {

    @Inject
    FormularioPjcService formularioPjcService;

    @GET
    public List<FormularioPjc> list() {
        return FormularioPjc.listAll();
    }

    @POST
    @Transactional
    public FormularioPjc adiciona(FormularioPjcNovoDTO dto) {
        return formularioPjcService.salvar(dto);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        formularioPjcService.excluir(id);
    }

}
