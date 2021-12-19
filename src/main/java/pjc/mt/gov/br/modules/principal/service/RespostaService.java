package pjc.mt.gov.br.modules.principal.service;

import pjc.mt.gov.br.modules.principal.dto.RespostaNovoDTO;
import pjc.mt.gov.br.modules.principal.exception.NotFoundException;
import pjc.mt.gov.br.modules.principal.model.Resposta;
import pjc.mt.gov.br.modules.principal.repository.RespostaRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class RespostaService {

    private static final String RESPOSTA_NAO_ENCONTRADA = "Resposta nao encontrada";

    @Inject
    RespostaRepository repository;

    @Transactional
    public List<Resposta> salvar(List<RespostaNovoDTO> listDTO) {
        var respostas = listDTO.stream().map(dto -> {
            var resposta = dto.toModel();
            repository.persist(resposta);
            return resposta;
        }).collect(Collectors.toList());

        return respostas;
    }

    @Transactional
    public void editar(Long id, RespostaNovoDTO dto) {
        var resposta = repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException(RESPOSTA_NAO_ENCONTRADA));
        resposta.setResposta(dto.isRespostaDaQuestao());
        repository.persist(resposta);
    }

    @Transactional
    public void excluir(Long id) {
        var resposta = repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException(RESPOSTA_NAO_ENCONTRADA));
        repository.delete(resposta);
    }

}
