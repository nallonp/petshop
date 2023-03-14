package com.nallon.petshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Produto implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;
  private Double preco;
  @JsonIgnore
  @ManyToMany
  @JoinTable(name = "PRODUTO_CATEGORIA",
      joinColumns = @JoinColumn(name = "id_produto"),
      inverseJoinColumns = @JoinColumn(name = "id_categoria"))
  private List<Categoria> categorias = new ArrayList<>();
  @ManyToMany(mappedBy = "produtos")
  private List<Servico> servicos = new ArrayList<>();

  public Produto() {
  }

  public Produto(Integer id, String nome, Double preco) {
    this.id = id;
    this.nome = nome;
    this.preco = preco;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Produto produto = (Produto) o;
    return id.equals(produto.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, preco);
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

  public Double getPreco() {
    return preco;
  }

  public void setPreco(Double preco) {
    this.preco = preco;
  }

  public List<Categoria> getCategorias() {
    return categorias;
  }

  public void setCategorias(List<Categoria> categorias) {
    this.categorias = categorias;
  }

  public List<Servico> getServicos() {
    return servicos;
  }

  public void setServicos(List<Servico> servicos) {
    this.servicos = servicos;
  }
}
