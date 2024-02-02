import java.text.DecimalFormat;
import java.util.Scanner;

public class ContaBanco {
    public static void main(String[] args) {
        // Cria um objeto scanner para receber a opção de conta do usuário
        Scanner leituraOpcaoConta = new Scanner(System.in);

        // Tipo de Conta
        String contaCorrente = "Conta Corrente";
        String contaPoupanca = "Conta Poupança";

        // Solicita que o usuário escolha o tipo de conta
        System.out.println("Escolha o tipo de conta:");
        System.out.println("1 - " + contaCorrente);
        System.out.println("2 - " + contaPoupanca);
        int opcaoConta = leituraOpcaoConta.nextInt();

        // Define o tipo de conta e o saldo com base na opção escolhida
        String tipoConta;
        double saldo;
        if (opcaoConta == 1) {
            tipoConta = contaCorrente;
            saldo = 5000.0; // Saldo inicial para Conta Corrente
        } else if (opcaoConta == 2) {
            tipoConta = contaPoupanca;
            saldo = 1500.0; // Saldo inicial para Conta Poupança
        } else {
            System.out.println("Opção inválida. Encerrando o programa.");
            return; // Encerra o programa se a opção for inválida
        }

        // Cria um objeto scanner para receber a senha do usuário
        Scanner leituraSenha = new Scanner(System.in);

        // Define a senha esperada pelo sistema e solicita que o usuário digite
        String senha = "senha123";
        System.out.println("Digite sua senha:");

        // Lê a senha digitada pelo usuário
        String senhaDigitada = leituraSenha.next();

        // Verifica se a senha digitada está correta
        if (senhaDigitada.equals(senha)) {
            System.out.println("Senha Correta. Bem-Vindo !!");

            // Informações da conta
            String nome = "Lucas Rodrigo Pinto";
            int opcao = 0;

            // Apresenta informações iniciais da conta
            System.out.println("**************************************");
            System.out.println("\nNome do Cliente: " + nome);
            System.out.println("Tipo da Conta: " + tipoConta);
            System.out.println("Saldo da Conta: " + saldo);
            System.out.println("\n**************************************");

            // Restante do código permanece o mesmo...

            // Menu de operações bancárias
            while (opcao != 5) {
                System.out.println("*** DIGITE A OPÇÃO ***");
                System.out.println("1 - CONSULTAR SALDO");
                System.out.println("2 - SACAR VALOR");
                System.out.println("3 - DEPOSITAR VALOR");
                System.out.println("4 - CONVERTER MOEDA");
                System.out.println("5 - ENCERRAR");
                opcao = leituraOpcaoConta.nextInt();

                // Executa a operação selecionada pelo usuário
                switch (opcao) {
                    case 1:
                        System.out.println("Saldo Atualizado: " + saldo);
                        break;
                    case 2:
                        // Operação de saque
                        System.out.println("Digite o valor de saque:");
                        double valor = leituraOpcaoConta.nextDouble();
                        if (valor > saldo) {
                            System.out.println("Não há saldo suficiente para o saque!");
                        } else {
                            saldo -= valor;
                            System.out.println("Saque concluído, novo saldo: " + saldo);
                        }
                        break;
                    case 3:
                        // Operação de depósito
                        System.out.println("Digite valor de depósito: ");
                        double deposito = leituraOpcaoConta.nextDouble();
                        saldo += deposito;
                        System.out.println("Depósito concluído, novo saldo: " + saldo);
                        break;
                    case 4:
                        // Menu de conversão de moeda
                        System.out.println("ESCOLHA QUAL MOEDA DESEJA CONVERTER:");
                        System.out.println("1 - DÓLAR");
                        System.out.println("2 - EURO");
                        System.out.println("3 - SAIR");
                        int escolhaConversao = leituraOpcaoConta.nextInt();
                        if (escolhaConversao == 1) {
                            // Conversão para Dólar
                            System.out.println("Digite o Valor que deseja converter para Dólar:");
                            double valorReal = leituraOpcaoConta.nextDouble();
                            double valorDolar = valorReal / 4.92;
                            System.out.println("Valor em Dólar: " + formatarDuasCasasDecimais(valorDolar));
                        } else if (escolhaConversao == 2) {
                            // Conversão para Euro
                            System.out.println("Digite o Valor que deseja converter para Euro:");
                            double valorReal = leituraOpcaoConta.nextDouble();
                            double valorEuro = valorReal / 5.32;
                            System.out.println("Valor em Euro: " + formatarDuasCasasDecimais(valorEuro));
                        } else if (escolhaConversao == 3) {
                            System.out.println("Saindo do menu de conversão.");
                        } else {
                            System.out.println("Opção inválida");
                        }
                        break;
                    case 5:
                        // Encerra o programa
                        System.out.println("Encerrando o programa. Obrigado!");
                        break;
                    default:
                        // Opção inválida
                        System.out.println("Opção Inválida");
                        break;
                }
            }
        } else {
            // Senha incorreta
            System.out.println("Senha Incorreta. Encerrando o Programa !!");
        }
    }

    // Método para formatar um valor com duas casas decimais
    private static String formatarDuasCasasDecimais(double valor) {
        DecimalFormat formato = new DecimalFormat("#.##");
        return formato.format(valor);
    }
}
