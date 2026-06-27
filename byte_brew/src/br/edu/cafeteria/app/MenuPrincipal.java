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

    public MenuPrincipal(GerenciadorPedidos gerenciadorPedidos, CadastroCliente cadastroCliente, CadastroProduto cadastroProduto) {

        this.gerenciadorPedidos = gerenciadorPedidos;
        this.cadastroCliente = cadastroCliente;
        this.cadastroProduto = cadastroProduto;
    }


	public void menuPrincipal() {
    	

        do {

            try {

                entrada = JOptionPane.showInputDialog("Selecione sua opcao:\n" +
                        								"1: Menu Clientes\n" +
                        								"2: Menu Produtos\n" +
                        								"3: Menu Pedidos\n" +
                										"4: Sair");
                if (entrada == null) {
                    selecionar = 4;
                    continue;
                }

                if (entrada.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Digite uma opção!");
                    continue;
                }

                selecionar = Integer.parseInt(entrada);

                switch (selecionar) {

                    case 1: {

                        MenuClientes menu = new MenuClientes(cadastroCliente);
                        menu.menuClientes();
                        break;
                    }

                    case 2: {

                    	MenuProdutos menu = new MenuProdutos(cadastroProduto);
                        menu.menuProdutos();
                        break;
                    }
                    case 3: {

                    	MenuPedidos menu = new MenuPedidos(gerenciadorPedidos,cadastroProduto,cadastroCliente);
                        menu.menuPedidos();
                        break;
                    }


                    default: {
                    	
                    	if (selecionar != 4) {
                    		JOptionPane.showMessageDialog(null,"Opcao invalida!");
                        }
                        break;
                    }
                }

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(null,"Digite apenas números!");
            }

        } while (selecionar != 4);
    }
}
