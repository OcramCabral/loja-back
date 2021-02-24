package com.dbserver.lojaback.service;

import com.dbserver.lojaback.models.Produto;
import java.util.List;

public interface IProdutoService {

  List<Produto> listarProdutos();
  Produto obterProdutoPorId(Long id);

  Produto salvarProduto(Produto produto);
  Produto atualizarProduto(Produto produto);

  void excluirProduto(Long id);
}
