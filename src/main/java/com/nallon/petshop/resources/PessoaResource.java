package com.nallon.petshop.resources;

import com.nallon.petshop.domain.Pessoa;
import com.nallon.petshop.dto.PessoaDTO;
import com.nallon.petshop.service.PessoaService;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
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
@RequestMapping("/pessoas")
public class PessoaResource {

  @Autowired
  private PessoaService service;

  @GetMapping("/{id}")
  public ResponseEntity<?> find(@PathVariable Integer id) {
    Pessoa pessoa = service.find(id);
    return ResponseEntity.ok().body(pessoa);
  }

  @PostMapping
  public ResponseEntity<?> insert(@RequestBody Pessoa obj) {
    Pessoa pessoa = service.insert(obj);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
    return ResponseEntity.created(uri).body(pessoa);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> update(@RequestBody Pessoa obj, @PathVariable Integer id) {
    obj.setId(id);
    service.update(obj);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Integer id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping
  public ResponseEntity<List<PessoaDTO>> findAll() {
    List<Pessoa> list = service.findAll();
    List<PessoaDTO> dtoList = list.stream().map(PessoaDTO::new).collect(Collectors.toList());
    return ResponseEntity.ok().body(dtoList);
  }
}
