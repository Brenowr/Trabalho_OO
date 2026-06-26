package br.edu.cafeteria.excecao;

public class XpInsuficienteException extends Exception{

	private static final long serialVersionUID = 1L;

	public XpInsuficienteException() {
		super("Você não tem XP suficiente para realizar essa operação.");
	}
}
