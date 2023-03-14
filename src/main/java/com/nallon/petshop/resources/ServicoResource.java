package com.nallon.petshop.resources;

import com.nallon.petshop.domain.Servico;
import com.nallon.petshop.service.ServicoService;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

  @PostMapping
  public ResponseEntity<?> insert(@RequestBody Servico obj) {
    Servico servico = service.insert(obj);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
    return ResponseEntity.created(uri).body(servico);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> update(@RequestBody Servico obj, @PathVariable Integer id) {
    obj.setId(id);
    service.update(obj);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Integer id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
