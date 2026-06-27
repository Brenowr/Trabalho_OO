package br.edu.cafeteria.modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GerenciadorPedidos {
	private ArrayList<Pedido> pedidos;
	
	public GerenciadorPedidos() {
	this.pedidos = new ArrayList<>();
	}
	
	public Pedido criarPedido(Cliente cliente){
		Pedido pedido = new Pedido(cliente);
		pedidos.add(pedido);
		return pedido;
	}
	public String listarPedidos() {
	    String texto = "";
	    for (Pedido pedido : pedidos) {
	    	String nome = "Cliente casual";
	    	
	    	if (pedido.getCliente()!=null)
	    	{
	    		nome = pedido.getCliente().getNome();
	    	}
	    	
	        texto += "Pedido: " + pedido.getCodigoPedido()
	              + " | Cliente: " + nome
	              + "\n";
	    }
	    return texto;
	   
	    
	}
	public Pedido buscarPedido(int entrada) {
		for (int i = 0; i < pedidos.size(); i++) {
			if (pedidos.get(i).getCodigoPedido() == entrada){
				return pedidos.get(i);
				}
			}
		return null;
	}
	

	public boolean removerPedido(String entrada) {
		int codigoRemover = Integer.parseInt(entrada);
		Pedido pedido =buscarPedido(codigoRemover);
	    if (pedido == null) {
	        return false;
	    }
		pedidos.remove(pedido);
		return true;
	}
	
} //adicinar try catch no parseint do codigoremover com digite um codigo valido
