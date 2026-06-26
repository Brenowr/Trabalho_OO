package br.edu.cafeteria.excecao;

public class XpInsuficienteException extends Exception{

	public XpInsuficienteException() {
		super("Você não tem XP suficiente para realizar essa operação.")
	}
}
