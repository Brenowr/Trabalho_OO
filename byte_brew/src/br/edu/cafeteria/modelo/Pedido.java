package br.edu.cafeteria.modelo;
import java.util.ArrayList;
import br.edu.cafeteria.excecao.EstoqueInsuficienteException;

public class Pedido {
	private ArrayList<ItemPedido> itens;
	private Cliente cliente;
	private static int proximoCodigo = 1;
	private int codigoPedido;
	
	public Pedido(Cliente cliente) {
		this.cliente = cliente;
		this.itens = new ArrayList<>();
		this.codigoPedido = proximoCodigo++;
		
	}
	
	public void adicionarItem(Produto produto) throws EstoqueInsuficienteException {
	adicionarItem(produto,1); 
		
	}
	
	public void adicionarItem(Produto produto, int quantidade) throws EstoqueInsuficienteException {
		itens.add(new ItemPedido(produto, quantidade));
		produto.retirarEstoque(quantidade);
	}
	
	public int getCodigoPedido() {
		return codigoPedido;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

}