package com.nallon.petshop.dto;

import com.nallon.petshop.domain.Servico;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class ServicoDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private Integer id;
  private Date dataEntrada;
  private Date dataSaida;
  private String descricaoServico;
  private String cliente;
  private String funcionario;
  private String pet;

  public ServicoDTO() {
  }

  public ServicoDTO(Servico obj) {
    this.id = obj.getId();
    this.dataEntrada = obj.getDataEntrada();
    this.dataSaida = obj.getDataSaida();
    this.descricaoServico = obj.getDescricaoServico();
    this.cliente = obj.getCliente().getNome();
    this.funcionario = obj.getFuncionario().getNome();
    this.pet = obj.getPet().getNome();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getDataEntrada() {
    return dataEntrada;
  }

  public void setDataEntrada(Date dataEntrada) {
    this.dataEntrada = dataEntrada;
  }

  public Date getDataSaida() {
    return dataSaida;
  }

  public void setDataSaida(Date dataSaida) {
    this.dataSaida = dataSaida;
  }

  public String getDescricaoServico() {
    return descricaoServico;
  }

  public void setDescricaoServico(String descricaoServico) {
    this.descricaoServico = descricaoServico;
  }

  public String getCliente() {
    return cliente;
  }

  public void setCliente(String cliente) {
    this.cliente = cliente;
  }

  public String getFuncionario() {
    return funcionario;
  }

  public void setFuncionario(String funcionario) {
    this.funcionario = funcionario;
  }

  public String getPet() {
    return pet;
  }

  public void setPet(String pet) {
    this.pet = pet;
  }
}