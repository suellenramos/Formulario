package pjc.mt.gov.br.modules.principal.dto;

import lombok.Data;

@Data
public class PerguntaDTO {
    private Long id;
    private String descricao;
    private DepartamentoDTO departamento;
    private FormularioPjcDTO formularioPjc;

}
