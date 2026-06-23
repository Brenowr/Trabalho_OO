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
	    
	    // rodar isso no menu com o listarPedidos:
	    //JOptionPane.showMessageDialog(null, gerenciadorPedidos.listarPedidos()); ou parecido, usando o showInputDialog caso queira algum input 
	    //criar mensagem tambem no menu caso listarPedidos esteja vazio pra nao criar uma caixa vazia
	    
	}
	public void removerPedido() {
		if(pedidos.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não há pedidos cadastrados.");
			return;
		}
		
		String entrada = JOptionPane.showInputDialog(null, listarPedidos() + 
													"\nDigite o codigo do pedido a ser removido:");
		if (entrada == null) {
			return;
		}
		
		int codigoRemover = Integer.parseInt(entrada);

		for (int i = 0; i < pedidos.size(); i++) {
			if (pedidos.get(i).getCodigoPedido() == codigoRemover) {
					pedidos.remove(i);
					JOptionPane.showMessageDialog(null,"Pedido removido com sucesso!");
					return;
			}
		}
		
		JOptionPane.showMessageDialog(null,"Pedido não encontrado!");
	}
	
} //adicinar try catch no parseint do codigoremover com digite um codigo valido
