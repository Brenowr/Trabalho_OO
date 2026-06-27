package br.edu.cafeteria.servico;

import br.edu.cafeteria.modelo.Bebida;
import br.edu.cafeteria.modelo.ItemPedido;
import br.edu.cafeteria.modelo.Pedido;

public class PromocaoEventoGeek implements Promocional{
	
	public double aplicarDesconto(Pedido pedido) {
		
			double total = 0;
			
			for (ItemPedido item : pedido.getItens()) {
				if(item.getProduto() instanceof Bebida) {
					total += (item.calcularSubtotal() * 0.9);
					
				}else {
					total += item.calcularSubtotal();
					
				}
				
			}
			return total;
			
	}

}
