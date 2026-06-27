package br.edu.cafeteria.app;
import javax.swing.JOptionPane;

import br.edu.cafeteria.excecao.EstoqueInsuficienteException;
import br.edu.cafeteria.excecao.NenhumProdutoException;
import br.edu.cafeteria.modelo.Bebida;
import br.edu.cafeteria.modelo.CadastroProduto;
import br.edu.cafeteria.modelo.Comida;
import br.edu.cafeteria.modelo.Produto;


public class MenuProdutos {
	 private int selecionar;
	 private String entrada;
	 private CadastroProduto cadastroProduto;
	
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
                        							   "4: Listar Produtos cadastrados\n" +
                        							   "5: Editar Produto\n" +
                        							   "6: Voltar ao menu Principal");

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
                    	cadastrarProduto();
                        break;
                       
                    }

                    case 2: {
                    	buscarProduto();
                    	break;

                    }

                    case 3: {
                    	removerProduto();
                        break;
                        
                    }

                    case 4: {
                    	listarProdutos();
                    	break;

                    }

                    case 5: {
                    	editarProdutos();
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
	private void cadastrarProduto(){

    	int selecionarProduto = 0;
    	
    	String entradaProduto = JOptionPane.showInputDialog(
                "Escolha o tipo do produto:\n" +
                "1 - Comida\n" +
                "2 - Bebida\n" +
                "3 - Voltar ao Menu Produto");
    	

        if (entradaProduto == null) {
        	selecionarProduto = 3;
        	
        } else if(entradaProduto.isEmpty()) {
        	JOptionPane.showMessageDialog(null, "Digite uma opção!");
        	return;
        	
        } else{
        	selecionarProduto = Integer.parseInt(entradaProduto);
            
        }
	


       switch (selecionarProduto) {
       
           case 1: {
        	    cadastrarComida();
        	    break;
           }
       
           case 2: {
        	   cadastrarBebida();
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
           
       private void cadastrarComida() {
    	   boolean vegano, gluten, confeitaria;
    	   int entradaInt;
    	   String entrada;
    	   String nomeProduto = JOptionPane.showInputDialog("Nome do produto:");
    	   
    	   if(nomeProduto == null) {
    		   return;
    		   
    	   } else if(nomeProduto.equals("")) {
    		   JOptionPane.showMessageDialog(null, "Informe um nome!");
    		   return;
    		   
    	   }
    	   
    	   entrada = JOptionPane.showInputDialog("Preço em R$:");
    	   
    	   if(entrada == null) {
    		   return;
    		   
    	   } else if(entrada.equals("")) {
    		   JOptionPane.showMessageDialog(null, "Informe um preço!");
    		   return;
    		   
    	   } else if(Integer.parseInt(entrada) < 0) {
    		   JOptionPane.showMessageDialog(null, "Digite um preço válido!");
    	   }
    	   
           double precoProduto = Double.parseDouble(entrada);
           
           entrada = JOptionPane.showInputDialog("Quantidade em estoque:");
           
           if(entrada == null) {
        	   return;
        	   
           } else if(entrada.equals("")) {
        	   JOptionPane.showMessageDialog(null, "Informe uma quantidade!");
        	   return;
        	   
           } else if(Integer.parseInt(entrada) <= 0) {
        	   JOptionPane.showMessageDialog(null, "Digite uma quantidade válida!");
           }
           
           int estoque = Integer.parseInt(entrada);
           
           entrada = JOptionPane.showInputDialog("Tempo de preparo em minutos:");
           
           if(entrada == null) {
        	   return;
        	   
           } else if(entrada.equals("")) {
        	   JOptionPane.showMessageDialog(null, "Informe um tempo de Preparo!");
        	   return;
        	   
           }
           
           int tempoPreparo = Integer.parseInt(entrada);

           entradaInt = JOptionPane.showConfirmDialog(null,"É vegano?");
           
           if(entradaInt == JOptionPane.CANCEL_OPTION || entradaInt ==  JOptionPane.CLOSED_OPTION) {
        	   return;
        	   
           }
           vegano = entradaInt == JOptionPane.YES_OPTION;
           
           entradaInt = JOptionPane.showConfirmDialog(null,"Contém glútem?");
           
           if(entradaInt == JOptionPane.CANCEL_OPTION || entradaInt ==  JOptionPane.CLOSED_OPTION) {
        	   return;
        	   
           }
           gluten = entradaInt == JOptionPane.YES_OPTION;

           entradaInt = JOptionPane.showConfirmDialog(null,"É um produto de confeitaria?");
           
           if(entradaInt == JOptionPane.CANCEL_OPTION || entradaInt ==  JOptionPane.CLOSED_OPTION) {
        	   return;
        	   
           }
           confeitaria = entradaInt == JOptionPane.YES_OPTION;

           Comida comida = new Comida(nomeProduto, precoProduto, estoque, tempoPreparo, vegano, gluten, confeitaria);
           
           cadastroProduto.cadastrarProduto(comida);
           JOptionPane.showMessageDialog(null,"Produto cadastrado com sucesso!");
           return;
       
       }
       
       private void cadastrarBebida() {
    	   boolean quente;
    	   String entrada;
    	   String nomeProduto = JOptionPane.showInputDialog("Nome do produto:");
    	   
    	   if(nomeProduto == null) {
    		   return;
    		   
    	   } else if(nomeProduto.equals("")) {
    		   JOptionPane.showMessageDialog(null, "Informe um nome!");
    		   return;
    		   
    	   }
    	   
    	   entrada = JOptionPane.showInputDialog("Preço em R$:");
    	   
    	   if(entrada == null) {
    		   return;
    		   
    	   } else if(entrada.equals("")) {
    		   JOptionPane.showMessageDialog(null, "Informe um preço!");
    		   return;
    		   
    	   } else if(Integer.parseInt(entrada) < 0) {
    		   JOptionPane.showMessageDialog(null, "Digite um preço válido!");
    		   return;
    		   
    	   }
    	   
           double precoProduto = Double.parseDouble(entrada);
           
           entrada = JOptionPane.showInputDialog("Quantidade em estoque:");
           
           if(entrada == null) {
        	   return;
        	   
           } else if(entrada.equals("")) {
        	   JOptionPane.showMessageDialog(null, "Informe uma quantidade!");
        	   return;
        	   
           } else if(Integer.parseInt(entrada) <= 0) {
        	   JOptionPane.showMessageDialog(null, "Digite uma quantidade válida!");
        	   return;
           }
           
           int estoque = Integer.parseInt(entrada);
           
           entrada = JOptionPane.showInputDialog("Tempo de preparo em minutos:");
           
           if(entrada == null) {
        	   return;
        	   
           } else if(entrada.equals("")) {
        	   JOptionPane.showMessageDialog(null, "Informe um tempo de Preparo!");
        	   return;
        	   
           }
           
           String tamanho = JOptionPane.showInputDialog("Tamanho (P, M ou G):");
           
           if(tamanho == null) {
        	   return;
        	   
           } else if(tamanho.equals("")) {
        	   JOptionPane.showMessageDialog(null, "Digite um tamanho!");
        	   return;
        	   
           } else if(tamanho.equals("P") && tamanho.equals("M") && tamanho.equals("G")) {
        	   JOptionPane.showMessageDialog(null, "Digite um tamanho válido");
        	   return;
        	   
           }
           
           
           entrada = JOptionPane.showInputDialog("Quantidade de cafeína em mg:");
           
           if(entrada == null) {
        	   return;
        	   
           } else if(entrada.equals("")) {
        	   JOptionPane.showMessageDialog(null,"Informe uma quantidade!");
        	   return;
        	   
           } else if(Integer.parseInt(entrada) < 0) {
        	   JOptionPane.showMessageDialog(null, "Digite uma dosagem positiva!");
        	   return;
        	   
           }
           
           double cafeina = Double.parseDouble(entrada);

           int entradaInt = JOptionPane.showConfirmDialog(null,"É uma bebida quente?");
           
           if(entradaInt == JOptionPane.CANCEL_OPTION || entradaInt ==  JOptionPane.CLOSED_OPTION ) {
        	   return;
        	   
           }
           quente = entradaInt == JOptionPane.YES_OPTION;
           
           Bebida bebida = new Bebida(nomeProduto, precoProduto, estoque, tamanho, cafeina, quente);

           cadastroProduto.cadastrarProduto(bebida);
           JOptionPane.showMessageDialog(null,"Produto cadastrado com sucesso!");
           return;
       
       }
       
       private void buscarProduto() {
    	String texto = "";
       	Produto produto = null;
       	int codigoProduto = 0;
       	String listaProduto = "";
       	
       	try {
 		   listaProduto = cadastroProduto.listarProdutos();
 	   } catch(NenhumProdutoException e){
 		   JOptionPane.showMessageDialog(null, e.getMessage());
 		   return;
 		   
 	   }
       	
       	String entradaProduto = JOptionPane.showInputDialog(listaProduto + "\nInforme o código do produto:");
       	
       	
       	if (entradaProduto == null) {
           	return;
           	
           } else if(entradaProduto.isEmpty()) {
           	JOptionPane.showMessageDialog(null, "Digite um código!");
           	return;
           	
           }else {
           	codigoProduto = Integer.parseInt(entradaProduto);
           	produto = cadastroProduto.buscarProduto(codigoProduto);
           }
       	
       	texto += "Nome: " + produto.getNomeProduto() + " | Código: " + produto.getCodigoProduto() + " | Quantidade no estoque: " + produto.getQuantidadeEstoque() 
			  		  + " | Preço: R$ " + produto.getPrecoBase() + "\n";
       	
       	
       	
       	if(produto instanceof Comida) {
       		Comida comida = (Comida) produto;
       		texto += "Tempo de preparo em minutos: " + comida.getTempoPreparo() + " | É vegano: " + comida.getVegano() + " | Contém glútem: " + comida.getGluten()
       			  + " | É produzido na confeitaria: " + comida.getConfeitaria() + " | É produzido na cozinha: " + comida.getCozinha() + "\n";
       		
       	
       	}else {
       		Bebida bebida = (Bebida) produto;
       		texto += "Tamanho: " + bebida.getTamanho() + " | Contém cafeína: " + bebida.getCafeina() + " | É quente: " + bebida.getQuente() + "\n";
       		
       	}
       	
       	JOptionPane.showMessageDialog(null, texto);
       	return;
    	   
       }
       
       private void removerProduto () {
    	   String vef = "";
    	   int codigoProduto = 0;
    	   
    	   try {
    		  vef = cadastroProduto.listarProdutos();
    		   
    	   }catch(NenhumProdutoException e){
    		   JOptionPane.showMessageDialog(null, e.getMessage());
    		   return;
    		   
    	   }
    	   
       	String entradaProduto = JOptionPane.showInputDialog(null,vef + "\nInforme o código do produto que deve ser removido:");
       	
       	if (entradaProduto == null) {
           	return;
           	
           } else if(entradaProduto.isEmpty()) {
           	JOptionPane.showMessageDialog(null, "Digite um código!");
           	return;
           	
           }else {
           	codigoProduto = Integer.parseInt(entradaProduto);
           }
       	
       	cadastroProduto.removerProduto(codigoProduto);
           JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");

           return;
       }
       
       private void listarProdutos() {
    	   String lista = "";
    	   try {
    		   lista = cadastroProduto.listarProdutos();
    		   
    	   }catch(NenhumProdutoException e){
    		   JOptionPane.showMessageDialog(null, e.getMessage());
    		   return;
    		   
    	   }
    	   
    	   JOptionPane.showMessageDialog(null, lista);
       }
       
       private void editarProdutos() {
    	   String entrada;
    	   Produto produto;
    	   int selecionarProduto = 0;
    	   int codigoProduto;
    	   String selecionar;
    	   
    	   String lista = "";
    	   try {
    		   lista = cadastroProduto.listarProdutos();
    		   
    	   }catch(NenhumProdutoException e){
    		   JOptionPane.showMessageDialog(null, e.getMessage());
    		   return;
    		   
    	   }
    	   
    	   codigoProduto = Integer.parseInt(JOptionPane.showInputDialog(lista +"\nInforme o código do produto:"));
    	   
    	   produto = cadastroProduto.buscarProduto(codigoProduto);
    	   
    	   if(produto instanceof Comida) {
    		   Comida comida = (Comida) produto;
    		   
    		   
    		  selecionar = JOptionPane.showInputDialog("Selecione sua opcao:\n" +
													   "1: Adicionar estoque\n" +
													   "2: Remover estoque\n" +
													   "3: Alterar nome\n" +
													   "4: Alterar preço\n" +
													   "5: Alterar tempo de Preparo\n" +
													   "6: Alterar classificação vegana\n" +
													   "7: Alterar informação de glúten\n" +
													   "8: Alterar local de preparo\n" +
													   "9: Sair para menu produtos");
    		  
    		  if(selecionar == null) {
    			  selecionarProduto = 9;
    			  
    		  } else if(selecionar == "") {
    			  JOptionPane.showMessageDialog(null,"Digite uma opção!");
    			  return;
    			  
    		  }else {
    			  selecionarProduto = Integer.parseInt(selecionar);
    			  
    		  }
    		  
    		   
    		   
    		   switch(selecionarProduto) {
    		   
    		   
    		   		case 1: {
    		   			entrada = JOptionPane.showInputDialog("Estoque: " + comida.getQuantidadeEstoque() + "\nInforme a quantidade que deve ser adicionada no estoque:");
    		   			
    		   			if(entrada == null) {
    		   				break;
    		   				
    		   			} else if(entrada == "") {
    		   				JOptionPane.showMessageDialog(null, "Informe uma quantidade!");
    		   				break;
    		   			}
    		   			
    		   			int quantidade = Integer.parseInt(entrada);
    		   			comida.adicionarEstoque(quantidade);
    		   			
    		   			if(cadastroProduto.editarProduto(comida)) {
    		   				JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");
    		   			}
    		   			break;
    		   		}
    		   		
    		   		case 2: {
    		   			entrada = JOptionPane.showInputDialog("Estoque: " + comida.getQuantidadeEstoque() + "\nInforme a quantidade que deve ser retirada do estoque:");
    		   			
    		   			if(entrada == null) {
    		   				break;
    		   				
    		   			} else if(entrada == "") {
    		   				JOptionPane.showMessageDialog(null, "Informe uma quantidade!");
    		   				break;
    		   			}
    		   			
    		   			int quantidade = Integer.parseInt(entrada);
    		   			try {
    		   				comida.retirarEstoque(quantidade);
    		   				
    		   			} catch(EstoqueInsuficienteException e){
    		   				JOptionPane.showMessageDialog(null, "Não é possível retirar essa quantidade do estoque");
    		   				break;
    		 
    		   			}
    		   			
    		   			
    		   			if(cadastroProduto.editarProduto(comida)) {
    		   				JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");
    		   			}
    		   			break;
    		   			
    		   				
    		   		}
    		   		
    		   		case 3: {
    		   			entrada = JOptionPane.showInputDialog("Nome: " + comida.getNomeProduto() + "\nInforme o novo nome:");
    		   			
    		   			if(entrada == "") {
    		   				JOptionPane.showMessageDialog(null,"Informe um nome!");
    		   				break;
    		
    		   			}else if(entrada == null) {
    		   				break;
    		   			}
    		   			
    		   			comida.setNomeProduto(entrada);
    		   			
    		   			if(cadastroProduto.editarProduto(comida)) {
    		   				JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");
    		   			}
    		   			break;
    		   		}
    		   		
    		   		case 4: {
    		   			entrada = JOptionPane.showInputDialog("Preço: " + comida.getPrecoBase() + "\nInforme o novo preço:");
    		   			
    		   			if(entrada == null) {
			   				break;
			   				
			   			} else if(entrada == "") {
			   				JOptionPane.showMessageDialog(null, "Informe um preço!");
			   				break;
			   				
			   			}
    		   			
    		   			int preco = Integer.parseInt(entrada);
    		   			comida.setPrecoBase(preco);
    		   			
    		   			if(cadastroProduto.editarProduto(comida)) {
    		   				JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");
    		   			}
    		   			break;
    		   			
    		   		}
    		   		
    		   		case 5: {
    		   			int tempo;
    		   			entrada = JOptionPane.showInputDialog("Tempo de preparo: " + comida.getTempoPreparo()  + " minutos\nInforme o novo tempo de preparo em minutos:");
    		   			
    		   			if(entrada == null) {
    		   				break;
    		   				
    		   			}else if(entrada == "") {
    		   				JOptionPane.showMessageDialog(null, "Informe um tempo de preparo!");
    		   				break;
    		   				
    		   			}
    		   			tempo = Integer.parseInt(entrada);
    		   			comida.setTempoPreparo(tempo);
    		   			
    		   			if(cadastroProduto.editarProduto(comida)) {
    		   				JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");
    		   			}
    		   			break;
    		   			
    		   			
    		   			
    		   			
    		   		}
    		   		
    		   		case 6: {
    		   			boolean vegano;
    		   			
    		   			int entradaInt = JOptionPane.showConfirmDialog(null,"O produto é vegano?");
    		   			
    		   			if(entradaInt == JOptionPane.CANCEL_OPTION || entradaInt ==  JOptionPane.CLOSED_OPTION) {
    		         	   return;
    		         	   
    		            }
    		            vegano = entradaInt == JOptionPane.YES_OPTION;
    		   			
    		   			comida.setVegano(vegano);
    		   			
    		   			if(cadastroProduto.editarProduto(comida)) {
    		   				JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");
    		   			}
    		   			break;
    		   			
    		   			
    		   		}
    		   		
    		   		case 7: {
    		   			boolean gluten;
    		   			
    		   			int entradaInt = JOptionPane.showConfirmDialog(null,"O produto contém glúten?");
    		   			
    		   			if(entradaInt == JOptionPane.CANCEL_OPTION || entradaInt ==  JOptionPane.CLOSED_OPTION) {
    		         	   return;
    		         	   
    		            }
    		            gluten = entradaInt == JOptionPane.YES_OPTION;
    		   			
    		   			comida.setGluten(gluten);
    		   			
    		   			if(cadastroProduto.editarProduto(comida)) {
    		   				JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");
    		   			}
    		   			break;
    		   		}
    		   		
    		   		case 8: {
    		   			boolean confeitaria;
    		   			int entradaInt =  JOptionPane.showConfirmDialog(null,"O produto será de confeitaria?");
    		   			
    		   			if(entradaInt == JOptionPane.CANCEL_OPTION || entradaInt ==  JOptionPane.CLOSED_OPTION) {
    		         	   return;
    		         	   
    		            }
    		            confeitaria = entradaInt == JOptionPane.YES_OPTION;
    		   			
    		   			comida.setConfeitaria(confeitaria);
    		   			
    		   			if(cadastroProduto.editarProduto(comida)) {
    		   				JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");
    		   			}
    		   			break;
    		   		}
    		   		
    		   		case 9: {
    		   			break;
    		   		}
    		   		
    		   		default: {
    		   			JOptionPane.showMessageDialog(null,"Opção inváida!");
    		   			break;
    		   			
    		   		}
    		   }
    			   
    		   } else {
    			   Bebida bebida = (Bebida) produto;
    			   
    			   selecionar = JOptionPane.showInputDialog("Selecione sua opcao:\n" +
								    					   "1: Adicionar estoque\n" +
								    					   "2: Remover estoque\n" +
								    					   "3: Alterar nome\n" +
								    					   "4: Alterar preço\n" +
								    					   "5: Alterar tamanho\n" +
								    					   "6: Alterar informção de cafeína\n" +
								    					   "7: Alterar informação de temperatura\n" +
								    					   "8: Sair para menu produtos");
    			   
    			   if(selecionar == null) {
    	    			  selecionarProduto = 9;
    	    			  
    	    		  } else if(selecionar == "") {
    	    			  JOptionPane.showMessageDialog(null,"Digite uma opção!");
    	    			  return;
    	    			  
    	    		  }else {
    	    			  selecionarProduto = Integer.parseInt(selecionar);
    	    			  
    	    		  }
    			   
    			   switch(selecionarProduto) {
    			   		
    			   
    			   		case 1: {
        		   			entrada = JOptionPane.showInputDialog("Estoque: " + bebida.getQuantidadeEstoque() + "\nInforme a quantidade que deve ser adicionada no estoque:");
        		   			
        		   			if(entrada == null) {
        		   				break;
        		   				
        		   			} else if(entrada == "") {
        		   				JOptionPane.showMessageDialog(null, "Informe uma quantidade!");
        		   				break;
        		   			}
        		   			
        		   			int quantidade = Integer.parseInt(entrada);
        		   			bebida.adicionarEstoque(quantidade);
        		   			
        		   			if(cadastroProduto.editarProduto(bebida)) {
        		   				JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");
        		   			}
        		   			break;
    			   			
    			   		}
    			   		
    			   		case 2: {
        		   			entrada = JOptionPane.showInputDialog("Estoque: " + bebida.getQuantidadeEstoque() + "\nInforme a quantidade que deve ser retirada do estoque:");
        		   			
        		   			if(entrada == null) {
        		   				break;
        		   				
        		   			} else if(entrada == "") {
        		   				JOptionPane.showMessageDialog(null, "Informe uma quantidade!");
        		   				break;
        		   			}
        		   			
        		   			int quantidade = Integer.parseInt(entrada);
        		   			try {
        		   				bebida.retirarEstoque(quantidade);
        		   				
        		   			} catch(EstoqueInsuficienteException e){
        		   				JOptionPane.showMessageDialog(null, "Não é possível retirar essa quantidade do estoque");
        		   				break;
        		 
        		   			}
        		   			
        		   			
        		   			if(cadastroProduto.editarProduto(bebida)) {
        		   				JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");
        		   			}
        		   			break;
    			   			
    			   		}
    			   		
    			   		case 3: {
    			   			entrada= JOptionPane.showInputDialog("Nome: " + bebida.getNomeProduto() + "\nInforme o novo nome:");
        		   			
        		   			if(entrada == "") {
        		   				JOptionPane.showMessageDialog(null,"Informe um nome!");
        		   				break;
        		
        		   			}else if(entrada == null) {
        		   				break;
        		   			}
        		   			
        		   			bebida.setNomeProduto(entrada);
        		   			
        		   			if(cadastroProduto.editarProduto(bebida)) {
        		   				JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");
        		   			}
        		   			break;
    			   			
    			   		}
    			   		
    			   		case 4: {
    			   			entrada = JOptionPane.showInputDialog("Preço: R$" + bebida.getPrecoBase() + "\nInforme o novo preço:");
    			   			
    			   			if(entrada == null) {
    			   				break;
    			   				
    			   			} else if(entrada == "") {
    			   				JOptionPane.showMessageDialog(null, "Informe um preço!");
    			   				break;
    			   				
    			   			}
        		   			
        		   			int preco = Integer.parseInt(entrada);
        		   			bebida.setPrecoBase(preco);
        		   			
        		   			if(cadastroProduto.editarProduto(bebida)) {
        		   				JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");
        		   			}
        		   			break;
    			   			
    			   		}
    			   		
    			   		case 5: {
    			   			entrada = JOptionPane.showInputDialog("Tamanho: " + bebida.getTamanho() + "\nInforme o novo tamanho (P, M ou G):");
    			   			
    			   			if(entrada == null) {
    			   				break;
    			   				
    			   			} else if(entrada == "") {
    			   				JOptionPane.showMessageDialog(null, "Informe um tamanho!");
    			   				break;
    			   				
    			   			} else if(!entrada.equals("P") && !entrada.equals("M") && !entrada.equals("G")) {
    			   				JOptionPane.showMessageDialog(null, "Digite um tamanho válido");
    			   				break;
    			   				
    			   			}
    			   			
    			   			bebida.setTamanho(entrada);
    			   			
    			   			if(cadastroProduto.editarProduto(bebida)) {
        		   				JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");
        		   			}
    			   			break;
    			   			
    			   		}
    			   		
    			   		case 6: {
    			   			entrada =  JOptionPane.showInputDialog("Dosagem de cafeína: " + bebida.getCafeina() + "\nInforme a nova dosagem de cafeína em mg:");
    			   			
    			   			if(entrada == null) {
    			   				break;
    			   				
    			   			} else if(entrada == "") {
    			   				JOptionPane.showMessageDialog(null, "Informe uma dosagem!");
    			   				break;
    			   				
    			   			}
    			   			
    			   			int cafeina = Integer.parseInt(entrada);
    			   			
    			   			bebida.setCafeina(cafeina);
    			   			
    			   			if(cadastroProduto.editarProduto(bebida)) {
        		   				JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");
        		   			}
    			   			break;
    			   			
    			   		}
    			   		
    			   		case 7: {
    			   			boolean quente;
    			   			int entradaInt =  JOptionPane.showConfirmDialog(null,"O produto será quente?");
    			   			
    			   			if(entradaInt == JOptionPane.CANCEL_OPTION || entradaInt ==  JOptionPane.CLOSED_OPTION) {
    			         	   return;
    			         	   
    			            }
    			            quente = entradaInt == JOptionPane.YES_OPTION;
    			   			
    			   			bebida.setQuente(quente);
    			   			
    			   			if(cadastroProduto.editarProduto(bebida)) {
        		   				JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");
        		   			}
    			   			break;
    			   			
    			   		}
    			   		
    			   		case 8: {
    			   			break;
    			   		}
    			   		
    			   		default: {
    			   			JOptionPane.showMessageDialog(null, "Opção inválida");
    			   			break;
    			   		}
    			   }
    			   
    		   }
    		   
    	   }
    	   
      
}