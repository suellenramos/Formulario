package pjc.mt.gov.br.modules.principal.service;

import pjc.mt.gov.br.modules.principal.dto.PerguntaNovoDTO;
import pjc.mt.gov.br.modules.principal.exception.NotFoundException;
import pjc.mt.gov.br.modules.principal.model.Pergunta;
import pjc.mt.gov.br.modules.principal.repository.PerguntaRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class PerguntaService {

    private static final String PERGUNTA_NAO_ENCONTRADA = "Pergunta não encontrada";

    @Inject
    PerguntaRepository repository;

    @Transactional
    public Pergunta salvar(PerguntaNovoDTO dto) {
        var pergunta = dto.toModel();
        repository.persist(pergunta);
        return pergunta;
    }

    @Transactional
    public void editar(Long id, PerguntaNovoDTO dto) {
        var pergunta = repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException(PERGUNTA_NAO_ENCONTRADA));
        pergunta.setPergDescricao(dto.getDescricao());
        repository.persist(pergunta);
    }

    @Transactional
    public void excluir(Long id) {
        var pergunta = repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException(PERGUNTA_NAO_ENCONTRADA));
        repository.delete(pergunta);

    }


}
