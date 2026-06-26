package br.edu.cafeteria.modelo;
import java.util.ArrayList;
import br.edu.cafeteria.excecao.EstoqueInsuficienteException;
import br.edu.cafeteria.excecao.XpInsuficienteException;

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
		produto.retirarEstoque(quantidade);
		itens.add(new ItemPedido(produto, quantidade));
	}
	
	public int getCodigoPedido() {
		return codigoPedido;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public double calcularTotal() {
		double total=0;
		for (ItemPedido item : itens) {
		    total += item.calcularSubtotal();
		}
		return total;
	}
	public void finalizarCompra(boolean usarXp) throws XpInsuficienteException{
		
		double total = calcularTotal();
		if(cliente!=null){
			if(usarXp && cliente instanceof ClienteVip) {
				((ClienteVip) cliente).gastarXP(total);
			}
		}
		else {
			cliente.calcularXP(total);
		}
		
	}

}