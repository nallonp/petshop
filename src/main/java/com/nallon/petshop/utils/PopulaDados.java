package com.nallon.petshop.utils;

import com.nallon.petshop.domain.Categoria;
import com.nallon.petshop.domain.Cidade;
import com.nallon.petshop.domain.Cliente;
import com.nallon.petshop.domain.Endereco;
import com.nallon.petshop.domain.Especie;
import com.nallon.petshop.domain.Estado;
import com.nallon.petshop.domain.Funcionario;
import com.nallon.petshop.domain.PagCartao;
import com.nallon.petshop.domain.PagDinheiro;
import com.nallon.petshop.domain.Pagamento;
import com.nallon.petshop.domain.Pet;
import com.nallon.petshop.domain.Produto;
import com.nallon.petshop.domain.Raca;
import com.nallon.petshop.domain.Servico;
import com.nallon.petshop.domain.enuns.SituacaoPagamento;
import com.nallon.petshop.repository.CategoriaRepository;
import com.nallon.petshop.repository.CidadeRepository;
import com.nallon.petshop.repository.EnderecoRepository;
import com.nallon.petshop.repository.EspecieRepository;
import com.nallon.petshop.repository.EstadoRepository;
import com.nallon.petshop.repository.PagamentoRepository;
import com.nallon.petshop.repository.PessoaRepository;
import com.nallon.petshop.repository.PetRepository;
import com.nallon.petshop.repository.ProdutoRepository;
import com.nallon.petshop.repository.RacaRepository;
import com.nallon.petshop.repository.ServicoRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
  @Autowired
  private PessoaRepository pessoaRepository;
  @Autowired
  private EnderecoRepository enderecoRepository;

  @Autowired
  private ServicoRepository servicoRepository;

  @Autowired
  private PagamentoRepository pagamentoRepository;

  @PostConstruct
  public void cadastrar() throws ParseException {
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

    Cliente clt1 = new Cliente(null, "Jose Maria", "jose@mail.com", "335.194.320-21", "FISICA");
    clt1.getTelefones().addAll(Arrays.asList("3516-2000", "9191-0000"));

    Funcionario fnc1 = new Funcionario(null, "Maria Jose", "maria@mail.com", "551.872.200.12", "ATENDENTE");
    fnc1.getTelefones().addAll(Arrays.asList("3279-0001", "9090-0002"));

    Endereco end1 = new Endereco(null, "Rua Tupis", "500", "Apto 101", "Pindorama", "30111222", c1, clt1);
    Endereco end2 = new Endereco(null, "Av. Tamoios", "100", "Casa", "Oca", "3968000", c2, fnc1);
    Endereco end3 = new Endereco(null, "Rua Aranãs", "10", "Apto 201", "Centro", "01153000", c3, fnc1);

    pessoaRepository.saveAll(Arrays.asList(clt1, fnc1));
    enderecoRepository.saveAll(Arrays.asList(end1, end2, end3));

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    Servico srv1 = new Servico(null, sdf.parse("02/09/2021 09:00"), sdf.parse("02/09/2021 21:00"), "Tosa", clt1, fnc1);
    Servico srv2 = new Servico(null, sdf.parse("03/09/2021 12:00"), sdf.parse("04/09/2021 12:00"), "Hospedagem", clt1,
        fnc1);

    Pagamento pgt1 = new PagCartao(null, 60.0, SituacaoPagamento.QUITADO, srv2, 6);
    srv2.setPagamento(pgt1);

    Pagamento pgt2 = new PagDinheiro(null, 100.0, SituacaoPagamento.PENDENTE, srv1, sdf.parse("02/09/2021 00:00"),
        null);
    srv1.setPagamento(pgt2);

    clt1.getServicos().addAll(Arrays.asList(srv1, srv2));
    fnc1.getServicos().addAll(Arrays.asList(srv1, srv2));

    servicoRepository.saveAll(Arrays.asList(srv1, srv2));
    pagamentoRepository.saveAll(Arrays.asList(pgt1, pgt2));
  }
}
