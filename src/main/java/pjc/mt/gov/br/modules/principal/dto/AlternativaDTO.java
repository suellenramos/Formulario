package pjc.mt.gov.br.modules.principal.dto;

import lombok.Data;
import pjc.mt.gov.br.modules.principal.model.Alternativa;

@Data
public class AlternativaDTO {

    private Long id;
    private String descricao;
    private PerguntaDTO pergunta;
    private RespostaDTO resposta;

    public Alternativa toModel() {
        var alternativa = new Alternativa();
        alternativa.setId(id);
        alternativa.setAlterDescricao(descricao);
        return alternativa;
    }
}
