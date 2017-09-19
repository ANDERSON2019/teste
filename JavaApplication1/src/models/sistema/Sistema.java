package models.sistema;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import models.administrativo.AdministraCliente;
import models.administrativo.Cliente;
import models.financeiro.ContaCorrente;

public class Sistema {
//	Relacionaas as opcoes de menu
	public static int opcaoSelecionadaMenuPrincipal = 0;
	public static int opcaoSelecionadaCliente= 0;
	public static int opcaoSelecionadaContaCorrente= 0;
	/*
	 * 1 Adm clientes
	 * 2 Adm Conta Corrente
	 * */
	
//	Variáveis relacionadas a numeracao dos clientes e das contas correntes 
	public static int codigoAtualCliente = 0;
	public static int numeroAtualContaCorrente = 0;		

//	ArrayLists para armazenamento de objetos Cliente e ContaCorrente
	public static ArrayList clientesArrayList = new ArrayList<>();
	public static ArrayList contasCorrentesArrayList = new ArrayList<>();

	public static void setarOpcaoSelecionada() {   
		opcaoSelecionadaMenuPrincipal = Numero.getNumeroInteiro("Digite sua opcao: ");
		if(opcaoSelecionadaMenuPrincipal == 1) {
			System.out.println("Selecionada Opcao Gerenciar Cliente");
			
			Menu.getMenuCliente();
			
			opcaoSelecionadaCliente = Numero.getNumeroInteiro("Digite a opcao de Gerenciamento de Cliente");
			if(opcaoSelecionadaCliente==1) {
				System.out.println("Selecionada opção CADASTRAR CLIENTE");
				Cliente novoCliente = new Cliente();
				novoCliente = (Cliente)AdministraCliente.incluirCliente();
				clientesArrayList.add(novoCliente);
				 
			}
			else if(opcaoSelecionadaCliente==2) {
				System.out.println("Selecionada opção LISTAR CLIENTES CADASTRADOS");
				AdministraCliente.imprimeClientesCadastrados();
			}
			else if(opcaoSelecionadaCliente==3) {
//				System.out.println("Selecionada opção ...");
			}
		}
		else if(opcaoSelecionadaMenuPrincipal == 2) {
			ContaCorrente cc = new ContaCorrente();	
			System.out.println("Selecionada Opcao Gerenciar Conta Corrente");
			Menu.getMenuContaCorrente();
			opcaoSelecionadaContaCorrente = Numero.getNumeroInteiro("Digite a opcao de gerenciamento de Conta Corrente");
			if(opcaoSelecionadaContaCorrente==1) {
				System.out.println("Selecionada opção REALIZAR DEPOSITO");
				cc.realizarDeposito();
			}
			else if(opcaoSelecionadaContaCorrente==2) {
				System.out.println("Selecionada opção REALIZAR SAQUE");
				cc.realizarSaque();
			}
			else if(opcaoSelecionadaContaCorrente==3) {
				System.out.println("Selecionada opção VISUALIZAR SALDO");
				cc.mostrarSaldo();
			}
		}

	}

	public static void apresentaUISelecaoOpcoesDoSistema() {
		int opcao = 0;
		boolean apresentarOpcoesParaUsuario =  true;
		Menu.getMenuPrincipal();
		setarOpcaoSelecionada();   
	}

	public static void apresentaUISelecaoOpcoesAdmCC() {
		ContaCorrente cc = new ContaCorrente();
		boolean apresentarOpcoesParaUsuario =  true;
//		do {
//			Menu.getMenuContaCorrente();
//			Menu.getOpcaoMenuUsuario();
////			Tratando a opcao selecionada pelo usuario
//				
//			
//			//			apresentarOpcoesParaUsuario = setarOpcaoSelecionada(opcao);
//			//		}while(apresentarOpcoesParaUsuario);
//		}while(setarOpcaoSelecionada());
	}
}