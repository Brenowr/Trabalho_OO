package br.edu.cafeteria.app;
import javax.swing.JOptionPane;

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
    	   String nomeProduto = JOptionPane.showInputDialog("Nome do produto:");
           double precoProduto = Double.parseDouble(JOptionPane.showInputDialog("Preço em R$:"));
           int estoque = Integer.parseInt(JOptionPane.showInputDialog("Quantidade em estoque:"));
           
           int tempoPreparo = Integer.parseInt(JOptionPane.showInputDialog("Tempo de preparo em minutos:"));

           boolean vegano = JOptionPane.showConfirmDialog(null,"É vegano?") == JOptionPane.YES_OPTION;

           boolean gluten = JOptionPane.showConfirmDialog(null,"Contém glútem?") == JOptionPane.YES_OPTION;

           boolean confeitaria = JOptionPane.showConfirmDialog(null,"É um produto de confeitaria?") == JOptionPane.YES_OPTION;

           Comida comida = new Comida(nomeProduto, precoProduto, estoque, tempoPreparo, vegano, gluten, confeitaria);
           
           cadastroProduto.cadastrarProduto(comida);
           JOptionPane.showMessageDialog(null,"Produto cadastrado com sucesso!");
           return;
       
    	   
       }
       
       private void cadastrarBebida() {
    	   String nomeProduto = JOptionPane.showInputDialog("Nome do produto:");
           double precoProduto = Double.parseDouble(JOptionPane.showInputDialog("Preço em R$:"));
           int estoque = Integer.parseInt(JOptionPane.showInputDialog("Quantidade em estoque:"));
           
           String tamanho = JOptionPane.showInputDialog("Tamanho (P, M ou G):");

           double cafeina = Double.parseDouble(JOptionPane.showInputDialog("Quantidade de cafeína em mg:"));

           boolean quente = JOptionPane.showConfirmDialog(null,"É uma bebida quente?") == JOptionPane.YES_OPTION;

           Bebida bebida = new Bebida(nomeProduto, precoProduto, estoque, tamanho, cafeina, quente);

           cadastroProduto.cadastrarProduto(bebida);
           JOptionPane.showMessageDialog(null,"Produto cadastrado com sucesso!");
           return;
       
       }
       
       private void buscarProduto() {
    	   String texto = "";
       	Produto produto = null;
       	int codigoProduto = 0;
       	String listaProduto = cadastroProduto.listarProdutos();
       	
       	if (listaProduto.isEmpty()) {
               JOptionPane.showMessageDialog(null, "Não há produtos cadastrados.");
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
       			  + " | É produzido na confeitaria: " + comida.getConfeitaria() + "\n";
       		
       	
       	}else {
       		Bebida bebida = (Bebida) produto;
       		texto += "Tamanho: " + bebida.getTamanho() + " | Contém cafeína: " + bebida.getCafeina() + " | É quente: " + bebida.getQuente() + "\n";
       		
       	}
       	
       	JOptionPane.showMessageDialog(null, texto);
       	return;
    	   
       }
       
       private void removerProduto() {
    	   String vef = cadastroProduto.listarProdutos();
    	   int codigoProduto = 0;
    	   
    	   if(vef == "") {
          		JOptionPane.showMessageDialog(null, "Não há produtos cadastrados");
          		return;
          	}
          	
    	   
       	String entradaProduto = JOptionPane.showInputDialog(null,"Informe o código do produto que deve ser removido:");
       	
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
    	   String lista = cadastroProduto.listarProdutos();
    	   
    	   if(lista.isEmpty()) {
    		   JOptionPane.showMessageDialog(null, "Não há produtos cadastrados");
    		   return;
    	   }
    	   
    	   JOptionPane.showMessageDialog(null, lista);
       }
       
       private void editarProdutos() {
    	   Produto produto;
    	   int selecionarProduto = 0;
    	   int codigoProduto;
    	   listarProdutos();
    	   codigoProduto = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do produto:"));
    	   
    	   cadastroProduto.buscarProduto(selecionarProduto);
    	   
    	   selecionarProduto = Integer.parseInt(JOptionPane.showInputDialog("Selecione sua opção:\n" ));
    			   																					
    	   
    	   
       }
       
       
       
       
}