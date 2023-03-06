package com.nallon.petshop.resources;

import com.nallon.petshop.domain.Categoria;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

  @RequestMapping(method = RequestMethod.GET)
  public List<Categoria> mostrar() {
    Categoria cat1 = new Categoria(1, "Alimento");
    Categoria cat2 = new Categoria(2, "Cosmético");
    Categoria cat3 = new Categoria(3, "Remédio");
    List<Categoria> categorias= new ArrayList<>();
    categorias.add(cat1);
    categorias.add(cat2);
    categorias.add(cat3);
    return categorias;
  }
}
