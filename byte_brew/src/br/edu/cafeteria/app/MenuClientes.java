package br.edu.cafeteria.app;

import javax.swing.JOptionPane;

import br.edu.cafeteria.modelo.CadastroCliente;
import br.edu.cafeteria.modelo.Cliente;
import br.edu.cafeteria.modelo.ClienteStandard;

import br.edu.cafeteria.excecao.NomeInvalidoException;
import br.edu.cafeteria.excecao.CpfInvalidoException;
import br.edu.cafeteria.excecao.CpfDuplicadoException;
import br.edu.cafeteria.excecao.ClienteNaoEncontradoException;

public class MenuClientes {

    private int selecionar;
    private String entrada;
    private CadastroCliente cadastroClientes;
    
    public MenuClientes(CadastroCliente cadastroClientes) {

        this.cadastroClientes = cadastroClientes;
    }

    public void menuClientes() {

        do {

            try {

                entrada = JOptionPane.showInputDialog("Selecione sua opcao:\n" +
                        							   "1: Cadastrar cliente\n" +
                        							   "2: Buscar cliente\n" +
                        							   "3: Remover cliente\n" +
                        							   "4: Editar cliente\n" +
                        							   "5: Listar clientes\n" +
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
                    cadastrarCliente();
                    break;
                }

                case 2: {
                    buscarCliente();
                    break;
                }

                case 3: {
                    removerCliente();
                    break;
                }

                case 4: {
                    editarCliente();
                    break;
                }

                case 5: {
                    JOptionPane.showMessageDialog(null, cadastroClientes.listarClientes());
                    break;
                }

                case 6: {
                    break;
                }

                default: {
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
                }                }


            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(null,"Digite apenas números!");
            }

        } while (selecionar != 6);
    }


    private void cadastrarCliente() {

        try {

            String nome;
            String cpf;

            nome = JOptionPane.showInputDialog("Digite o nome do cliente:");

            if (nome == null || nome.isBlank()) {
                JOptionPane.showMessageDialog(null, "Digite um nome válido!");
                return;
            }

            // Não permite números no nome
            if (nome.matches(".*\\d.*")) {
                JOptionPane.showMessageDialog(null, "O nome deve conter apenas letras!");
                return;
            }

            cpf = JOptionPane.showInputDialog("Digite o CPF:");

            if (cpf == null || cpf.isBlank()) {
                JOptionPane.showMessageDialog(null, "Digite um CPF válido!");
                return;
            }

            // Não permite letras no CPF
            if (!cpf.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "O CPF deve conter apenas números!");
                return;
            }

            ClienteStandard cliente = new ClienteStandard(nome, cpf);

            cadastroClientes.cadastrarCliente(cliente);

            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");

        } catch (NomeInvalidoException | CpfInvalidoException | CpfDuplicadoException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }
    
    private void buscarCliente() {

        try {

            String cpf = JOptionPane.showInputDialog("Digite o CPF do cliente:");

            if (cpf == null || cpf.isBlank()) {
                JOptionPane.showMessageDialog(null, "Campo do CPF vazio!");
                return;
            }

            Cliente cliente = cadastroClientes.buscarCliente(cpf);

            String texto = "Nome: " + cliente.getNome()
                    + "\nCPF: " + cliente.getCpf()
                    + "\nXP: " + cliente.getXp();

            JOptionPane.showMessageDialog(null, texto);

        } catch (ClienteNaoEncontradoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void removerCliente() {

        try {

            String cpf = null;

            String entradaCpf = JOptionPane.showInputDialog(
                    null,
                    "Informe o CPF do cliente que deve ser removido:"
            );

            if (entradaCpf == null) {
                return;

            } else if (entradaCpf.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Digite um CPF válido!");
                return;

            } else {
                cpf = entradaCpf;
            }

            cadastroClientes.removerCliente(cpf);

            JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");

        } catch (ClienteNaoEncontradoException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }

    private void editarCliente() {

        String lista = cadastroClientes.listarClientes();

        if (lista.equals("Nenhum cliente cadastrado.")) {
            JOptionPane.showMessageDialog(null, "Não há clientes cadastrados.");
            return;
        }

        try {

            String cpf = JOptionPane.showInputDialog(
                    null,
                    lista + "\nDigite o CPF do cliente que deseja editar:"
            );

            if (cpf == null) {
                return;
            }

            if (cpf.isBlank()) {
                JOptionPane.showMessageDialog(null, "Digite um CPF válido!");
                return;
            }

            cadastroClientes.buscarCliente(cpf);

            int selecionarSub = 0;

            do {

                try {

                    String entradaSub = JOptionPane.showInputDialog(
                            null,
                            "Selecione o que deseja editar:\n"
                            + "1: Editar nome\n"
                            + "2: Editar CPF\n"
                            + "3: Voltar ao menu"
                    );

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
                            editarNomeCliente(cpf);
                            break;

                        case 2:
                            editarCpfCliente(cpf);
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

        } catch (ClienteNaoEncontradoException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }
    
    private void editarNomeCliente(String cpf) {
    	// TODO Auto-generated method stub

    	}
    private void editarCpfCliente(String cpf) {
    	// TODO Auto-generated method stub

    	}
    
    
}

