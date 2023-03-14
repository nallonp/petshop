package com.nallon.petshop.dto;

import com.nallon.petshop.domain.Pessoa;
import java.io.Serial;
import java.io.Serializable;

public class PessoaDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private String nome;
  private String email;
  private String codNacional;

  public PessoaDTO() {
  }

  public PessoaDTO(Pessoa obj) {
    this.nome = obj.getNome();
    this.email = obj.getEmail();
    this.codNacional = obj.getCodNacional();
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCodNacional() {
    return codNacional;
  }

  public void setCodNacional(String codNacional) {
    this.codNacional = codNacional;
  }
}
