package pjc.mt.gov.br.modules.principal.service;

import pjc.mt.gov.br.modules.principal.dto.AmbienteNovoDTO;
import pjc.mt.gov.br.modules.principal.exception.NotFoundException;
import pjc.mt.gov.br.modules.principal.model.Ambiente;
import pjc.mt.gov.br.modules.principal.repository.AmbienteRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class AmbienteService {

    private static final String AMBIENTE_NAO_ENCONTRADO = "Ambiente não encontrado";

    @Inject
    AmbienteRepository repository;

    @Transactional
    public Ambiente salvar(AmbienteNovoDTO dto) {
        var ambiente = dto.toModel();
        repository.persist(ambiente);
        return ambiente;
    }

    @Transactional
    public void editar(Long id, AmbienteNovoDTO dto) {
        var ambiente = repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException(AMBIENTE_NAO_ENCONTRADO));
        ambiente.setAmbDescricao(dto.getDescricao());
        repository.persist(ambiente);
    }

    @Transactional
    public void excluir(Long id) {
        var ambiente = repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException(AMBIENTE_NAO_ENCONTRADO));
        repository.delete(ambiente);
    }

}
