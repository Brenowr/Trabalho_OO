package br.edu.cafeteria.app;

import javax.swing.JOptionPane;

public class MenuCliente {
	    private int selecionar;
	    private String entrada;
	    public void menuCliente() {
    do {

        entrada = JOptionPane.showInputDialog(
                "Selecione sua opcao:\n" +
                "1: Cadastrar cliente:\n" +
                "2: Remover cliente:\n" +
                "3: Editar cliente:\n" +
                "4: listar clientes\n" +
                "5: Voltar ao menu Principal");

        if (entrada == null) {
            selecionar = 5;
        } 
        else {
            selecionar = Integer.parseInt(entrada);
        }

        switch (selecionar) {

            case 1: {
            	// cadastrarCliente();
            	JOptionPane.showMessageDialog(null,"cadastro");
            	break;
            }

            case 2: {
            	// removerCliente();
            	JOptionPane.showMessageDialog(null,"remove");
            	break;
            }
            case 3: {
            	// editarCliente();
            	JOptionPane.showMessageDialog(null,"edita");
            	break;
            }

            case 4: {
            	// listarCliente();
            	JOptionPane.showMessageDialog(null,"lista");
            	break;
            }
            default: {
            	if (selecionar != 5) {
            		JOptionPane.showMessageDialog(null,"Opcao invalida!");
                }
                break;
            }
        }

    } while (selecionar != 5);
}
}
