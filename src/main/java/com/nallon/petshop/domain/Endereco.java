package com.nallon.petshop.domain;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Endereco {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String logradouro;
  private String numero;
  private String complemento;
  private String bairro;
  private String cep;
  @ManyToOne
  @JoinColumn(name = "ID_CIDADE")
  private Cidade cidade;
  @ManyToOne
  @JoinColumn(name = "ID_PESSOA")
  private Pessoa pessoa;

  public Endereco() {
  }

  public Endereco(Integer id, String logradouro, String numero, String complemento, String bairro, String cep,
      Cidade cidade, Pessoa pessoa) {
    this.id = id;
    this.logradouro = logradouro;
    this.numero = numero;
    this.complemento = complemento;
    this.bairro = bairro;
    this.cep = cep;
    this.cidade = cidade;
    this.pessoa = pessoa;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Endereco endereco = (Endereco) o;
    return id.equals(endereco.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }


}
