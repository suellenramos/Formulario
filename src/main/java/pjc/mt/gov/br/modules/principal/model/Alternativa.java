package pjc.mt.gov.br.modules.principal.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "alternativa")
public class Alternativa extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "alternativa_seq_id")
    @SequenceGenerator(name = "alternativa_seq_id", sequenceName = "alternativa_seq_id", allocationSize = 1, initialValue = 1)
    @Column(name = "alternativa_id")
    private Long id;

    @Column(name = "alter_descricao", length = 500)
    private String alterDescricao;

    @OneToMany(mappedBy = "alternativa", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Resposta> respostas;

    @ManyToMany(mappedBy = "alternativas", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Pergunta> perguntas;

}

