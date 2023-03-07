package com.nallon.petshop.service.exceptions;

import java.io.Serial;

public class ObjetoNaoEncontradoException extends RuntimeException {

  @Serial
  private static final long serialVersionUID = 1L;

  public ObjetoNaoEncontradoException(String msg) {
    super(msg);
  }

  public ObjetoNaoEncontradoException(String msg, Throwable cause) {
    super(msg, cause);
  }
}
