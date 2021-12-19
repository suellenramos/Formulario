package pjc.mt.gov.br.modules.principal.service;

import pjc.mt.gov.br.modules.principal.dto.PessoaNovoDTO;
import pjc.mt.gov.br.modules.principal.exception.NotFoundException;
import pjc.mt.gov.br.modules.principal.model.Pessoa;
import pjc.mt.gov.br.modules.principal.repository.PessoaRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class PessoaService {

    private static final String PESSOA_NAO_ENCONTRADA = "Pessoa não encontrada";

    @Inject
    PessoaRepository repository;

    @Transactional
    public Pessoa salvar(PessoaNovoDTO dto) {
        var pessoa = dto.toModel();
        repository.persist(pessoa);
        return pessoa;
    }

    @Transactional
    public void editar(Long id, PessoaNovoDTO dto) {
        var pessoa = repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException(PESSOA_NAO_ENCONTRADA));
        pessoa.setNome(dto.getNome());
        pessoa.setUnidade(dto.getUnidade());
        pessoa.setMatricula(dto.getMatricula());
        repository.persist(pessoa);
    }

    @Transactional
    public void excluir(Long id) {
        var pessoa = repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException(PESSOA_NAO_ENCONTRADA));
        repository.delete(pessoa);

    }

}
