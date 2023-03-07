package com.nallon.petshop.utils;

import com.nallon.petshop.domain.Categoria;
import com.nallon.petshop.repository.CategoriaRepository;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PopulaDados {

  @Autowired
  private CategoriaRepository categoriaRepository;

  @PostConstruct
  public void cadastrar(){
    Categoria cat1 = new Categoria(null, "Alimento");
    Categoria cat2 = new Categoria(null, "Cosmético");
    Categoria cat3 = new Categoria(null, "Remédio");
    List<Categoria> categorias = Arrays.asList(cat1, cat2, cat3);
    categoriaRepository.saveAll(categorias);
  }
}
