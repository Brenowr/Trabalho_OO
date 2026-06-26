package br.edu.cafeteria.excecao;

public class ClienteNaoEncontradoException extends Exception{

	public ClienteNaoEncontradoException() {
		super("Cliente não encontrado.");
	}
}
