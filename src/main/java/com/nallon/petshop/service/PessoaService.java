package com.nallon.petshop.service;

import com.nallon.petshop.domain.Pessoa;
import com.nallon.petshop.repository.PessoaRepository;
import com.nallon.petshop.service.exceptions.ObjetoNaoEncontradoException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

  @Autowired
  private PessoaRepository repo;

  public Pessoa find(Integer id) {
    Optional<Pessoa> obj = repo.findById(id);
    return obj.orElseThrow(() -> new ObjetoNaoEncontradoException(
        "Categoria não encontrada -> ID: " + id + ", Tipo: " + obj.getClass().getSimpleName()));
  }
}
