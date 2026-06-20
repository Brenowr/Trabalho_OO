package br.edu.cafeteria.modelo;

public abstract class Produto {
	private String nomeProduto;
	private int quantidadeEstoque,codigoProduto;
	private double precoBase;
	
	public Produto(String nomeProduto, double precoBase, int quantidadeEstoque, int codigoProduto) {
		this.nomeProduto = nomeProduto;
		this.precoBase = precoBase;
		this.quantidadeEstoque = quantidadeEstoque;
		this.codigoProduto = codigoProduto;
		
	}
	
	
}
