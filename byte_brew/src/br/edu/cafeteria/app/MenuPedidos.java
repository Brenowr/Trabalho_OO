package br.edu.cafeteria.app;

import javax.swing.JOptionPane;
import br.edu.cafeteria.modelo.GerenciadorPedidos;

public class MenuPedidos {

    private int selecionar;
    private String entrada;
    GerenciadorPedidos gerenciadorPedidos;
    
    public MenuPedidos(GerenciadorPedidos gerenciadorPedidos) {
    	this.gerenciadorPedidos = gerenciadorPedidos;
    }

    public void menuPedidos() {

        do {

            try {

                entrada = JOptionPane.showInputDialog("Selecione sua opcao:\n" +
                        							   "1: Criar Pedido\n" +
                        							   "2: Remover Pedido\n" +
                        							   "3: Editar Pedido\n" +
                        							   "4: Listar Pedido\n" +
                        							   "5: Voltar ao menu Principal"
                );

                if (entrada == null) {
                    selecionar = 5;
                } else if (entrada.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Digite uma opção!");
                    continue;
                } else {
                    selecionar = Integer.parseInt(entrada);
                }


                switch (selecionar) {

                    case 1: {

                        // criarPedido();
                        JOptionPane.showMessageDialog(null, "Cadastro");

                        break;
                    }

                    case 2: {

                        // removerPedido();
                        JOptionPane.showMessageDialog(null, "Remove");

                        break;
                    }

                    case 3: {

                        // editarPedido();
                        JOptionPane.showMessageDialog(null, "Edita");

                        break;
                    }

                    case 4: {

                        // listarPedido();
                    	String lista = gerenciadorPedidos.listarPedidos();
                    	if(lista == "") {
                			JOptionPane.showMessageDialog(null, "Não há pedidos cadastrados.");
                			break;
                		}
                    	else
                    	{
                    		JOptionPane.showMessageDialog(null, lista);

                            break;
                    	}
                    	
                    }

                    case 5: {

                        break;
                    }

                    default: {

                        JOptionPane.showMessageDialog(null,"Opção inválida!");
                        
                        break;
                    }
                }


            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(null,"Digite apenas números!");
            }

        } while (selecionar != 5);
    }
}

