package pjc.mt.gov.br.modules.principal.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.*;
import pjc.mt.gov.br.modules.principal.dto.DepartamentoDTO;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "departamento")
@SequenceGenerator(name = "departamento_seq_id", sequenceName = "departamento_seq_id", allocationSize = 1, initialValue = 1)
public class Departamento extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "departamento_seq_id")
    @Column(name = "departamento_id")
    private Long id;

    @Column(name = "dep_descricao", length = 150)
    private String depDescricao;

    @ManyToOne
    @JoinColumn(name = "ambiente_id")
    @JsonManagedReference
    private Ambiente ambiente;

    @OneToMany(mappedBy = "departamento")
    @JsonBackReference
    private List<Pergunta> perguntas;

    public Departamento departamentoDTOtoDepartamento(DepartamentoDTO departamentoDTO) {

        Departamento departamento = new Departamento();
        departamento.getAmbiente().setId(departamentoDTO.getAmbiente().getId().longValue());
        departamento.setDepDescricao(departamentoDTO.getDescricao());
        return departamento;

    }

}
