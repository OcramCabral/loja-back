package com.dbserver.lojaback.controller;

import com.dbserver.lojaback.models.Produto;
import com.dbserver.lojaback.service.IProdutoService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {

  @Autowired
  private IProdutoService produtoService;

  @GetMapping("/produtos")
  @ApiOperation(value = "Busca a lista de produtos cadastrados")
  public List<Produto> listarProdutos() {
    return produtoService.listarProdutos();
  }

  @GetMapping("/produto/{id}")
  @ApiOperation(value = "Busca o produto por ID")
  public Produto obterProdutoPorId(@PathVariable(value = "id") Long id) {
    return produtoService.obterProdutoPorId(id);
  }

  @PostMapping("/produto")
  @ApiOperation(value = "Salva o produto informado")
  public Produto salvarProduto(@Valid @RequestBody Produto produto) {
    return produtoService.salvarProduto(produto);
  }

  @PutMapping("/produto")
  @ApiOperation(value = "Atualiza o produto informado")
  public Produto atualizarProduto(@Valid @RequestBody Produto produto) {
    return produtoService.atualizarProduto(produto);
  }

  @DeleteMapping("/produto/{id}")
  @ApiOperation(value = "Exclui o produto informado")
  public void excluirProduto(@PathVariable(value = "id") Long id) {
    produtoService.excluirProduto(id);
  }
}
