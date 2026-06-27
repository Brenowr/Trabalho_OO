package br.edu.cafeteria.app;

import javax.swing.JOptionPane;

import br.edu.cafeteria.excecao.ClienteNaoEncontradoException;
import br.edu.cafeteria.excecao.EstoqueInsuficienteException;
import br.edu.cafeteria.modelo.CadastroCliente;
import br.edu.cafeteria.modelo.CadastroProduto;
import br.edu.cafeteria.modelo.Cliente;
import br.edu.cafeteria.modelo.GerenciadorPedidos;
import br.edu.cafeteria.modelo.Pedido;
import br.edu.cafeteria.modelo.Produto;

public class MenuPedidos {

    private int selecionar;
    private String entrada;
    GerenciadorPedidos gerenciadorPedidos;
    CadastroProduto cadastroProduto; 
    CadastroCliente cadastroCliente;
    
    
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
                		Cliente cliente;
                		String clienteEscolha;
                		clienteEscolha = JOptionPane.showInputDialog(null,"Digite o codigo do cliente\n" +
                															"Digite 0 para cliente casual");
                		int casual = Integer.parseInt(clienteEscolha);
                		if (casual == 0)
                		{
                			gerenciadorPedidos.criarPedido(null);
                		}
                		else {
                			try {
                				cliente = cadastroCliente.buscarCliente(clienteEscolha);
                			}
                			catch(ClienteNaoEncontradoException e) {
                				JOptionPane.showMessageDialog(null, e.getMessage());
                				break;
                			}
                			gerenciadorPedidos.criarPedido(cliente);
                		}
                		
                		break;
                	}

                    case 2: {

                        
                        JOptionPane.showMessageDialog(null, "Cadastro");

                        break;
                    }

                    case 3: {
                    	String lista = gerenciadorPedidos.listarPedidos();
                    	if(lista.isEmpty()) {
                			JOptionPane.showMessageDialog(null, "Não há pedidos cadastrados.");
                			break;
                		}
                    	String codigo = JOptionPane.showInputDialog(null, lista + "\nDigite o codigo do pedido que deseja editar:");
                		if (codigo == null) {
                			break;
                		}
                		
                		int editar = Integer.parseInt(codigo);

                        Pedido pedido = gerenciadorPedidos.buscarPedido(editar);
                        if (pedido == null) {
                            JOptionPane.showMessageDialog(null, "Pedido não encontrado!");
                            break;
                        }
                        int selecionarSub=0;
                        do {
	                        try {
			                        String entradaSub = JOptionPane.showInputDialog(null, "Selecione oque deseja fazer:\n" +
			                        													"1: Adicionar item\n" +
			                        													"2: Remover item\n" +
			                        													"3: Voltar ao menu");
			                        
			                        if (entradaSub == null) {
			                            selecionarSub = 3;
			                        } else if (entradaSub.isEmpty()) {
			                            JOptionPane.showMessageDialog(null,"Digite uma opção!");
			                            continue;
			                        } else {
			                            selecionarSub = Integer.parseInt(entradaSub);
			                        }
			                        
			                        switch(selecionarSub) {
				                        case 1: {
				                        	String produtoAdicionado,quantidadeAdicionada,listaProduto;
				                        	listaProduto = cadastroProduto.listarProdutos();
				                        	if (listaProduto.isEmpty()) {
				                        		JOptionPane.showMessageDialog(null, "Não há produtos cadastrados.");
				                    			break;
				                    		}
				                        	produtoAdicionado = JOptionPane.showInputDialog(null, listaProduto + "\nDigite o codigo do produto a ser adicionado:");

				                    		if (produtoAdicionado == null) {
				                    			break;
				                    		}
				                    		int codigoProduto = Integer.parseInt(produtoAdicionado);
				                    		Produto produto = cadastroProduto.buscarProduto(codigoProduto);
				                    		quantidadeAdicionada = JOptionPane.showInputDialog(null, "\nDigite o codigo do produto a ser adicionado: \n"+
				                    																"Quantidade em estoque: " + produto.getQuantidadeEstoque());
				                    		int quantidade = Integer.parseInt(quantidadeAdicionada);
				                    		if(quantidade == 1) {
					                    		try {
					                    			pedido.adicionarItem(produto);	
					                    		}
					                    		catch(EstoqueInsuficienteException e) {
					                    			JOptionPane.showMessageDialog(null, e.getMessage());
					                    			break;
					                    		}
				                    		}
				                    		else {
					                    		try {
					                    			pedido.adicionarItem(produto,quantidade);	
					                    		}
					                    		catch(EstoqueInsuficienteException e) {
					                    			JOptionPane.showMessageDialog(null, e.getMessage());
					                    			break;
					                    		}
				                    		}
				                        	break;
				                        }
				                        
					                    case 2: {
					                    	break;
					                    }
					                    
					                    case 3: {
					                    	break;
					                    }
							            
								        default: {
								        	JOptionPane.showMessageDialog(null,"Opção inválida!");
								        	break;
								        }
			                        }
	                        	}
	                        catch (NumberFormatException e) {
	                        	JOptionPane.showMessageDialog(null,"Digite apenas números!");
	                        }
                        }while(selecionarSub!=3);
                        break;
                    }

                    case 4: {

                        // editarPedido();
                        JOptionPane.showMessageDialog(null, "Edita");

                        break;
                    }

                    case 5: {

                    	String lista = gerenciadorPedidos.listarPedidos();
                    	if(lista.isEmpty()) {
                			JOptionPane.showMessageDialog(null, "Não há pedidos cadastrados.");
                			break;
                		}
                    	else
                    	{
                    		JOptionPane.showMessageDialog(null, lista);

                            break;
                    	}
                    	
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
}

