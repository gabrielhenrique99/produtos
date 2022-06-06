package br.com.ifce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifce.model.Produto;
import br.com.ifce.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepo;
	
	public void cadastrarProduto(Produto produto) {
		produtoRepo.save(produto);
	}
	
	public List<Produto> listarProdutos(){
		return produtoRepo.findAll();
	}
	
	public void excluirProduto(Long codigo) {
		produtoRepo.deleteById(codigo);
	}

}
