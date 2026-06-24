package br.edu.cafeteria.app;

import javax.swing.JOptionPane;

import br.edu.cafeteria.modelo.CadastroCliente;
import br.edu.cafeteria.modelo.CadastroProduto;
import br.edu.cafeteria.modelo.GerenciadorPedidos;

public class MenuPrincipal {

    private int selecionar;
    private String entrada;

    private GerenciadorPedidos gerenciadorPedidos;
    private CadastroCliente cadastroCliente;
    private CadastroProduto cadastroProduto;

    public MenuPrincipal(
            GerenciadorPedidos gerenciadorPedidos,
            CadastroCliente cadastroCliente,
           CadastroProduto cadastroProduto) {

        this.gerenciadorPedidos = gerenciadorPedidos;
        this.cadastroCliente = cadastroCliente;
        this.cadastroProduto = cadastroProduto;
    }


	public void menuPrincipal() {
    	

        do {

            try {

                entrada = JOptionPane.showInputDialog("Selecione sua opcao:\n" +
                        								"1: Menu Clientes\n" +
                        								"2: Menu Carrinho\n" +
                										"3: Sair");
                if (entrada == null) {
                    selecionar = 3;
                    continue;
                }

                if (entrada.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Digite uma opção!");
                    continue;
                }

                selecionar = Integer.parseInt(entrada);

                switch (selecionar) {

                    case 1: {

                        MenuCliente menu = new MenuCliente();
                        menu.menuCliente();
                        break;
                    }

                    case 2: {

                        JOptionPane.showMessageDialog(null,"Menu Carrinho");
                        break;
                    }


                    default: {
                    	
                    	if (selecionar != 3) {
                    		JOptionPane.showMessageDialog(null,"Opcao invalida!");
                        }
                        break;
                    }
                }

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(null,"Digite apenas números!");
            }

        } while (selecionar != 3);
    }
}
