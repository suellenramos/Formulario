package pjc.mt.gov.br.modules.principal.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import pjc.mt.gov.br.modules.principal.model.FormularioPjc;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FormularioPjcRepository implements PanacheRepository<FormularioPjc> {

}


