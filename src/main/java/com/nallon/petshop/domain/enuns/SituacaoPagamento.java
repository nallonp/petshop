package com.nallon.petshop.domain.enuns;

public enum SituacaoPagamento {
  QUITADO(1, "Quitado"), CANCELADO(2, "Cancelado"), PENDENTE(3, "Pendente");
  private final int code;

  private final String descricao;

  SituacaoPagamento(int code, String descricao) {
    this.code = code;
    this.descricao = descricao;
  }

  public static SituacaoPagamento toEnum(Integer code) {
    if (code == null) {
      return null;
    }
    for (SituacaoPagamento situacaoPagamento : SituacaoPagamento.values()) {
      if (code.equals(situacaoPagamento.getCode())) {
        return situacaoPagamento;
      }
    }
    throw new IllegalArgumentException();
  }

  public int getCode() {
    return code;
  }

  public String getDescricao() {
    return descricao;
  }
}
