package br.edu.cafeteria.app;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		String entrada;
		int selecionar;
		do{
			entrada =JOptionPane.showInputDialog("Selecione sua opcao:\n" +
													"1:Menu teste a\n" +
													"2:Menu teste b\n" +
														"3:Sair");
			if(entrada == null){
				selecionar = 3;
			}
			else {
				selecionar = Integer.parseInt(entrada);
			}
			
			switch(selecionar){
				case 1:{
					JOptionPane.showMessageDialog(null,"menu a!");
					break;
				}
				case 2:{
					JOptionPane.showMessageDialog(null,"menu b!");
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
