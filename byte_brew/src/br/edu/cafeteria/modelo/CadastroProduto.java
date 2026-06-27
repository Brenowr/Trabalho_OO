package br.edu.cafeteria.modelo;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
	
	public String listarProdutos() {
		String listaComidas = ">>> COMIDAS CADASTRADAS <<<\n";
		String listaBebidas = ">>> BEBIDAS CADASTRADAS <<<\n";
		String listaProduto = "";
		String lista = "";
		
		if(produtos.isEmpty()) {
			return "Nenhum produto cadastrado.";
			
		}
			
		for(Produto produto : produtos) {
			listaProduto = "Nome: " + produto.getNomeProduto() + " | Código: " + produto.getCodigoProduto() + " | Quantidade no estoque: " + produto.getQuantidadeEstoque() 
 			 + " | Preço: R$ " + produto.getPrecoBase() + "\n";
			
			if(produto instanceof Comida) {
				Comida comida = (Comida) produto;
				listaComidas += listaProduto + "Tempo de preparo: " + comida.getTempoPreparo() + " | É vegano: " + comida.getVegano() 
				  			 + " | Contém glúten: " + comida.getGluten() + " | É produzido na confeitaria: " + comida.getConfeitaria() + "\n\n";
				
			}else {
				Bebida bebida = (Bebida) produto;
				listaBebidas += listaProduto + "Tamanho: " + bebida.getTamanho() + " | Contém cafeína: " + bebida.getCafeina() + " | É quente: " + bebida.getQuente() + "\n\n";
				
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
