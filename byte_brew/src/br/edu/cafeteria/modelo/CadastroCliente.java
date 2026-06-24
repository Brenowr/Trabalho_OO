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
			if(!nomeValido(cliente.getNome())) {
				return false;
			}
			
			if(!cpfValido(cliente.getCpf())) {
				return false;
			}
			
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
			
			System.out.println(">>> CLIENTES CADASTRADOS <<<");
			
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
			if(!nomeValido(novoNome)) {
				return false;
			}
			cliente.setNome(novoNome);
			return true;
		}
		
		public int quantidadeCliente() {
			return clientes.size();
		}
		
		public boolean promoverParaVip(String cpf) {
			Cliente cliente = buscarCliente(cpf);
			
			if(cliente == null) { //cliente nao encontrado
				return false;
			}
			if(!(cliente instanceof ClienteStandard)) { //já é vip
				return false;
			}
			if(cliente.getXp() < 100) { //sem xp suficiente
				return false;
			}
			
			ClienteVip vip = new ClienteVip(cliente.getNome(), cliente.getCpf());
			vip.adicionarXP(cliente.getXp());
			clientes.remove(cliente);
			clientes.add(vip);
			return true;
		}
		
		private boolean nomeValido(String nome) {
			if(nome == null || nome.isBlank()) {
				return false;
			}
			return true;
		}
		
		private boolean cpfValido(String cpf) {
			if(cpf == null || cpf.isBlank()) {
				return false;
			}
			
			cpf = cpf.trim(); //remove espaços do inicio e fim
			return cpf.matches("\\d{11}"); //exatamente 11 caracteres
		}
}
