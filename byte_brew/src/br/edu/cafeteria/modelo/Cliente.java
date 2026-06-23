package br.edu.cafeteria.modelo;

public abstract class Cliente {
	private String nomeCliente,cpf;
	private int experiencia;
	
	public Cliente(String nomeCliente, String cpf) {
		this.nomeCliente = nomeCliente;
		this.cpf = cpf;
	}
	
	public void adicionarXP(int adicionar)
	{
		experiencia += adicionar;
	}
			
	public abstract void calcularXP(double valorTotal);
	
	 public int getExperiencia() {
	    return experiencia;
	}

	 public String getNome() {
		return nomeCliente;
	 }
}
