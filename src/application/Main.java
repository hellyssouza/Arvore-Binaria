package application;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		Arvore arvore = null;
		int sair = 1;

		while (sair != 0) {

			try {
				Runtime.getRuntime().exec("cls");
			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println("1- inserir elemento na arvore.");
			System.out.println("2- remover elemento da arvore.");
			System.out.println("3- imprimir em ordem a arvore.");
			System.out.println("4- imprimir em pre ordem a arvore.");
			System.out.println("5- imprimir em pos ordem a arvore.");

			String escolha = leitor.nextLine() != null ? leitor.nextLine() : "";

			switch (escolha.charAt(0)) {
			case '1':
				break;
			case '2':
				break;
			case '3':
				break;
			case '4':
				break;
			case '5':
				break;
			case ' ':
				System.out.println("Informe um opção.");
				break;
			}
		}
	}
}
