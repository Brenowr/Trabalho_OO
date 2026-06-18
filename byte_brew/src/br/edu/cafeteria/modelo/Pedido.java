package br.edu.cafeteria.modelo;
import java.util.ArrayList;

public class Pedido {
	private ArrayList<ItemPedido> itens;
	private Cliente cliente;
	
	public Pedido(Cliente cliente) {
		this.cliente = cliente;
		this.itens = new ArrayList<>();
		
	}

}
