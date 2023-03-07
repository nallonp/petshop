package com.nallon.petshop.resources;

import com.nallon.petshop.domain.Categoria;
import com.nallon.petshop.service.CategoriaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
