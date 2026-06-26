package br.edu.cafeteria.excecao;

public class CpfDuplicadoException extends Exception{

	public CpfDuplicadoException() {
		super("Já existe cadastro com esse CPF.");
	}
}
