package br.edu.cafeteria.modelo;
import java.util.ArrayList;
import br.edu.cafeteria.excecao.EstoqueInsuficienteException;
import br.edu.cafeteria.excecao.PontosInsuficientesException;

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
	
	public ArrayList<ItemPedido> getItens(){
		return itens;
		
	}
	
	public void adicionarItem(Produto produto) throws EstoqueInsuficienteException {
	adicionarItem(produto,1); 
		
	}
	
	public void adicionarItem(Produto produto, int quantidade) throws EstoqueInsuficienteException {
		for (ItemPedido item : itens) {
		    if (item.getProduto() == produto) {
		        produto.retirarEstoque(quantidade);
		        item.adicionarQuantidade(quantidade);
		        return;
		    }
		}

		produto.retirarEstoque(quantidade);
		itens.add(new ItemPedido(produto, quantidade));
	}
	
	public String listarProdutos() {

	    String texto = "";

	    for (ItemPedido item : itens) {

	        double subtotal = item.getProduto().getPrecoBase() * item.getQuantidade();

	        texto += "Produto: " + item.getProduto().getNomeProduto()
	              + " | Quantidade: " + item.getQuantidade()
	              + " | Subtotal: R$ " + subtotal
	              + " | Codigo: " + item.getProduto().getCodigoProduto()
	              + "\n";
	    }

	    return texto;
	}
	public ItemPedido buscarItem(Produto produto) {

	    for (ItemPedido item : itens) {
	        if (item.getProduto().equals(produto)) {
	            return item;
	        }
	    }
	    return null;
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
	public double finalizarCompra(boolean usarXP, double total) throws PontosInsuficientesException {

	    if (cliente == null) {
	        return total;
	    }

	    if (cliente instanceof ClienteVip) {

	        if (usarXP) {
	            ((ClienteVip) cliente).gastarXP(total);
	            return 0;
	        }

	        cliente.calcularXP(total);
	        return total;
	    }

	    if (cliente instanceof ClienteStandard) {

	        if (usarXP) {
	            double desconto = ((ClienteStandard) cliente).usarXPComoDesconto(total);
	            total -= desconto;
	        }

	        cliente.calcularXP(total);
	    }

	    return total;
	}
	
	public boolean pedidoVazio() {
		return itens.isEmpty();
	}
		public void removerItem(Produto produto, int quantidade) {
		    for (ItemPedido item : itens) {
		        if (item.getProduto().equals(produto)) {

		            if (item.getQuantidade() <= quantidade) {
		            	item.diminuirQuantidade(quantidade);
		                itens.remove(item);
		            } else {
		                item.diminuirQuantidade(quantidade);
		            }

		            produto.adicionarEstoque(quantidade);
		            return;
		        }
		    }	
		}
	}
