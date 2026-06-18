package br.edu.cafeteria.modelo;

public class ClienteStandard extends Cliente{
	
	@Override
	public void calcularXP(double valorTotal){
		int valorInt;
		valorInt=(int) valorTotal;
		adicionarXP(valorInt*2);
	}
}
