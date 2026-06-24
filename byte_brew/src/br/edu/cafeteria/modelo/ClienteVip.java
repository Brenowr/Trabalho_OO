package br.edu.cafeteria.modelo;

public class ClienteVip extends Cliente{
	
	public ClienteVip(String nomeCliente, String cpf) {
		super(nomeCliente, cpf);
	}

	@Override
	public void calcularXP(double valorTotal){
		int valorInt;
		valorInt=(int) valorTotal;
		adicionarXP(valorInt*2);
	}
	
	public boolean gastarXP(double valorPedido) {
		int xpNecessario = (int) (valorPedido*10);
		if(getXp() >= xpNecessario) {
			removerXP(xpNecessario);
			return true;
		}
		return false;
	}
}
