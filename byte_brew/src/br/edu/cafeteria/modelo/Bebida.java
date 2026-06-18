package br.edu.cafeteria.modelo;

public class Bebida extends Produto{
	
	protected double cafeina;
	protected String tamanho;
	protected boolean quente;
	
	public Bebida(String nomeProduto, double precoBase, int quantidadeEstoque, int codigo, double cafeina, String tamnho, boolean quente) {
		super(nomeProduto, precoBase, quantidadeEstoque, codigo);
		// TODO Auto-generated constructor stub
	}
	
}
