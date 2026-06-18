package br.edu.cafeteria.modelo;

public class Comida extends Produto {
	
	protected int tempoPreparo;
	protected boolean vegano,gluten;
	protected boolean confeitaria;
	
	public Comida(String nomeProduto, double precoBase, int quantidadeEstoque, int codigo, int tempoPreparo, boolean vegano, boolean gluten, boolean confeitaria) {
		super(nomeProduto, precoBase, quantidadeEstoque, codigo);
		// TODO Auto-generated constructor stub
	}
	
}
