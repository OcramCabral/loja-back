package com.dbserver.lojaback.repository;

import com.dbserver.lojaback.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProdutoRepository extends JpaRepository<Produto, Long> {

}
