package com.nallon.petshop.domain;

import com.nallon.petshop.domain.enuns.SituacaoPagamento;
import java.io.Serial;
import javax.persistence.Entity;

@Entity
public class PagCartao extends Pagamento {

  @Serial
  private static final long serialVersionUID = 1L;

  private Integer parcelas;

  public PagCartao() {
  }

  public PagCartao(Integer id, Double valor, SituacaoPagamento situacaoPagamento, Servico servico, Integer parcelas) {
    super(id, valor, situacaoPagamento, servico);
    this.parcelas = parcelas;
  }

  public Integer getParcelas() {
    return parcelas;
  }

  public void setParcelas(Integer parcelas) {
    this.parcelas = parcelas;
  }
}
