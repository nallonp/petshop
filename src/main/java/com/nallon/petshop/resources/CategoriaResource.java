package com.nallon.petshop.resources;

import com.nallon.petshop.domain.Categoria;
import com.nallon.petshop.dto.CategoriaDTO;
import com.nallon.petshop.service.CategoriaService;
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
@RequestMapping("/categorias")
public class CategoriaResource {

  @Autowired
  private CategoriaService service;

  @GetMapping("/{id}")
  public ResponseEntity<?> find(@PathVariable Integer id) {
    Categoria categoria = service.find(id);
    return ResponseEntity.ok().body(categoria);
  }

  @PostMapping
  public ResponseEntity<?> insert(@RequestBody Categoria obj) {
    Categoria categoria = service.insert(obj);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
    return ResponseEntity.created(uri).body(categoria);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> update(@RequestBody Categoria obj, @PathVariable Integer id) {
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
  public ResponseEntity<List<CategoriaDTO>> findAll() {
    List<Categoria> list = service.findAll();
    List<CategoriaDTO> dtoList = list.stream().map(CategoriaDTO::new).collect(Collectors.toList());
    return ResponseEntity.ok().body(dtoList);
  }
}
