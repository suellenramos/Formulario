package pjc.mt.gov.br.modules.principal.dto;

import lombok.Data;
import pjc.mt.gov.br.modules.principal.model.Alternativa;

@Data
public class AlternativaNovoDTO {

    private String descricao;

    public Alternativa toModel(){
        var alternativa = new Alternativa();
        alternativa.setAlterDescricao(descricao);
        return alternativa;
    }

}
