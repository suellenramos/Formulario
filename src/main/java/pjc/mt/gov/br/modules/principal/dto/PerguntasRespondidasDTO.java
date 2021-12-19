package pjc.mt.gov.br.modules.principal.dto;


import lombok.Data;

@Data
public class PerguntasRespondidasDTO {

    private Long id;
    private  RespostaDTO  respostaDTO;
    private  PerguntaDTO perguntaDTO;

    public PerguntasRespondidasDTO toModel() {
        var perguntasRespondidas = new PerguntasRespondidasDTO();
        perguntasRespondidas.setId(id);
        return perguntasRespondidas;

    }


}
