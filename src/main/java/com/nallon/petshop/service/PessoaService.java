package com.nallon.petshop.service;

import com.nallon.petshop.domain.Pessoa;
import com.nallon.petshop.repository.PessoaRepository;
import com.nallon.petshop.service.exceptions.DataIntegrityException;
import com.nallon.petshop.service.exceptions.ObjetoNaoEncontradoException;
import java.util.List;
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
        "Pessoa não encontrada -> ID: " + id + ", Tipo: " + Pessoa.class.getSimpleName()));
  }

  public Pessoa insert(Pessoa obj) {
    return repo.save(obj);
  }

  public void update(Pessoa obj) {
    find(obj.getId());
    repo.save(obj);
  }

  public void delete(Integer id) {
    find(id);
    try {
      repo.deleteById(id);
    } catch (Exception e) {
      throw new DataIntegrityException("Pessoa não pode ser deletada.");
    }
  }

  public List<Pessoa> findAll() {
    return repo.findAll();
  }
}
