package br.edu.cafeteria.excecao;

public class NenhumProdutoException extends Exception{
	
	public NenhumProdutoException() {
		super("Não há produtos cadastrados");
		
	}

}
