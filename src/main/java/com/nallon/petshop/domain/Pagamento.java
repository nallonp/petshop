package com.nallon.petshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nallon.petshop.domain.enuns.SituacaoPagamento;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(schema = "petshop")
public abstract class Pagamento implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;
  @Id
  private Integer id;
  private Double valor;
  private Integer situacaoPagamento;
  @JsonIgnore
  @OneToOne
  @JoinColumn(name = "id_servico")
  @MapsId
  private Servico servico;

  public Pagamento() {
  }

  public Pagamento(Integer id, Double valor, SituacaoPagamento situacaoPagamento, Servico servico) {
    this.id = id;
    this.valor = valor;
    this.situacaoPagamento = situacaoPagamento.getCode();
    this.servico = servico;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pagamento pagamento = (Pagamento) o;
    return Objects.equals(id, pagamento.id);
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

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public SituacaoPagamento getSituacaoPagamento() {
    return SituacaoPagamento.toEnum(this.situacaoPagamento);
  }

  public void setSituacaoPagamento(SituacaoPagamento situacaoPagamento) {
    this.situacaoPagamento = situacaoPagamento.getCode();
  }

  public Servico getServico() {
    return servico;
  }

  public void setServico(Servico servico) {
    this.servico = servico;
  }
}
