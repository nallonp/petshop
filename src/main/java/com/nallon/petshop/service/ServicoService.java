package com.nallon.petshop.service;

import com.nallon.petshop.domain.Servico;
import com.nallon.petshop.repository.ServicoRepository;
import com.nallon.petshop.service.exceptions.DataIntegrityException;
import com.nallon.petshop.service.exceptions.ObjetoNaoEncontradoException;
import java.util.List;
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
        "Serviço não encontrado -> ID: " + id + ", Tipo: " + Servico.class.getSimpleName()));
  }

  public Servico insert(Servico obj) {
    return repo.save(obj);
  }

  public void update(Servico obj) {
    find(obj.getId());
    repo.save(obj);
  }

  public void delete(Integer id) {
    find(id);
    try {
      repo.deleteById(id);
    } catch (Exception e) {
      throw new DataIntegrityException("Serviço não pode ser deletado.");
    }
  }

  public List<Servico> findAll() {
    return repo.findAll();
  }
}
