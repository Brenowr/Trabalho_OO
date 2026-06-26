package br.edu.cafeteria.app;
import javax.swing.JOptionPane;
import br.edu.cafeteria.modelo.CadastroProduto;


public class MenuProdutos {
	
	 private int selecionar;
	 private String entrada;
	CadastroProduto cadastroProduto;
	
	   public MenuProdutos(CadastroProduto cadastroProduto) {
		   
	        this.cadastroProduto = cadastroProduto;
	    }
	public void menuProdutos() {

        do {

            try {

                entrada = JOptionPane.showInputDialog("Selecione sua opcao:\n" +
                        							   "1: Cadastrar Produto\n" +
                        							   "2: Buscar Produto\n" +
                        							   "3: Remover Produto\n" +
                        							   "4: Listar Produto\n" +
                        							   "5: Editar Produto\n" +
                        							   "6: Voltar ao menu Principal"
                );

                if (entrada == null) {
                    selecionar = 6;
                } else if (entrada.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Digite uma opção!");
                    continue;
                } else {
                    selecionar = Integer.parseInt(entrada);
                }


                switch (selecionar) {

                    case 1: {

                    	int selecionarProduto;
                    	String tipo = JOptionPane.showInputDialog(
                                "Escolha o tipo do produto:\n" +
                                "1 - Comida\n" +
                                "2 - Bebida\n" +
                                "3 - Voltar ao Menu Produto");
                    	selecionarProduto = Integer.parseInt(tipo);

                        if (tipo == null) {
                        	selecionarProduto = 3;
                        	continue;
                        }

                        String nome = JOptionPane.showInputDialog("Nome do produto:");
                        double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço:"));
                        int estoque = Integer.parseInt(JOptionPane.showInputDialog("Quantidade em estoque:"));

                       switch (selecionarProduto) {
                       case 1: {
                            int tempoPreparo = Integer.parseInt(
                                    JOptionPane.showInputDialog("Tempo de preparo (minutos):")
                            );

                            boolean vegano = JOptionPane.showConfirmDialog(
                                    null,
                                    "É vegano?"
                            ) == JOptionPane.YES_OPTION;

                            boolean gluten = JOptionPane.showConfirmDialog(
                                    null,
                                    "Contém glúten?"
                            ) == JOptionPane.YES_OPTION;

                            boolean confeitaria = JOptionPane.showConfirmDialog(
                                    null,
                                    "É um produto de confeitaria?"
                            ) == JOptionPane.YES_OPTION;

                            Comida comida = new Comida(
                                    nome,
                                    preco,
                                    estoque,
                                    tempoPreparo,
                                    vegano,
                                    gluten,
                                    confeitaria
                            );

                            cadastroProduto.cadastrarProduto(comida);

                        } 
                       case 2: {

                            String tamanho = JOptionPane.showInputDialog(
                                    "Tamanho (P, M ou G):"
                            );

                            double cafeina = Double.parseDouble(
                                    JOptionPane.showInputDialog("Quantidade de cafeína (mg):")
                            );

                            boolean quente = JOptionPane.showConfirmDialog(
                                    null,
                                    "É uma bebida quente?"
                            ) == JOptionPane.YES_OPTION;

                            Bebida bebida = new Bebida(
                                    nome,
                                    preco,
                                    estoque,
                                    tamanho,
                                    cafeina,
                                    quente
                            );

                            cadastroProduto.cadastrarProduto(bebida);

                        } 
                       case 3: {

                            JOptionPane.showMessageDialog(null, "Tipo inválido.");
                            break;
                        }
                    }
                    }

                    case 2: {

                        // removerCliente();
                        JOptionPane.showMessageDialog(null, "Remove");

                        break;
                    }

                    case 3: {

                        // editarCliente();
                        JOptionPane.showMessageDialog(null, "Edita");

                        break;
                    }

                    case 4: {

                        

                        break;
                    }

                    case 5: {

                        break;
                    }
                    
                    case 6: {

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

        } while (selecionar != 6);
    }
}