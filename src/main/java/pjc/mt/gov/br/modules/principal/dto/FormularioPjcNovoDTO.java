package pjc.mt.gov.br.modules.principal.dto;

import lombok.Data;
import pjc.mt.gov.br.modules.principal.model.Ambiente;
import pjc.mt.gov.br.modules.principal.model.FormularioPjc;

@Data
public class FormularioPjcNovoDTO {

    private String nome;
    private AmbienteDTO ambienteDTO;

    public FormularioPjc toModel(){
        var formularioPjc = new FormularioPjc();
        formularioPjc.setNome(nome);

        var ambiente = new Ambiente();
        ambiente.setId(ambienteDTO.getId());
        formularioPjc.setAmbiente(ambiente);
        return formularioPjc;

    }


}



