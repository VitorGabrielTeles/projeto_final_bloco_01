package loja;
import java.io.IOException;
import java.util.Scanner;

import loja.util.Cores;
public class Menu {
	 public static void main(String[] args) {

	        Scanner leia = new Scanner(System.in);

	        int opcao, id;
	        String nomeCliente;

	        while (true) {
	            System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND);
	            System.out.println("*****************************************************");
	            System.out.println("                  LOJA DE JOGOS DIGITAIS             ");
	            System.out.println("*****************************************************");
	            System.out.println("                                                     ");
	            System.out.println("            1 - Listar Jogos Disponíveis             ");
	            System.out.println("            2 - Adicionar Jogo ao Carrinho           ");
	            System.out.println("            3 - Remover Jogo do Carrinho             ");
	            System.out.println("            4 - Visualizar Carrinho                  ");
	            System.out.println("            5 - Finalizar Compra                     ");
	            System.out.println("            6 - Sair                                 ");
	            System.out.println("                                                     ");
	            System.out.println("*****************************************************");
	            System.out.println("Escolha uma opção: ");
	            
	            opcao = leia.nextInt();

	            if (opcao == 6) {
	                System.out.println("\nObrigado por visitar a Loja de Jogos!");
	                sobre();
	                leia.close();
	                System.exit(0);
	            }

	            switch (opcao) {
	                case 1:
	                    System.out.println(Cores.TEXT_GREEN + "Listando Jogos Disponíveis...\n");
	                    keyPress();
	                    break;

	                case 2:
	                    System.out.println(Cores.TEXT_GREEN + "Adicionar Jogo ao Carrinho\n");
	                    keyPress();
	                    break;

	                case 3:
	                    System.out.println(Cores.TEXT_GREEN + "Remover Jogo do Carrinho\n");
	                    keyPress();
	                    break;

	                case 4:
	                    System.out.println(Cores.TEXT_GREEN + "Visualizar Carrinho\n");
	                    keyPress();
	                    break;

	                case 5:
	                    System.out.println(Cores.TEXT_GREEN + "Finalizar Compra\n");
	                    keyPress();
	                    break;

	                default:
	                    System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n");
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


