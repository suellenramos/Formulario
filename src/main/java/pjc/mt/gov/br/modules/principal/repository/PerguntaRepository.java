package pjc.mt.gov.br.modules.principal.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import pjc.mt.gov.br.modules.principal.model.Pergunta;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PerguntaRepository implements PanacheRepository<Pergunta> {

}
