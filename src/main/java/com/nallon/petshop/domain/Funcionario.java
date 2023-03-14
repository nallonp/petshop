package com.nallon.petshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(schema = "petshop")
public class Funcionario extends Pessoa {

  @Serial
  private static final long serialVersionUID = 1L;

  private String funcao;

  @JsonIgnore
  @OneToMany(mappedBy = "funcionario")
  private List<Servico> servicos = new ArrayList<>();

  public Funcionario() {
  }

  public Funcionario(Integer id, String nome, String email, String codNacional, String funcao) {
    super(id, nome, email, codNacional);
    this.funcao = funcao;
  }

  public String getFuncao() {
    return funcao;
  }

  public void setFuncao(String funcao) {
    this.funcao = funcao;
  }

  public List<Servico> getServicos() {
    return servicos;
  }

  public void setServicos(List<Servico> servicos) {
    this.servicos = servicos;
  }
}
