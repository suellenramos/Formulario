package pjc.mt.gov.br.modules.principal.dto;

import lombok.Data;
import pjc.mt.gov.br.modules.principal.model.Ambiente;

@Data
public class AmbienteNovoDTO {

    private String descricao;

    public Ambiente toModel() {
        var ambiente = new Ambiente();
        ambiente.setAmbDescricao(descricao);
        return ambiente;
    }

}
