package br.edu.cafeteria.modelo;

public abstract class Cliente {
	private String nomeCliente,cpf;
	private int xp;
	
	public Cliente(String nomeCliente, String cpf) {
		this.nomeCliente = nomeCliente;
		this.cpf = cpf;
		this.xp = 0;
	}
	
	public void adicionarXP(int adicionar)
	{
		xp += adicionar;
	}
	
	public void removerXp(int adicionar) {
		 xp -= adicionar;
	 }
			
	public abstract void calcularXP(double valorTotal);
	
	 public int getXp() {
	    return xp;
	}
	 
	 public String getNome() {
		return nomeCliente;
	 }
	 
	 public String getCpf() {
		 return cpf;
	 }

	 public void setNome(String novoNome) {
		 nomeCliente = novoNome;
	 }
}
