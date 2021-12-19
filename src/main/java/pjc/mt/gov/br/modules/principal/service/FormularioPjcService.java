package pjc.mt.gov.br.modules.principal.service;

import pjc.mt.gov.br.modules.principal.dto.FormularioPjcNovoDTO;
import pjc.mt.gov.br.modules.principal.exception.NotFoundException;
import pjc.mt.gov.br.modules.principal.model.FormularioPjc;
import pjc.mt.gov.br.modules.principal.repository.FormularioPjcRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class FormularioPjcService {

    private static final String FORMULARIO_NAO_ENCONTRADO = "Formulario nao encontrado";

    @Inject
    FormularioPjcRepository repository;

    @Transactional
    public FormularioPjc salvar(FormularioPjcNovoDTO dto) {
        var formularioPjc = dto.toModel();
        repository.persist(formularioPjc);
        return formularioPjc;
    }

    @Transactional
    public void editar(Long id, FormularioPjcNovoDTO dto) {
        var formularioPjc = repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException(FORMULARIO_NAO_ENCONTRADO));
        formularioPjc.setNome(dto.getNome());
        repository.persist(formularioPjc);
    }

    @Transactional
    public void excluir(Long id) {
        var formularioPjc = repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException(FORMULARIO_NAO_ENCONTRADO));
        repository.delete(formularioPjc);

    }

}


