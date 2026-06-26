package br.edu.cafeteria.excecao;

public class CpfInvalidoException extends Exception{

	public CpfInvalidoException() {
		super("CPF inválido. Digite exatamente 11 números.");
	}
}
