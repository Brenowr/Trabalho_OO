package br.edu.cafeteria.modelo;

public class ClienteVip extends Cliente{
	
	@Override
	public void calcularXP(double valorTotal){
		int valorInt;
		valorInt=(int) valorTotal;
		adicionarXP(valorInt*2);
	}
}
