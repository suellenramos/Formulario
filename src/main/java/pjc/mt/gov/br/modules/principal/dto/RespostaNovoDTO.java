package pjc.mt.gov.br.modules.principal.dto;

import lombok.Data;
import pjc.mt.gov.br.modules.principal.model.*;

@Data
public class RespostaNovoDTO {

    private boolean respostaDaQuestao;
    private Long alternativaId;
    private Long formularioId;
    private Long pessoaId;

    public Resposta toModel() {

        Resposta resposta = new Resposta();
        resposta.setResposta(respostaDaQuestao);

        Alternativa alternativa = Alternativa.findById(alternativaId);
        resposta.setAlternativa(alternativa);

        FormularioPjc formularioPjc = FormularioPjc.findById(formularioId);
        resposta.setFormularioPjc(formularioPjc);

        Pessoa pessoa = Pessoa.findById(pessoaId);
        resposta.setPessoa(pessoa);
        return resposta;

    }

}
