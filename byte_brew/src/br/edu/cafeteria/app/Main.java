package br.edu.cafeteria.app;
import br.edu.cafeteria.modelo.Cliente;
import br.edu.cafeteria.modelo.ClienteStandard;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		Cliente cliente;
		int xp;
		double valorCompra;
		String entrada;
		int selecionar;
		do{
			entrada =JOptionPane.showInputDialog("Selecione sua opcao:\n" +
													"1:Cliente Standard \n" +
													"2:Cliente Vip \n" +
														"3:Sair");
			if(entrada == null){
				selecionar = 3;
			}
			else {
				selecionar = Integer.parseInt(entrada);
			}
			
			switch(selecionar){
				case 1:{
					cliente = new ClienteStandard();
					JOptionPane.showMessageDialog(null,"Cliente Standard!");
					valorCompra = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor da compra"));
					cliente.calcularXP(valorCompra);
					xp = cliente.getExperiencia();
					JOptionPane.showMessageDialog(null,"sua experiencia ganha foi:" + xp);
					
					
					break;
				}
				case 2:{
					JOptionPane.showMessageDialog(null,"Cliente Vip!");
					break;
				}
				default:{
					if(selecionar!=3) {
						JOptionPane.showMessageDialog(null,"opcao invalida!");
					}
					break;
				}
			
			}
		}
		while(selecionar != 3);
	}

}
