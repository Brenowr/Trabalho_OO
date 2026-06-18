package br.edu.cafeteria.modelo;

public class ItemPedido {
	protected Produto produto;
	protected int quantidade;
	
	public ItemPedido(Produto produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}
}
