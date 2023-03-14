package com.nallon.petshop.resources;

import com.nallon.petshop.domain.Servico;
import com.nallon.petshop.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servicos")
public class ServicoResource {

  @Autowired
  private ServicoService service;

  @GetMapping("/{id}")
  public ResponseEntity<?> find(@PathVariable Integer id) {
    Servico servico = service.find(id);
    return ResponseEntity.ok().body(servico);
  }
}
