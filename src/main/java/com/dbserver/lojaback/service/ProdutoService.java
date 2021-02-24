package com.dbserver.lojaback.service;

import com.dbserver.lojaback.models.Produto;
import com.dbserver.lojaback.repository.IProdutoRepository;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService implements IProdutoService {

  private final IProdutoRepository produtoRepository;

  public ProdutoService(IProdutoRepository produtoRepository) {
    this.produtoRepository = produtoRepository;
  }

  @Override
  public List<Produto> listarProdutos() {
    return produtoRepository.findAll();
  }

  @Override
  public Produto obterProdutoPorId(Long id) {
    return produtoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("O produto informado não foi encontrado."));
  }

  @Override
  public Produto salvarProduto(Produto produto) {
    produto.setId(null);
    return produtoRepository.save(produto);
  }

  @Override
  public Produto atualizarProduto(Produto produto) {
    this.obterProdutoPorId(produto.getId());
    return produtoRepository.save(produto);
  }

  @Override
  public void excluirProduto(Long id) {
    this.obterProdutoPorId(id);
    produtoRepository.deleteById(id);
  }
}
