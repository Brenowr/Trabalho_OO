package br.edu.cafeteria.modelo;

public class ItemPedido {
	protected Produto produto;
	protected int quantidade;
	
	public ItemPedido(Produto produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public Produto getProduto() {
		return produto;
	}
	public double calcularSubtotal()
	{
		return produto.getPrecoBase()*quantidade;
	}
	public void diminuirQuantidade(int quantidade) {
		this.quantidade -=quantidade;
	}
}