package models.administrativo;

import  java.util.*;
import javax.swing.*;

import models.financeiro.ContaCorrente;
import models.sistema.Numero;

import java.lang.*;

public class Banking{
	private ArrayList clientes;   
	private String nomeDoBanco;
	private int coClienteAtual;

	public Banking(){
		clientes = new ArrayList();
		coClienteAtual = 0;
	}

	public Banking(String nomeDoBanco){
		this.nomeDoBanco = nomeDoBanco;	
		clientes = new ArrayList();
		coClienteAtual = 0;
	}

	public void adicionarCliente() {
		coClienteAtual++;

		Cliente cliente = new Cliente();
		cliente.setCoCliente(coClienteAtual);
		cliente.solicitaDados();
		cliente.adicionarCC();
		cliente.administraCliente();
		clientes.add(cliente);
	}

	private void visualizaListaDeClientesComCC(){
		JTextArea outPutArea = new JTextArea(7,10);
		String nomesClientes="NAO EXISTEM CLIENTES CADASTRADOS!!!"; 
		Cliente c = new Cliente();
		for(int m=0; m < clientes.size(); m++){ 
			if(m==0) 
				nomesClientes = "";
			c = (Cliente) clientes.get(m);
			nomesClientes += "\n\n" + c.getNome() +"\n    Conta(s) corrente(s)          " + c.retornacontasCorrentesXK();// c.retornaContasCorrentes();
		}
		JOptionPane.showMessageDialog(null, nomesClientes, "Clientes", JOptionPane.INFORMATION_MESSAGE);
	}

	private void visualizaCarteiraDeClientes(){
		String mensagem="NAO EXISTEM CLIENTES CADASTRADOS!!!", opcao; 
		Cliente c = new Cliente();
		int opcaoInt = 0;

		//Não existe pessoas cadastradas
		if(clientes.size() == 0){
			JOptionPane.showMessageDialog(null, mensagem, "Clientes", JOptionPane.INFORMATION_MESSAGE);
			return;                     
		}

		//Montando a string com o código e o nome das pessoas cadastradas para usuário visualizar/selecionar
		for(int m=0; m < clientes.size(); m++){ 
			if(m==0) 
				mensagem = "";
			c = (Cliente) clientes.get(m);
			mensagem += "\n" + c.getCoCliente() + " - " + c.getNome() ;
		}


		mensagem += "\n\nDigite o código do cliente desejado para gerenciar ou zero para sair!";
		opcao = JOptionPane.showInputDialog(mensagem);
		opcaoInt = Integer.parseInt(opcao);

		//Usuario selecionou opção sair
		if(opcaoInt==0)
			return;

		//Usuario digitou outro número. O laço abaixo proura na collection se existe o código digitado
		for(int m=0; m < clientes.size(); m++){ 
			c = (Cliente) clientes.get(m);
			if(c.getCoCliente() == opcaoInt){
				c.administraCliente();
				return;
			}
		}

		JOptionPane.showMessageDialog(null, mensagem, "Clientes", JOptionPane.INFORMATION_MESSAGE);
	}

	public void procuraConta(){
		//Dada a conta, procura cliente que a possui e referencia o mesmo por objeto Cliente
		//referenciando a conta do mesmo por objeto ContaCorrente
		String s="", mensagem = "Digite o numero da conta:";
		ContaCorrente contaCorrenteProcurada= new ContaCorrente();
		contaCorrenteProcurada = null;
		Cliente cliente = new Cliente();
		int conta=0;

		s = JOptionPane.showInputDialog(mensagem);
		conta = Integer.parseInt(s);

		for(int m=0; m < clientes.size(); m++){
			cliente = (Cliente) clientes.get(m);
			contaCorrenteProcurada = cliente.retornaContaCorrente(conta);
			if(contaCorrenteProcurada != null)
				break;
		}
		if(contaCorrenteProcurada == null)
			JOptionPane.showMessageDialog(null, "Nao existe conta corrente cadastrada com este numero!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
		else{
			//			contaCorrenteProcurada. administraConta();
			cliente.administraCliente();
		}
	}

	/*  	public void imprimeTodosOsDados() {
		ContaCorrente cc;

		super.imprimeTodosOsDados();
		for(int m=0; m<ContasCorrente.size(); m++){
			System.out.println("\nDados da pessoa " + (m+1));
			cc = (ContaCorrente) ContasCorrente.get(m);
			cc.mostraDadosDaConta();
		}

	}*/
	private void pesquisaCliente(){
		String s, listaDeClientes, mensagemAdicional = "\n\nNenhum cliente localizado";

		s = JOptionPane.showInputDialog("Digite fragmento do nome do cliente");            
		listaDeClientes = "Clientes que possuem o fragmento '" + s + "' no nome\n\n";

		Cliente c = new Cliente();
		for(int m=0; m < clientes.size(); m++){ 
			c = (Cliente) clientes.get(m);
			if(c.getNome().indexOf(s)>=0){
				listaDeClientes += "\n" + c.getNome();
				mensagemAdicional = "";
			}
		}

		listaDeClientes += mensagemAdicional;

		JOptionPane.showMessageDialog(null, listaDeClientes, "Clientes", JOptionPane.INFORMATION_MESSAGE);
	}


	public void administraBanco(){
		String s="";
		String mensagem =  nomeDoBanco + "\n\n\nOpcoes de adiministraçao da agencia: ";
		mensagem += "\n\n1-  Adicionar cliente\n2-  Visualizar clientes/contas correntes";
		mensagem += "\n3-  Pesquisar cliente";
		mensagem += "\n4-  Pesquisar conta corrente";
		mensagem += "\n5-  Visualizar carteira de clientes";
		mensagem += "\n6-  Visualizar contas corrente com saldo negativo";
		mensagem += "\n7-  Encerrar administracao da agencia\n\n";

		int opcao=0;

		for(;;){
			try{
				opcao = Numero.getNumeroInteiro(mensagem);
				switch(opcao){
				case 1:
					adicionarCliente();    
					break;
				case 2:
					visualizaListaDeClientesComCC();
					break;
				case 3:
					pesquisaCliente();                                        
					break;
				case 4:
					procuraConta();
					break;
				case 5:
					visualizaCarteiraDeClientes();
					break;
				case 6:
					JOptionPane.showMessageDialog(null, "Opcao não implementada!\nDigite novamente!", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
					break;
				case 7:
					return;
				default:
					JOptionPane.showMessageDialog(null, "Na foi digitada opcao valida!\nDigite novamente!", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
				}
			}
			catch (java.lang.NumberFormatException e) { // Catch any IO exceptions.
				JOptionPane.showMessageDialog(null, "Na foi digitada opcao valida!\nDigite novamente!", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
