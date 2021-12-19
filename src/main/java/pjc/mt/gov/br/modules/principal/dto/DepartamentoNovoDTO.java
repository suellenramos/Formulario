package pjc.mt.gov.br.modules.principal.dto;

import lombok.Data;
import pjc.mt.gov.br.modules.principal.model.Ambiente;
import pjc.mt.gov.br.modules.principal.model.Departamento;

@Data
public class DepartamentoNovoDTO {

    private String descricao;
    private AmbienteDTO ambienteDTO;

    public Departamento toModel() {
        var departamento = new Departamento();
        departamento.setDepDescricao(descricao);

        var ambiente = new  Ambiente();
        ambiente.setId(ambienteDTO.getId());
        departamento.setAmbiente(ambiente);
        return departamento;
    }

}
