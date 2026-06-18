package br.edu.cafeteria.modelo;

public abstract class Cliente {
	private String nome,cpf;
	private int experiencia;
	
	public void adicionarXP(int adicionar)
	{
		experiencia += adicionar;
	}
			
	public abstract void calcularXP(double valorTotal);
	
	 public int getExperiencia() {
	    return experiencia;
	}
}
