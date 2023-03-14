package com.nallon.petshop.service;

import com.nallon.petshop.domain.Categoria;
import com.nallon.petshop.repository.CategoriaRepository;
import com.nallon.petshop.service.exceptions.DataIntegrityException;
import com.nallon.petshop.service.exceptions.ObjetoNaoEncontradoException;
import java.util.List;
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
        "Objeto não encontrado -> ID: " + id + ", Tipo: " + Categoria.class.getSimpleName()));
  }

  public Categoria insert(Categoria obj) {
    return repo.save(obj);
  }

  public void update(Categoria obj) {
    find(obj.getId());
    repo.save(obj);
  }

  public void delete(Integer id) {
    find(id);
    try {
      repo.deleteById(id);
    } catch (Exception e) {
      throw new DataIntegrityException("Categoria possui produtos. Não é possível deletar.");
    }
  }

  public List<Categoria> findAll() {
    return repo.findAll();
  }
}
