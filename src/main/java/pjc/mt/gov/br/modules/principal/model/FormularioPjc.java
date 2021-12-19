package pjc.mt.gov.br.modules.principal.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.*;
import pjc.mt.gov.br.modules.principal.dto.FormularioPjcDTO;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "formulario_pjc")
@SequenceGenerator(name = "formulario_pjc_seq_id", sequenceName = "formulario_pjc_seq_id")
public class FormularioPjc extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "formulario_pjc_seq_id")
    @Column(name = "formulario_pjc_id")
    private Long id;

    @Column(name = "form_nome")
    private String nome;

    @OneToMany(mappedBy = "formularioPjc")
    @JsonBackReference
    private List<Pergunta> perguntas;

    @OneToMany(mappedBy = "formularioPjc")
    @JsonBackReference
    private List<Resposta> respostas;

    @ManyToOne
    @JoinColumn(name = "ambiente_id")
    @JsonManagedReference
    private Ambiente ambiente;

    public FormularioPjc formularioPjcDTOtoFormulario(FormularioPjcDTO formularioPjcDTO) {
        FormularioPjc formularioPjc = new FormularioPjc();
        formularioPjc.getAmbiente().setId(formularioPjcDTO.getAmbiente().getId().longValue());
        formularioPjc.setNome(formularioPjc.getNome());
        return formularioPjc;

    }

}
