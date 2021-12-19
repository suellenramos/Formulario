package pjc.mt.gov.br.modules.principal.controller;

import pjc.mt.gov.br.modules.principal.dto.DepartamentoNovoDTO;
import pjc.mt.gov.br.modules.principal.model.Departamento;
import pjc.mt.gov.br.modules.principal.service.DepartamentoService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import java.util.List;

@Path("/departamentos")
public class DepartamentoController {

    @Inject
    DepartamentoService departamentoService;

    @GET
    public List<Departamento> list(){
        return Departamento.listAll();
    }

    @POST
    @Transactional
    public Departamento adiciona(DepartamentoNovoDTO dto){
         return departamentoService.salvar(dto);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id){
        departamentoService.excluir(id);    }
}
