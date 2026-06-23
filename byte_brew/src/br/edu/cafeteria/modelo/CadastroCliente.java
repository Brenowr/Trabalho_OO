package br.edu.cafeteria.modelo;

import java.util.ArrayList;

public class CadastroCliente {

		private ArrayList<Cliente> clientes;
		
		public CadastroCliente() {
			clientes = new ArrayList<>();
		}
		
		public Cliente buscarCliente(String cpf) {
			for(Cliente cliente : clientes) {
				if(cliente.getCpf().equals(cpf)) {
					return cliente;
				}
			}
			return null;
		}
		
		public boolean cadastrarCliente(Cliente cliente) {
			if(buscarCliente(cliente.getCpf()) != null) {
				return false;
			}
			clientes.add(cliente);
			return true;
		}
		
		public void listarClientes() {
			if(clientes.isEmpty()) {
				System.out.println("Nenhum cliente cadastrado.");
				return;
			}
			
			for(Cliente cliente : clientes) {
				System.out.println("Nome: "+cliente.getNome()+" | CPF: "+cliente.getCpf()+" | XP: "+cliente.getXp());
			}
		}
		
		public boolean removerCliente(String cpf) {
			Cliente cliente = buscarCliente(cpf);
			
			if(cliente == null) {
				return false;
			}
			clientes.remove(cliente);
			return true;
		}
		
		public boolean atualizarNomeCliente(String cpf, String novoNome) {
			Cliente cliente = buscarCliente(cpf);
			
			if(cliente == null) {
				return false;
			}
			cliente.setNome(novoNome);
			return true;
		}
		
		public int quantidadeCliente() {
			return clientes.size();
		}
}
