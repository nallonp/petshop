package com.nallon.petshop.domain;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Servico implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @Id
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

  public Servico() {
  }

  public Servico(Integer id, Date dataEntrada, Date dataSaida, String descricaoServico,
      Cliente cliente, Funcionario funcionario) {
    this.id = id;
    this.dataEntrada = dataEntrada;
    this.dataSaida = dataSaida;
    this.descricaoServico = descricaoServico;
    this.cliente = cliente;
    this.funcionario = funcionario;
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
}
