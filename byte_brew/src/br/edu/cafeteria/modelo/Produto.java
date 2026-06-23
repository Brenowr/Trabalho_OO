package br.edu.cafeteria.modelo;

public abstract class Produto {
	private String nomeProduto;
	private double precoBase;
	private int quantidadeEstoque;
	private int codigoProduto;
	
	public Produto(String nomeProduto, double precoBase, int quantidadeEstoque, int codigoProduto) {
		this.nomeProduto = nomeProduto;
		this.precoBase = precoBase;
		this.quantidadeEstoque = quantidadeEstoque;
		this.codigoProduto = codigoProduto;	
	}
	
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public void setPrecoBase(double precoBase) {
		this.precoBase = precoBase;
	}
	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public double getPrecoBase() {
		return precoBase;
	}
	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public int getCodigoProduto() {
		return codigoProduto;
	}
	
}