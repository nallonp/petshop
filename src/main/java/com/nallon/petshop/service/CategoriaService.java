package com.nallon.petshop.service;

import com.nallon.petshop.domain.Categoria;
import com.nallon.petshop.repository.CategoriaRepository;
import com.nallon.petshop.service.exceptions.ObjetoNaoEncontradoException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

  @Autowired
  private CategoriaRepository repo;

  public Categoria find(Integer id) {
    Optional<Categoria> obj = repo.findById(id);
    return obj.orElseThrow(() -> new ObjetoNaoEncontradoException(
        "Categoria não encontrada -> ID: " + id + ", Tipo: " + Categoria.class.getSimpleName()));
  }
}
