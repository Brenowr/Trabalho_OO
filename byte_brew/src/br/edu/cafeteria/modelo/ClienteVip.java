package br.edu.cafeteria.modelo;

public class ClienteVip extends Cliente{
	
	public ClienteVip(String nomeCliente, String cpf) {
		super(nomeCliente, cpf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void calcularXP(double valorTotal){
		int valorInt;
		valorInt=(int) valorTotal;
		adicionarXP(valorInt*2);
	}
}
