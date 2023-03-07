package com.nallon.petshop.utils;

import com.nallon.petshop.domain.Categoria;
import com.nallon.petshop.domain.Cidade;
import com.nallon.petshop.domain.Especie;
import com.nallon.petshop.domain.Estado;
import com.nallon.petshop.domain.Pet;
import com.nallon.petshop.domain.Produto;
import com.nallon.petshop.domain.Raca;
import com.nallon.petshop.repository.CategoriaRepository;
import com.nallon.petshop.repository.CidadeRepository;
import com.nallon.petshop.repository.EspecieRepository;
import com.nallon.petshop.repository.EstadoRepository;
import com.nallon.petshop.repository.PetRepository;
import com.nallon.petshop.repository.ProdutoRepository;
import com.nallon.petshop.repository.RacaRepository;
import java.util.Arrays;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PopulaDados {

  @Autowired
  private CategoriaRepository categoriaRepository;

  @Autowired
  private ProdutoRepository produtoRepository;
  @Autowired
  private EspecieRepository especieRepository;
  @Autowired
  private RacaRepository racaRepository;
  @Autowired
  private PetRepository petRepository;
  @Autowired
  private EstadoRepository estadoRepository;
  @Autowired
  private CidadeRepository cidadeRepository;

  @PostConstruct
  public void cadastrar() {
    Categoria cat1 = new Categoria(null, "Alimento");
    Categoria cat2 = new Categoria(null, "Remédio");
    Categoria cat3 = new Categoria(null, "Cosmético");

    Produto p1 = new Produto(null, "Ração", 100.0);
    Produto p2 = new Produto(null, "Sachê", 80.0);
    Produto p3 = new Produto(null, "Xampu", 50.0);
    Produto p4 = new Produto(null, "Vermífugo", 20.0);

    cat1.getProdutos().addAll(Arrays.asList(p1, p2));
    cat2.getProdutos().addAll(Arrays.asList(p3, p4));
    cat3.getProdutos().add(p3);

    p1.getCategorias().add(cat1);
    p2.getCategorias().add(cat1);
    p3.getCategorias().addAll(Arrays.asList(cat2, cat3));
    p4.getCategorias().add(cat2);
    categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
    produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));

    Especie especie1 = new Especie(null, "Cachorro");
    Especie especie2 = new Especie(null, "Gato");

    Raca raca1 = new Raca(null, "Shitzu");
    Raca raca2 = new Raca(null, "Akita");
    Raca raca3 = new Raca(null, "Persa");

    Pet pet1 = new Pet(null, "John", 6, especie1, raca1);
    Pet pet2 = new Pet(null, "Hanna", 5, especie1, raca2);
    Pet pet3 = new Pet(null, "Mewth", 8, especie2, raca3);

    especieRepository.saveAll(Arrays.asList(especie1, especie2));
    racaRepository.saveAll(Arrays.asList(raca1, raca2, raca3));
    petRepository.saveAll(Arrays.asList(pet1, pet2, pet3));

    Estado est1 = new Estado(null, "Minas Gerais");
    Estado est2 = new Estado(null, "São Paulo");

    Cidade c1 = new Cidade(null, "Belo Horizonte", est1);
    Cidade c2 = new Cidade(null, "Capelinha", est1);
    Cidade c3 = new Cidade(null, "São Paulo", est2);

    est1.getCidades().addAll(Arrays.asList(c1, c2));
    est2.getCidades().add(c3);
    
    estadoRepository.saveAll(Arrays.asList(est1, est2));
    cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
  }
}
