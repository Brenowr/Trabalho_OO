package br.edu.cafeteria.modelo;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import br.edu.cafeteria.excecao.NenhumProdutoException;

public class CadastroProduto {
	private ArrayList<Produto> produtos;
	
	public CadastroProduto() {
		produtos = new ArrayList<>();
	}
	
	public boolean cadastrarProduto(Produto produto) {
		if(produto == null) {
			return false;
			
		}
			produtos.add(produto);
			return true;
	
	}
	
	public Produto buscarProduto(int codigoProduto) {
		for(Produto produto : produtos){
			if(produto.getCodigoProduto() == codigoProduto) {
				return produto;
				
			}	
		}
		return null;
	}
	
	public boolean removerProduto(int codigoProduto) {
		Produto produto = buscarProduto(codigoProduto);
		return produtos.remove(produto);
		 
	}
	
	public String listarProdutos() throws NenhumProdutoException {
		String listaComidas = ">>> COMIDAS CADASTRADAS <<<\n";
		String listaBebidas = ">>> BEBIDAS CADASTRADAS <<<\n";
		String listaProduto = "";
		String lista = "";
		
		if(produtos.isEmpty()) {
			NenhumProdutoException nenhumProduto = new NenhumProdutoException();
			throw nenhumProduto;
			
		}
			
		for(Produto produto : produtos) {
			listaProduto = "Nome: " + produto.getNomeProduto() + " | Código: " + produto.getCodigoProduto() + " | Quantidade no estoque: " + produto.getQuantidadeEstoque() 
 			 + " | Preço: R$ " + produto.getPrecoBase() + "\n";
			
			if(produto instanceof Comida) {
				listaComidas += listaProduto + "\n";
				
			}else {
				listaBebidas += listaProduto + "\n";
				
			}
			
		}
		lista += listaComidas + listaBebidas;
		return lista;
		
	}
	public boolean editarProduto(Produto produtoNovo) {
		Produto produto;
		if(produtoNovo == null) {
			return false;
		}
		produto = buscarProduto(produtoNovo.getCodigoProduto());
		
		produtos.set(produtos.indexOf(produto),produtoNovo);
		return true;
	}
	
	
	
	
	
	

}
