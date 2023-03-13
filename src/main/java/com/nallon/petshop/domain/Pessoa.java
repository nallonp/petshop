package com.nallon.petshop.domain;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;
  @OneToMany(mappedBy = "pessoa")
  private final List<Endereco> enderecos = new ArrayList<>();
  @ElementCollection
  @CollectionTable(name = "TELEFONE", joinColumns = @JoinColumn(name = "ID_PESSOA"))
  @Column(name = "NUMERO")
  private final Set<String> telefones = new HashSet<>();
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;
  private String email;
  private String codNacional;

  public Pessoa() {
  }

  public Pessoa(Integer id, String nome, String email, String codNacional) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.codNacional = codNacional;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pessoa pessoa = (Pessoa) o;
    return Objects.equals(id, pessoa.id);
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

  public List<Endereco> getEnderecos() {
    return enderecos;
  }

  public Set<String> getTelefones() {
    return telefones;
  }
}
