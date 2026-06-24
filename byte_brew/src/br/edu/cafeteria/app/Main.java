package br.edu.cafeteria.app;
import br.edu.cafeteria.modelo.CadastroCliente;
import br.edu.cafeteria.modelo.CadastroProduto;
import br.edu.cafeteria.modelo.Cliente;
import br.edu.cafeteria.modelo.ClienteStandard;
import br.edu.cafeteria.modelo.GerenciadorPedidos;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		GerenciadorPedidos gerenciadorPedidos = new GerenciadorPedidos();
		CadastroCliente cadastroCliente = new CadastroCliente();
		CadastroProduto cadastroProduto = new CadastroProduto();
		
		MenuPrincipal menu = new MenuPrincipal(gerenciadorPedidos,cadastroCliente,cadastroProduto);
		menu.menuPrincipal();

	}
}
