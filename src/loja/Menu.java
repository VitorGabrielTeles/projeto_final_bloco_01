package loja;

import java.util.Scanner;
import java.io.IOException;

import loja.model.Jogo;
import loja.controller.ControllerJogo;
import loja.util.Cores;

public class Menu {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        ControllerJogo controller = new ControllerJogo();

        int opcao;

        while (true) {
            System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND);
            System.out.println("*****************************************************");
            System.out.println("                  LOJA DE JOGOS DIGITAIS             ");
            System.out.println("*****************************************************");
            System.out.println("            1 - Listar Jogos Disponíveis             ");
            System.out.println("            2 - Adicionar Jogo ao Carrinho           ");
            System.out.println("            3 - Remover Jogo do Carrinho             ");
            System.out.println("            4 - Visualizar Carrinho                  ");
            System.out.println("            5 - Finalizar Compra                     ");
            System.out.println("            6 - Sair                                 ");
            System.out.println("*****************************************************");
            System.out.print("Escolha uma opção: ");

            opcao = leia.nextInt();
            leia.nextLine();

            if (opcao == 6) {
                System.out.println("\nObrigado por visitar a Loja de Jogos!");
                sobre();
                leia.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1:
                    System.out.println("Jogos Disponíveis:");
                    controller.listarJogos();
                    keyPress();
                    break;

                case 2:
                    System.out.print("Digite o ID do jogo que deseja adicionar ao carrinho: ");
                    int idAdd = leia.nextInt();
                    controller.adicionarAoCarrinho(idAdd);
                    keyPress();
                    break;

                case 3:
                    System.out.print("Digite o ID do jogo que deseja remover do carrinho: ");
                    int idRemover = leia.nextInt();
                    controller.removerDoCarrinho(idRemover);
                    keyPress();
                    break;

                case 4:
                    System.out.println("Jogos no Carrinho:");
                    controller.visualizarCarrinho();
                    keyPress();
                    break;

                case 5:
                    double total = controller.getTotal();
                    System.out.printf("Compra finalizada! Valor total: R$ %.2f%n", total);
                    //controller.finalizarCompra();
                    keyPress();

                    System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND);
                    System.out.println("\nEscolha a forma de pagamento:");
                    System.out.println("1 - Cartão de Crédito");
                    System.out.println("2 - Boleto Bancário");
                    System.out.println("3 - PIX");
                    System.out.print("Opção: ");
                    int pagamento = leia.nextInt();
                    leia.nextLine();

                    switch (pagamento) {
                        case 1:
                            System.out.print("Digite o número de parcelas (até 12): ");
                            int parcelas = leia.nextInt();
                            leia.nextLine();

                            if (parcelas >= 1 && parcelas <= 12) {
                                double valorParcela = total / parcelas;
                                System.out.printf("Pagamento aprovado! Parcelado em %dx de R$ %.2f no Cartão de Crédito.%n", parcelas, valorParcela);
                            } else {
                                System.out.println("Número de parcelas inválido. Pagamento não realizado.");
                            }
                            break;
                        case 2:
                            System.out.println("Boleto gerado. Pagamento será compensado em até 3 dias úteis.");
                            break;
                        case 3:
                            System.out.println("Chave PIX: loja@jogos.com.br");
                            System.out.println("Pagamento via PIX aprovado!");
                            break;
                        default:
                            System.out.println("Opção de pagamento inválida.");
                            break;              
                    }
                    controller.finalizarCompra();
                    keyPress();
                    break;

                default:
                    System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n");
                    keyPress();
                    break;
            }
        }
    }

    public static void sobre() {
        System.out.println("\n*********************************************************");
        System.out.println("Projeto Desenvolvido por: Vitor Teles ");
        System.out.println("Email: vitorl@genstudents.org");
        System.out.println("Github: https://github.com/VitorGabrielTeles");
        System.out.println("*********************************************************");
    }

    public static void keyPress() {
        try {
            System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
            System.in.read();
        } catch (IOException e) {
            System.out.println("Você pressionou uma tecla diferente de enter!");
        }
    }
}
