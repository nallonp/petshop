package com.nallon.petshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
  @JsonIgnore
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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getComplemento() {
    return complemento;
  }

  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public Cidade getCidade() {
    return cidade;
  }

  public void setCidade(Cidade cidade) {
    this.cidade = cidade;
  }

  public Pessoa getPessoa() {
    return pessoa;
  }

  public void setPessoa(Pessoa pessoa) {
    this.pessoa = pessoa;
  }
}
