package pjc.mt.gov.br.modules.principal.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.*;
import pjc.mt.gov.br.modules.principal.dto.PerguntaDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name = "pergunta")
@SequenceGenerator(name = "pergunta_seq_id", sequenceName = "pergunta_seq_id", allocationSize = 1, initialValue = 1)
public class Pergunta extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "pergunta_seq_id")
    @Column(name = "pergunta_id")
    private Long id;

    @Column(name = "perg_descricao", length = 500)
    private String pergDescricao;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    @JsonManagedReference
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "formulario_pjc_id")
    @JsonManagedReference
    private FormularioPjc formularioPjc;

    @ManyToMany
    @JoinTable(name = "pergun_alternativa",
            joinColumns = @JoinColumn(name = "pergunta_id"),
            inverseJoinColumns = @JoinColumn(name = "alternativa_id"))
    @JsonManagedReference
    private List<Alternativa> alternativas;

    public List<Pergunta> perguntaDTOtoPergunta(PerguntaDTO perguntaDTO) {

        List<Pergunta> perguntas = new ArrayList<>();

        Pergunta pergunta = new Pergunta();
        pergunta.getDepartamento().setId(perguntaDTO.getDepartamento().getId().longValue());
        pergunta.setPergDescricao(perguntaDTO.getDescricao());
        perguntas.add(pergunta);

        Pergunta pergunta1 = new Pergunta();
        pergunta1.getFormularioPjc().setId(perguntaDTO.getFormularioPjc().getId().longValue());
        pergunta1.setPergDescricao(perguntaDTO.getDescricao());
        perguntas.add(pergunta1);

        return perguntas;
    }
}
