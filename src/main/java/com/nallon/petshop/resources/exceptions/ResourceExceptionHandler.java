package com.nallon.petshop.resources.exceptions;

import com.nallon.petshop.service.exceptions.DataIntegrityException;
import com.nallon.petshop.service.exceptions.ObjetoNaoEncontradoException;
import java.io.Serial;
import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @ExceptionHandler(ObjetoNaoEncontradoException.class)
  public ResponseEntity<StandardError> objectNotFound(ObjetoNaoEncontradoException exception,
      HttpServletRequest request) {
    StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(DataIntegrityException.class)
  public ResponseEntity<StandardError> objectNotFound(DataIntegrityException exception,
      HttpServletRequest request) {
    StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }
}
