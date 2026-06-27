package br.edu.cafeteria.servico;

import br.edu.cafeteria.modelo.Comida;
import br.edu.cafeteria.modelo.ItemPedido;
import br.edu.cafeteria.modelo.Pedido;

public class PromocaoFestivalGastronomico implements Promocional  {
	
	public double aplicarDesconto(Pedido pedido) {
		
		double total = 0;
		
		for (ItemPedido item : pedido.getItens()) {
			if(item.getProduto() instanceof Comida) {
				total += (item.calcularSubtotal() * 0.8);
				
			}else {
				total += item.calcularSubtotal();
				
			}
			
		}
		return total;
		
}

}
