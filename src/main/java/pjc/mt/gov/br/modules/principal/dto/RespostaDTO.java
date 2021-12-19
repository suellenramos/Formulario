package pjc.mt.gov.br.modules.principal.dto;


import lombok.Data;

@Data
public class RespostaDTO {
    private Long id;
    private Boolean resposta;
    private AlternativaDTO alternativa;
    private FormularioPjcDTO formularioPjc;
    private PessoaDTO pessoa;



}
