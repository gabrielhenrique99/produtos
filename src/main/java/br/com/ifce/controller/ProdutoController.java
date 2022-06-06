package br.com.ifce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import br.com.ifce.model.Produto;
import br.com.ifce.service.ProdutoService;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("produto/formulario")
	public String formulario() {
		return "formulario";
	}
	
	@GetMapping("produto/salvar")
	public String salvar(Produto produto){
		produtoService.cadastrarProduto(produto);
		return "redirect:/produto/listar";
	}
	
	@GetMapping("produto/listar")
	public ModelAndView listarProdutos() {
		List<Produto> produtos = produtoService.listarProdutos();
		
		ModelAndView mv = new ModelAndView("listagem-produto");
		mv.addObject("listaProdutos", produtos);
		return mv;
	}
	
	@GetMapping("/produto/excluir/{codigo}")
	public ModelAndView excluirProduto(@PathVariable Long codigo) {
		produtoService.excluirProduto(codigo);
		ModelAndView mv = new ModelAndView ("redirect:/produto/listar");
		
		return mv;
	}
	
	

}
