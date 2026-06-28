package br.edu.cafeteria.modelo;

public abstract class Cliente {
	private String nomeCliente,cpf;
	private int xp;
	private static int realParaXp=1;
	private static int xpParaReal=10;
	
	public Cliente(String nomeCliente, String cpf) {
		this.nomeCliente = nomeCliente;
		this.cpf = cpf;
		this.xp = 0;
	}
	
	public void adicionarXP(int adicionar)
	{
		xp += adicionar;
	}
	
	public void removerXP(int adicionar) {
		 xp -= adicionar;
	 }
	public int getrealParaXp()
	{
		return realParaXp;
	}
	public int getxpParaReal()
	{
		return xpParaReal;
	}
	public double calcularDesconto() {
		 return getXp()/xpParaReal;
	 }
	
	public double usarXPComoDesconto(double valorCompra) {

	    double descontoMaximo = valorCompra * 0.5;

	    double descontoDisponivel = calcularDesconto();

	    double desconto = Math.min(descontoMaximo, descontoDisponivel);

	    int xpUsado = (int) (desconto * xpParaReal);
	    
	    removerXP(xpUsado);

	    return desconto;
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
	 
	 public void setCpf(String novoCpf) {
		    cpf = novoCpf;
		}
	 
}
