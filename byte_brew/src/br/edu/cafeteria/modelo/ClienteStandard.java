package br.edu.cafeteria.modelo;

public class ClienteStandard extends Cliente{
	
	public ClienteStandard(String nomeCliente, String cpf) {
		super(nomeCliente, cpf);
	}

	@Override
	public void calcularXP(double valorTotal){
		int valorInt;
		valorInt=(int) valorTotal;
		adicionarXP(valorInt);
	}
}
