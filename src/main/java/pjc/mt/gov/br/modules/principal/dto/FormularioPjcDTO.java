package pjc.mt.gov.br.modules.principal.dto;

import lombok.Data;

@Data
public class FormularioPjcDTO {
    private Long id;
    private String nome;
    private AmbienteDTO ambiente;

}
