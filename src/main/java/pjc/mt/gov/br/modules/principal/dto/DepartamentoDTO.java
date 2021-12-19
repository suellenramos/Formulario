package pjc.mt.gov.br.modules.principal.dto;

import lombok.Data;

@Data
public class DepartamentoDTO {

    private Long id;
    private String descricao;
    private AmbienteDTO ambiente;
}
