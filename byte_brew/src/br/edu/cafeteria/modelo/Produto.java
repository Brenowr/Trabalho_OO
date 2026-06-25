package br.edu.cafeteria.modelo;

import br.edu.cafeteria.excecao.EstoqueInsuficienteException;

public abstract class Produto {
	private String nomeProduto;
	private double precoBase;
	private int quantidadeEstoque;
	private static int proximoCodigoProduto = 1;
	private int codigoProduto; 
	
	public Produto(String nomeProduto, double precoBase, int quantidadeEstoque) {
		this.nomeProduto = nomeProduto;
		this.precoBase = precoBase;
		this.quantidadeEstoque = quantidadeEstoque;
		this.codigoProduto = proximoCodigoProduto++;
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
	
	public void retirarEstoque(int quantidade) throws EstoqueInsuficienteException {
		if(quantidade > quantidadeEstoque) {
			EstoqueInsuficienteException estoqueInsuficiente = new EstoqueInsuficienteException("Estoque do produto" + nomeProduto + "insuficiente. Quantidade disponivel: " + quantidadeEstoque);
			throw estoqueInsuficiente;
		}
		
		this.quantidadeEstoque -= quantidade;
	}
	
}