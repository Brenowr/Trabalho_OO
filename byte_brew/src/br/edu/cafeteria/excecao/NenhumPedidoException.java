package br.edu.cafeteria.excecao;

public class NenhumPedidoException extends Exception{
	
	public NenhumPedidoException() {
		super("Não há pedidos cadastrados");
		
	}

}
