package models.sistema;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
	static int opcaoMenu=0;
	public static void getMenuPrincipal() {
		System.out.println("\nBanco OMEGA\n\nMenu principal");
		System.out.println("1 - Administrar Clientes");
		System.out.println("2 - Administrar Conta Corrente");
		System.out.println("3 - Sair");
	}

	public static void getMenuCliente() {
		System.out.println("\nBanco OMEGA\n\nAdministrar Carteira de Clientes");
		System.out.println("1 - Cadastrar cliente");
		System.out.println("2 - Listar clientes cadastrados");
		System.out.println("3 - ... ");
		System.out.println("4 - Sair");
	}

	public static void getMenuContaCorrente() {
		System.out.println("\nBanco OMEGA\n\nAdministrar Conta Corrente");
		System.out.println("1 - Realizar deposito");
		System.out.println("2 - Realizar saque");
		System.out.println("3 - Visualizar saldo");
		System.out.println("4 - Sair");
	}

	public static int getOpcaoMenuCC() {
		String opcaoUsuario = "";
		try{ 
			//JAVA exige try-catch para a entrada de dados
			BufferedReader in = new BufferedReader(new
					InputStreamReader(System.in));
			System.out.println("Digite sua opcao:");
			opcaoUsuario = in.readLine();
		} catch (IOException e) { // Catch any IO exceptions.
			e.printStackTrace();
		}
		return Integer.parseInt(opcaoUsuario);
	}

	public static void getOpcaoMenuUsuario(){
		String opcaoUsuarioString = "";
		int opcaoUsuario = 0;
		BufferedReader in = new BufferedReader(new
				InputStreamReader(System.in));
		do {
			try{ 
				//JAVA exige try-catch para a entrada de dados
				System.out.print("Digite sua opcao:");
				opcaoUsuarioString = in.readLine(); 
				Sistema.opcaoSelecionadaMenuPrincipal = Integer.parseInt(opcaoUsuarioString);
				if(Sistema.opcaoSelecionadaMenuPrincipal>0 && Sistema.opcaoSelecionadaMenuPrincipal<=4)
					break; //Forca o retorno para a instrucao seguinte onde o metodo getOpcaMenuPrincipal foi chamado a classe Sistema
				System.out.println("\nOpcao invalida!!!");
			} catch (IOException e) { // Catch any IO exceptions.
				e.printStackTrace();
			}
		}while(true);

		//		O gerenciamento de clientes pode possuir quantidade diferente de opcoes que o de Contaas Correntes
		//		Para deixar o codigo mais facil de ser entendido, vamos repetir o codigo para cada tipo de selecao.
		//		Isto nao precisaria ser realizado
		if(Sistema.opcaoSelecionadaMenuPrincipal == 1) {
			do {
				try{ 
					//JAVA exige try-catch para a entrada de dados
					System.out.print("Digite sua opcao:");
					opcaoUsuarioString = in.readLine();
					Sistema.opcaoSelecionadaCliente = Integer.parseInt(opcaoUsuarioString);
					if(opcaoUsuario>0 && opcaoUsuario<=4)
						return; 
					System.out.println("\nOpcao invalida!!!");
				} catch (IOException e) { // Catch any IO exceptions.
					e.printStackTrace();
				}
			}while(true);
		}
		else if(Sistema.opcaoSelecionadaMenuPrincipal == 2) {
			do {
				try{ 
					//JAVA exige try-catch para a entrada de dados
					System.out.print("Digite sua opcao:");
					opcaoUsuarioString = in.readLine();
					Sistema.opcaoSelecionadaContaCorrente = Integer.parseInt(opcaoUsuarioString);
					if(opcaoUsuario>0 && opcaoUsuario<=4)
						return;
					System.out.println("\nOpcao invalida!!!");
				} catch (IOException e) { // Catch any IO exceptions.
					e.printStackTrace();
				}
			}while(true);
		}
	}

}
