package pjc.mt.gov.br.modules.principal.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.*;
import pjc.mt.gov.br.modules.principal.dto.AmbienteDTO;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "ambiente")
@SequenceGenerator(name = "ambiente_seq_id", sequenceName = "ambiente_seq_id", allocationSize = 1, initialValue = 1)
public class Ambiente extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "ambiente_seq_id")
    @Column(name = "ambiente_id")
    private Long id;

    @Column(name = "amb_descricao", length = 150)
    private String ambDescricao;

    @OneToMany(mappedBy = "ambiente")
    @JsonBackReference
    private List<FormularioPjc> formularioPjcs;

    @OneToMany(mappedBy = "ambiente")
    @JsonBackReference
    private List<Departamento> departamentos;

}
