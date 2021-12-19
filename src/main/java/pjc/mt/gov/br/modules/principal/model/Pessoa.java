package pjc.mt.gov.br.modules.principal.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "pessoa")
@SequenceGenerator(name = "pessoa_seq_id", sequenceName = "pessoa_seq_id", allocationSize = 1, initialValue = 1)
public class Pessoa extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "pessoa_seq_id")
    @Column(name = "pes_id")
    private Long id;

    @Column(name = "pes_nome", length = 200)
    private String nome;

    @Column(name = "pes_matricula", length = 200)
    private Integer matricula;

    @Column(name = "pes_unidade", length = 200)
    private String unidade;

    @OneToMany(mappedBy = "pessoa")
    @JsonBackReference
    private List<Resposta> respostas;

}
