package br.com.ifce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifce.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
