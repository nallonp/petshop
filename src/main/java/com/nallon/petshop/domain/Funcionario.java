package com.nallon.petshop.domain;

import java.io.Serial;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Funcionario extends Pessoa {

  @Serial
  private static final long serialVersionUID = 1L;

  private String funcao;

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
}
