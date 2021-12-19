package pjc.mt.gov.br.modules.principal.dto;

import lombok.Data;
import pjc.mt.gov.br.modules.principal.model.Alternativa;
import pjc.mt.gov.br.modules.principal.model.Departamento;
import pjc.mt.gov.br.modules.principal.model.FormularioPjc;
import pjc.mt.gov.br.modules.principal.model.Pergunta;

import java.util.ArrayList;
import java.util.List;

@Data
public class PerguntaNovoDTO {

    private String descricao;
    private Long departamentId;
    private Long formularioId;
    private Long[] alternativasId;

    public Pergunta toModel() {

        Pergunta pergunta = new Pergunta();
        pergunta.setPergDescricao(descricao);

        Departamento departamento = Departamento.findById(departamentId);
        pergunta.setDepartamento(departamento);

        FormularioPjc formularioPjc = FormularioPjc.findById(formularioId);
        pergunta.setFormularioPjc(formularioPjc);

        List<Alternativa> alternativas = new ArrayList<>();
        for (Long alternativaId : alternativasId) {
             Alternativa alternativa = Alternativa.findById(alternativaId);
            alternativas.add(alternativa);
        }
        pergunta.setAlternativas(alternativas);

        return pergunta;
    }

}
