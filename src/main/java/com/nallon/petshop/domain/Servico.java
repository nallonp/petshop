package com.nallon.petshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Servico implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;
  @Id
  @JsonProperty(access = Access.READ_ONLY)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private Date dataEntrada;
  private Date dataSaida;
  private String descricaoServico;
  @OneToOne(mappedBy = "servico", cascade = CascadeType.ALL)
  private Pagamento pagamento;
  @ManyToOne
  @JoinColumn(name = "ID_CLIENTE")
  private Cliente cliente;
  @ManyToOne
  @JoinColumn(name = "ID_FUNCIONARIO")
  private Funcionario funcionario;
  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "ID_PET")
  private Pet pet;

  @ManyToMany
  @JoinTable(name = "SERVICO_PRODUTO",
      joinColumns = @JoinColumn(name = "ID_SERVICO"),
      inverseJoinColumns = @JoinColumn(name = "ID_PRODUTO"))
  private List<Produto> produtos = new ArrayList<>();

  public Servico() {
  }

  public Servico(Integer id, Date dataEntrada, Date dataSaida, String descricaoServico,
      Cliente cliente, Funcionario funcionario, Pet pet) {
    this.id = id;
    this.dataEntrada = dataEntrada;
    this.dataSaida = dataSaida;
    this.descricaoServico = descricaoServico;
    this.cliente = cliente;
    this.funcionario = funcionario;
    this.pet = pet;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Servico servico = (Servico) o;
    return Objects.equals(id, servico.id);
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

  public Date getDataEntrada() {
    return dataEntrada;
  }

  public void setDataEntrada(Date dataEntrada) {
    this.dataEntrada = dataEntrada;
  }

  public Date getDataSaida() {
    return dataSaida;
  }

  public void setDataSaida(Date dataSaida) {
    this.dataSaida = dataSaida;
  }

  public String getDescricaoServico() {
    return descricaoServico;
  }

  public void setDescricaoServico(String descricaoServico) {
    this.descricaoServico = descricaoServico;
  }

  public Pagamento getPagamento() {
    return pagamento;
  }

  public void setPagamento(Pagamento pagamento) {
    this.pagamento = pagamento;
  }

  public Pet getPet() {
    return pet;
  }

  public void setPet(Pet pet) {
    this.pet = pet;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Funcionario getFuncionario() {
    return funcionario;
  }

  public void setFuncionario(Funcionario funcionario) {
    this.funcionario = funcionario;
  }

  public List<Produto> getProdutos() {
    return produtos;
  }

  public void setProdutos(List<Produto> produtos) {
    this.produtos = produtos;
  }
}
