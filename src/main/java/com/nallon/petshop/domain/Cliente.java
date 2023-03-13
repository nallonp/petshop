package com.nallon.petshop.domain;

import java.io.Serial;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Cliente extends Pessoa {

  @Serial
  private static final long serialVersionUID = 1L;

  private String tipo;

  public Cliente() {
  }

  public Cliente(Integer id, String nome, String email, String codNacional, String tipo) {
    super(id, nome, email, codNacional);
    this.tipo = tipo;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }
}
