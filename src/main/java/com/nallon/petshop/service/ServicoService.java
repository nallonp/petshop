package com.nallon.petshop.service;

import com.nallon.petshop.domain.Servico;
import com.nallon.petshop.repository.ServicoRepository;
import com.nallon.petshop.service.exceptions.ObjetoNaoEncontradoException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoService {

  @Autowired
  private ServicoRepository repo;

  public Servico find(Integer id) {
    Optional<Servico> obj = repo.findById(id);
    return obj.orElseThrow(() -> new ObjetoNaoEncontradoException(
        "Categoria não encontrada -> ID: " + id + ", Tipo: " + obj.getClass().getSimpleName()));
  }
}
