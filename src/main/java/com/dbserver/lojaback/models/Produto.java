package com.dbserver.lojaback.models;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PRODUTO")
@Getter
@Setter
public class Produto implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "NOME")
  @NotNull(message = "O nome é obrigatório")
  private String nome;

  @Column(name = "DESCRICAO")
  @NotNull
  @Size(min = 5, max = 50, message = "A descrição deve ter no mínimo {min} " +
      "caracteres e no máximo" + " {max} caracteres.")
  private String descricao;

  @Column(name = "QUANTIDADE")
  @NotNull(message = "A quantidade é obrigatória")
  private Integer quantidade;

  @Column(name = "PRECO_UNITARIO")
  @NotNull(message = "O preço unitário é obrigatório")
  @DecimalMin(value = "0.00", inclusive = false, message = "O preço unitário está zerado, informe um valor válido")
  private BigDecimal precoUnitario;
}
