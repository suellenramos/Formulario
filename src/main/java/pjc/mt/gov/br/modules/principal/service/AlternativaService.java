package pjc.mt.gov.br.modules.principal.service;

import pjc.mt.gov.br.modules.principal.dto.AlternativaDTO;
import pjc.mt.gov.br.modules.principal.dto.AlternativaNovoDTO;
import pjc.mt.gov.br.modules.principal.exception.NotFoundException;
import pjc.mt.gov.br.modules.principal.model.Alternativa;
import pjc.mt.gov.br.modules.principal.repository.AlternativaRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class AlternativaService {

    private static final String ALTERNATIVA_NAO_ENCONTRADA = "Alternativa não encontrada";

    @Inject
    AlternativaRepository repository;

    @Transactional
    public Alternativa salvar(AlternativaNovoDTO dto) {
        var alternativa = dto.toModel();
        repository.persist(alternativa);
        return alternativa;

    }

    @Transactional
    public List<AlternativaDTO> listar() {
        return repository.findAll().project(AlternativaDTO.class).list();
    }

    @Transactional
    public void editar(Long id, AlternativaNovoDTO dto) {
        var alternativa = repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException(ALTERNATIVA_NAO_ENCONTRADA));
        alternativa.setAlterDescricao(dto.getDescricao());
        repository.persist(alternativa);

    }

    @Transactional
    public void excluir(Long id) {
        var alternativa = repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException(ALTERNATIVA_NAO_ENCONTRADA));
        repository.delete(alternativa);
    }
}
