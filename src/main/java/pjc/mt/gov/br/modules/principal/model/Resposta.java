package pjc.mt.gov.br.modules.principal.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.*;
import pjc.mt.gov.br.modules.principal.dto.RespostaDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "resposta")
public class Resposta extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "resposta_seq_id", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "resposta_seq_id", sequenceName = " resposta_seq_id", allocationSize = 1, initialValue = 1)
    @Column(name = "resposta_id")
    private Long id;

    @Column(name = "resposta")
    private Boolean resposta;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "alternativa_id")
    @JsonManagedReference
    private Alternativa alternativa;

    @ManyToOne
    @JoinColumn(name = "formulario_pjc_id")
    @JsonManagedReference
    private FormularioPjc formularioPjc;

    @ManyToOne
    @JoinColumn(name = "pes_id")
    @JsonManagedReference
    private Pessoa pessoa;

    public List<Resposta> respostaDTOtoResposta(RespostaDTO respostaDTO) {

        List<Resposta> respostas = new ArrayList<>();
        Resposta resposta = new Resposta();
        resposta.getAlternativa().setId(respostaDTO.getAlternativa().getId().longValue());
        resposta.setResposta(respostaDTO.getResposta());
        respostas.add(resposta);

        Resposta resposta1 = new Resposta();
        resposta1.getFormularioPjc().setId(respostaDTO.getFormularioPjc().getId().longValue());
        resposta1.setResposta(respostaDTO.getResposta());
        respostas.add(resposta1);

        Resposta resposta2 = new Resposta();
        resposta2.getPessoa().setId(respostaDTO.getPessoa().getId().longValue());
        resposta2.setResposta(respostaDTO.getResposta());
        respostas.add(resposta2);
        return respostas;

    }

    public static List<Resposta> buscarResposta(List<Long> idsAlternativas) {
        return Resposta.find("alternativa.id in (?1)", idsAlternativas).list();
    }


}