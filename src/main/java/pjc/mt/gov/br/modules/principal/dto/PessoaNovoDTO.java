package pjc.mt.gov.br.modules.principal.dto;

import lombok.Data;
import pjc.mt.gov.br.modules.principal.model.Pessoa;

@Data
public class PessoaNovoDTO {

    private String nome;
    private Integer matricula;
    private String unidade;

    public Pessoa toModel() {
        var pessoa = new Pessoa();
        pessoa.setNome(nome);
        pessoa.setMatricula(matricula);
        pessoa.setUnidade(unidade);
        return pessoa;
    }
}