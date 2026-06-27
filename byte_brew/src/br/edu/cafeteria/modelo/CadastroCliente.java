package br.edu.cafeteria.modelo;

import java.util.ArrayList;
import br.edu.cafeteria.excecao.NomeInvalidoException;
import br.edu.cafeteria.excecao.CpfInvalidoException;
import br.edu.cafeteria.excecao.CpfDuplicadoException;
import br.edu.cafeteria.excecao.ClienteNaoEncontradoException;

public class CadastroCliente {

		private ArrayList<Cliente> clientes;
		
		public CadastroCliente() {
			clientes = new ArrayList<>();
		}
		
		public Cliente buscarCliente(String cpf) throws ClienteNaoEncontradoException{
			for(Cliente cliente : clientes) {
				if(cliente.getCpf().equals(cpf)) {
					return cliente;
				}
			}
			throw new ClienteNaoEncontradoException();
		}
		
		public boolean cadastrarCliente(Cliente cliente) 
		        throws NomeInvalidoException, CpfInvalidoException, CpfDuplicadoException {

		    if (!nomeValido(cliente.getNome())) {
		        throw new NomeInvalidoException();
		    }

		    if (!cpfValido(cliente.getCpf())) {
		        throw new CpfInvalidoException();
		    }

		    if (cpfJaExiste(cliente.getCpf())) {
		        throw new CpfDuplicadoException();
		    }

		    clientes.add(cliente);
		    return true;
		}
		
		public String listarClientes() {

		    if (clientes.isEmpty()) {
		        return "Nenhum cliente cadastrado.";
		    }

		    String texto = ">>> CLIENTES CADASTRADOS <<<\n\n";

		    for (Cliente cliente : clientes) {
		        texto += "Nome: " + cliente.getNome()
		              + " | CPF: " + cliente.getCpf()
		              + " | XP: " + cliente.getXp()
		              + "\n";
		    }

		    return texto;
		}
		
		public boolean removerCliente(String cpf) throws ClienteNaoEncontradoException {
			Cliente cliente = buscarCliente(cpf);
			
			clientes.remove(cliente);
			return true;
		}
		
		public boolean atualizarNomeCliente(String cpf, String novoNome)
		        throws NomeInvalidoException, ClienteNaoEncontradoException {

		    Cliente cliente = buscarCliente(cpf);

		    if(!nomeValido(novoNome)) {
		        throw new NomeInvalidoException();
		    }

		    cliente.setNome(novoNome);
		    return true;
		}
		
		public boolean atualizarCpfCliente(String cpfAtual, String novoCpf)
		        throws ClienteNaoEncontradoException, CpfInvalidoException, CpfDuplicadoException {

		    Cliente cliente = buscarCliente(cpfAtual);

		    if (!cpfValido(novoCpf)) {
		        throw new CpfInvalidoException();
		    }

		    if (cpfJaExiste(novoCpf)) {
		        throw new CpfDuplicadoException();
		    }

		    cliente.setCpf(novoCpf);

		    return true;
		}
		
		public int quantidadeCliente() {
			return clientes.size();
		}
		
		public boolean promoverParaVip(String cpf)
		        throws ClienteNaoEncontradoException {

		    Cliente cliente = buscarCliente(cpf);

		    if(!(cliente instanceof ClienteStandard)) {
		        return false;
		    }

		    if(cliente.getXp() < 100) {
		        return false;
		    }

		    ClienteVip vip = new ClienteVip(cliente.getNome(), cliente.getCpf());

		    vip.adicionarXP(cliente.getXp());

		    clientes.add(vip);
		    clientes.remove(cliente);

		    return true;
		}
		
		private boolean nomeValido(String nome) {

		    if (nome == null || nome.isBlank()) {
		        return false;
		    }

		    return nome.matches("[a-zA-ZÀ-ÿ ]+");
		}
		
		private boolean cpfJaExiste(String cpf) {
		    for (Cliente cliente : clientes) {
		        if (cliente.getCpf().equals(cpf)) {
		            return true;
		        }
		    }
		    return false;
		}
		
		private boolean cpfValido(String cpf) {
			if(cpf == null || cpf.isBlank()) {
				return false;
			}
			
			cpf = cpf.trim(); //remove espaços do inicio e fim
			return cpf.matches("\\d{11}"); //exatamente 11 caracteres
		}
}
