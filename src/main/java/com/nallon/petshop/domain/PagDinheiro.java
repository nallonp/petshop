package com.nallon.petshop.domain;

import com.nallon.petshop.domain.enuns.SituacaoPagamento;
import java.io.Serial;
import java.util.Date;
import javax.persistence.Entity;

@Entity
public class PagDinheiro extends Pagamento {

  @Serial
  private static final long serialVersionUID = 1L;

  private Date dataPagamento;

  private Double desconto;

  public PagDinheiro() {
  }

  public PagDinheiro(Integer id, Double valor, SituacaoPagamento situacaoPagamento, Servico servico, Date dataPagamento,
      Double desconto) {
    super(id, valor, situacaoPagamento, servico);
    this.dataPagamento = dataPagamento;
    this.desconto = desconto;
  }

  public Date getDataPagamento() {
    return dataPagamento;
  }

  public void setDataPagamento(Date dataPagamento) {
    this.dataPagamento = dataPagamento;
  }

  public Double getDesconto() {
    return desconto;
  }

  public void setDesconto(Double desconto) {
    this.desconto = desconto;
  }
}
