package br.edu.cafeteria.app;

import javax.swing.JOptionPane;

public class MenuCliente {

    private int selecionar;
    private String entrada;

    public void menuCliente() {

        do {

            try {

                entrada = JOptionPane.showInputDialog("Selecione sua opcao:\n" +
                        							   "1: Cadastrar cliente\n" +
                        							   "2: Remover cliente\n" +
                        							   "3: Editar cliente\n" +
                        							   "4: Listar clientes\n" +
                        							   "5: Voltar ao menu Principal"
                );

                if (entrada == null) {
                    selecionar = 5;
                } else if (entrada.isEmpty()) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Digite uma opção!"
                    );
                    continue;
                } else {
                    selecionar = Integer.parseInt(entrada);
                }


                switch (selecionar) {

                    case 1: {

                        // cadastrarCliente();
                        JOptionPane.showMessageDialog(null, "Cadastro");

                        break;
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

                        // listarCliente();
                        JOptionPane.showMessageDialog(null, "Lista");

                        break;
                    }

                    case 5: {

                        break;
                    }

                    default: {

                        JOptionPane.showMessageDialog(
                                null,
                                "Opção inválida!"
                        );

                        break;
                    }
                }


            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(
                        null,
                        "Digite apenas números!"
                );
            }

        } while (selecionar != 5);
    }
}
