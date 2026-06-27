package br.edu.cafeteria.app;

import javax.swing.JOptionPane;

import br.edu.cafeteria.excecao.ClienteNaoEncontradoException;
import br.edu.cafeteria.excecao.EstoqueInsuficienteException;
import br.edu.cafeteria.excecao.NenhumProdutoException;
import br.edu.cafeteria.modelo.CadastroCliente;
import br.edu.cafeteria.modelo.CadastroProduto;
import br.edu.cafeteria.modelo.Cliente;
import br.edu.cafeteria.modelo.GerenciadorPedidos;
import br.edu.cafeteria.modelo.Pedido;
import br.edu.cafeteria.modelo.Produto;

public class MenuPedidos {

    private int selecionar;
    private String entrada;
    private GerenciadorPedidos gerenciadorPedidos;
    private CadastroProduto cadastroProduto; 
    private CadastroCliente cadastroCliente;
    
    
    public MenuPedidos(GerenciadorPedidos gerenciadorPedidos,CadastroProduto cadastroProduto, CadastroCliente cadastroCliente) {
    	this.gerenciadorPedidos = gerenciadorPedidos;
    	this.cadastroProduto = cadastroProduto;
    	this.cadastroCliente = cadastroCliente;
    }

    public void menuPedidos() {

        do {

            try {

                entrada = JOptionPane.showInputDialog("Selecione sua opcao:\n" +
                        							   "1: Criar Pedido\n" +
                        							   "2: Remover Pedido\n" +
                        							   "3: Editar Pedido\n" +
                        							   "4: Visualizar itens do Pedido\n" +
                        							   "5: Listar Pedidos\n" +
                        							   "6: Finalizar Pedido\n" +
                        							   "7: Voltar ao menu Principal"
                );

                if (entrada == null) {
                    selecionar = 7;
                } else if (entrada.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Digite uma opção!");
                    continue;
                } else {
                    selecionar = Integer.parseInt(entrada);
                }


                switch (selecionar) {
                
                	case 1: {
                		criarPedido();
                		break;
                	}

                    case 2: {
                    	removerPedido();
                        break;
                    }

                    case 3: {
                    	editarPedido();
                    	break;
                    }

                    case 4: {                       
                    	visualizarPedido();

                        break;
                    }

                    case 5: {
                    	listarPedidos();
                        break;
                    	}
                    	

                    case 6: {
                        break;
                    }
                    
                    case 7: {

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

        } while (selecionar != 7);
    }
    private void criarPedido() {
        Cliente cliente;
        String clienteEscolha;

        clienteEscolha = JOptionPane.showInputDialog(null,"Digite o CPF do cliente\nDigite 0 para cliente casual");

        if (clienteEscolha == null) {
            return;
        }

        if (clienteEscolha.equals("0")) {
            gerenciadorPedidos.criarPedido(null);
        } else {
            try {
                cliente = cadastroCliente.buscarCliente(clienteEscolha);
            } catch (ClienteNaoEncontradoException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                return;
            }

            gerenciadorPedidos.criarPedido(cliente);
        }
    }
    private void editarPedido() {

        String lista = gerenciadorPedidos.listarPedidos();

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há pedidos cadastrados.");
            return;
        }

        String codigo = JOptionPane.showInputDialog(null,lista + "\nDigite o codigo do pedido que deseja editar:");

        if (codigo == null) {
            return;
        }

        int editar = Integer.parseInt(codigo);

        Pedido pedido = gerenciadorPedidos.buscarPedido(editar);

        if (pedido == null) {
            JOptionPane.showMessageDialog(null, "Pedido não encontrado!");
            return;
        }

        int selecionarSub = 0;

        do {

            try {

                String entradaSub = JOptionPane.showInputDialog(
                        null,
                        "Selecione o que deseja fazer:\n"
                                + "1: Adicionar item\n"
                                + "2: Remover item\n"
                                + "3: Voltar ao menu");

                if (entradaSub == null) {
                    selecionarSub = 3;
                } else if (entradaSub.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Digite uma opção!");
                    continue;
                } else {
                    selecionarSub = Integer.parseInt(entradaSub);
                }

                switch (selecionarSub) {

                case 1:
                    adicionarItem(pedido);
                    break;

                case 2:
                    removerItem(pedido);
                    break;

                case 3:
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite apenas números!");
            }

        } while (selecionarSub != 3);
    }
    private void adicionarItem(Pedido pedido) {
    	

        String listaProduto = "";
        
        try {
 		   listaProduto = cadastroProduto.listarProdutos();
 	   }catch(NenhumProdutoException e){
 		   JOptionPane.showMessageDialog(null, e.getMessage());
 		   return;
 		   
 	   }


        String produtoAdicionado = JOptionPane.showInputDialog(null, listaProduto + "\nDigite o codigo do produto a ser adicionado:");

        if (produtoAdicionado == null) {
            return;
        }

        int codigoProduto = Integer.parseInt(produtoAdicionado);

        Produto produto = cadastroProduto.buscarProduto(codigoProduto);
        
        if (produto == null) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado!");
            return;
        }

        String quantidadeAdicionada = JOptionPane.showInputDialog(null,"Digite a quantidade desejada:\nQuantidade em estoque: " + produto.getQuantidadeEstoque());

        if (quantidadeAdicionada == null) {
            return;
        }
        int quantidade=0;
        try {
        	quantidade = Integer.parseInt(quantidadeAdicionada);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Digite apenas números!");
            return;
        }
        
        try {

            if (quantidade == 1) {
                pedido.adicionarItem(produto);
            } else {
                pedido.adicionarItem(produto, quantidade);
            }

        } catch (EstoqueInsuficienteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    private void removerItem(Pedido pedido) {
    	

        String listaProdutos = pedido.listarProdutos();

        if (listaProdutos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há produtos cadastrados.");
            return;
        }

        String produtoRemovido = JOptionPane.showInputDialog(null, listaProdutos + "\nDigite o codigo do produto a ser Removido:");

        if (produtoRemovido == null) {
            return;
        }

        int codigoProduto = Integer.parseInt(produtoRemovido);

        Produto produto = cadastroProduto.buscarProduto(codigoProduto);
        
        if (produto == null) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado!");
            return;
        }

        String quantidadeRemovida = JOptionPane.showInputDialog(null, "Produto: " + pedido.buscarItem(produto).getProduto().getNomeProduto() + 
        														"\nDigite a quantidade a ser removida:\n"+
        														"Quantidade no carrinho: " 
        														+ pedido.buscarItem(produto).getQuantidade());

        if (quantidadeRemovida == null) {
            return;
        }
        int quantidade;
        try {
        	quantidade = Integer.parseInt(quantidadeRemovida);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Digite apenas números!");
            return;
        }
        pedido.removerItem(produto, quantidade);
        
        
    }
    private void listarPedidos() {

        String lista = gerenciadorPedidos.listarPedidos();

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há pedidos cadastrados.");
            return;
        }

        JOptionPane.showMessageDialog(null, lista);
    }
    private void removerPedido() {
    	String lista = gerenciadorPedidos.listarPedidos();
    	if(lista.isEmpty())
    	{
    		JOptionPane.showMessageDialog(null, "Não há pedidos cadastrados.");
    		return;
    	}
		String entrada = JOptionPane.showInputDialog(null, gerenciadorPedidos.listarPedidos() + "Digite o codigo do pedido a ser removido:");
		if (entrada == null) {
			return;
		}

	    if (gerenciadorPedidos.removerPedido(entrada)) {
	        JOptionPane.showMessageDialog(null, "Pedido removido com sucesso!");
	    } else {
	        JOptionPane.showMessageDialog(null, "Pedido não encontrado!");
	    }
	}
	private void visualizarPedido() {
		String listaPedidos = gerenciadorPedidos.listarPedidos();
        if (listaPedidos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há pedidos cadastrados.");
            return;
        }
		String codigo = JOptionPane.showInputDialog(null,listaPedidos + "Digite o codigo do pedido que deseja visualizar");
        if (codigo == null) {
            return;
        }
        int visualizar = Integer.parseInt(codigo);

        Pedido pedido = gerenciadorPedidos.buscarPedido(visualizar);

        if (pedido == null) {
            JOptionPane.showMessageDialog(null, "Pedido não encontrado!");
            return;
        }
        String nome;
        if(pedido.getCliente()==null)
        {
        	nome = "Cliente casual";
        }
        else {
        	 nome = pedido.getCliente().getNome();
        }
        JOptionPane.showMessageDialog(null, "Pedido de: "+ nome+ " | Codigo: "+ pedido.getCodigoPedido()+"\n" +pedido.listarProdutos());
    }
	
	private void finalizarPedido() {
		
	}
}

