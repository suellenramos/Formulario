package pjc.mt.gov.br.modules.principal.service;

import pjc.mt.gov.br.modules.principal.dto.DepartamentoDTO;
import pjc.mt.gov.br.modules.principal.dto.DepartamentoNovoDTO;
import pjc.mt.gov.br.modules.principal.exception.NotFoundException;
import pjc.mt.gov.br.modules.principal.model.Departamento;
import pjc.mt.gov.br.modules.principal.repository.DepartamentoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class DepartamentoService {

    private static final String DEPARTAMENTO_NAO_ENCONTRADO = "Departamento não encontrado";

    @Inject
    DepartamentoRepository repository;

    @Transactional
    public Departamento salvar(DepartamentoNovoDTO dto) {
        var departamento  = dto.toModel();
        repository.persist(departamento);
        return departamento;
    }
    @Transactional
    public List<DepartamentoDTO> listar() {
        return repository.findAll().project(DepartamentoDTO.class).list();
    }
    @Transactional
    public void editar(Long id, DepartamentoNovoDTO dto) {
        var departamento = repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException(DEPARTAMENTO_NAO_ENCONTRADO));
        departamento.setDepDescricao(dto.getDescricao());
        repository.persist(departamento);
    }

    @Transactional
    public void excluir(Long id) {
        var departamento = repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException(DEPARTAMENTO_NAO_ENCONTRADO));
        repository.delete(departamento);
    }

}
