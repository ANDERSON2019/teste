package models.administrativo;

import  java.util.*;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

import models.financeiro.ContaCorrente;
import models.sistema.ClasseString;
import models.sistema.Sistema;

public class Cliente{
	private ArrayList contasCorrente, aplicacoesFinanceira, emprestimos;
	private String nome = "", RG="";
	private int coCliente;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cliente(){
		contasCorrente = new ArrayList();
		aplicacoesFinanceira = new ArrayList();
		emprestimos = new ArrayList();
	}

	public int getCoCliente(){
		return coCliente;
	}

	public void setCoCliente(int coCliente){
		this.coCliente = coCliente;
	}

	public void solicitaDados() {
		nome = ClasseString.getString("Digite o nome do cliente: ");
	}

	public void administraCliente(){
		String s="", mensagem = "Cliente:" + getNome() +"\n\nOpcoes de adiministracao do cliente";
		//		mensagem += "\n1-Alterar nome do cliente\n2-Adicionar conta\n3-Ver dados das contas\n";
		mensagem += "\n1-Alterar nome do cliente\n2-Administrar contas correntes";
		mensagem += "\n3-Administrar empréstimos bancários\n4-Encerrar administracao do cliente";
		int opcao=0;
		for(;;){
			try{
				s = JOptionPane.showInputDialog(mensagem);
				opcao = Integer.parseInt(s);
				switch(opcao){
				case 1:
					//						super.solicitaNome();
					break;
				case 2:
					administraContasCorrentes();
					break;
				case 3:
					admistraEmprestimos();
					break;
				case 4:
					return;
				}
			}
			catch (java.lang.NumberFormatException e) { // Catch any IO exceptions.
				JOptionPane.showMessageDialog(null, "Na foi digitada opcao valida!\nDigite novamente!", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void administraContasCorrentes(){
		String s="", mensagem = "Cliente:" + getNome() +"\n\nOpcoes de adiministracao de empréstimos";
		mensagem += "\n1-Adicionar conta corrente\n2-Visualizar contas correntes\n3-Encerrar administracao de contas correntes do cliente";
		int opcao=0;
		for(;;){
			try{
				s = JOptionPane.showInputDialog(mensagem);
				opcao = Integer.parseInt(s);
				switch(opcao){
				case 1:
					adicionarCC();
					break;
				case 2:
					imprimeContasCorrentes();
					break;
				case 3:
					return;
				}
			}
			catch (java.lang.NumberFormatException e) { // Catch any IO exceptions.
				JOptionPane.showMessageDialog(null, "Na foi digitada opcao valida!\nDigite novamente!", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	private void admistraEmprestimos(){
		String s="", mensagem = "Cliente:" + getNome() +"\n\nOpcoes de adiministracao de empréstimos";
		mensagem += "\n1-Adicionar empréstimo\n2-Visualizar empréstimos bancários\n3-Encerrar administracao de empréstimos cliente";
		int opcao=0;
		for(;;){
			try{
				s = JOptionPane.showInputDialog(mensagem);
				opcao = Integer.parseInt(s);
				switch(opcao){
				case 1:
					adicionaEmprestimoBancario();
					break;
				case 2:
					//						visualizaEmprestimosBancarios();
					break;
				case 3:
					return;
				}
			}
			catch (java.lang.NumberFormatException e) { // Catch any IO exceptions.
				JOptionPane.showMessageDialog(null, "Na foi digitada opcao valida!\nDigite novamente!", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	public void adicionarCC() {
		ContaCorrente conta = new ContaCorrente();
		conta.realizarDeposito();
		conta.setNumeroContaCorrente(++Sistema.numeroAtualContaCorrente);
		contasCorrente.add(conta);
		conta.mostraDadosDaConta();
	}

	private double solicitaValorReal(String mensagem){
		double valor=0;
		String s;  		
		for(;;){
			try{
				s = JOptionPane.showInputDialog("Digite o valor do " + mensagem + ":");
				valor = Double.parseDouble(s);
				if(valor >=0)
					break;
				JOptionPane.showMessageDialog(null, "Valor negativo nao e permitido!\nDigite novamente!", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
			} catch (java.lang.NumberFormatException e) { // Catch any IO exceptions.
				JOptionPane.showMessageDialog(null, "Na foi digitado valor valido!\nDigite novamente!", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
			}
		}
		return valor;		 
	}

	private int solicitaValorInteiro(String mensagem){
		int valor=0;
		String s;  		
		for(;;){
			try{
				s = JOptionPane.showInputDialog("Digite o valor do " + mensagem + ":");
				valor = Integer.parseInt(s);
				if(valor >=0)
					break;
				JOptionPane.showMessageDialog(null, "Valor negativo nao e permitido!\nDigite novamente!", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
			} catch (java.lang.NumberFormatException e) { // Catch any IO exceptions.
				JOptionPane.showMessageDialog(null, "Na foi digitado valor valido!\nDigite novamente!", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
			}
		}
		return valor;

	}


	//  	private void visualizaEmprestimosBancarios(){
	//		EmprestimoBancario eb;
	//	
	//                if(emprestimos.size()==0)
	//                    JOptionPane.showMessageDialog(null, "O cliente não possui empréstimos bancários nesta agencia!", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
	//		for(int m=0; m<emprestimos.size(); m++){
	//			System.out.println("\nDados da pessoa " + (m+1));
	//			eb = (EmprestimoBancario) emprestimos.get(m);
	//			eb.mostraDadosDoEmprestimo(); 
	//		}
	//  		
	//  	}

	public void adicionaEmprestimoBancario() {
		double valorEmprestimo = 0;
		int qtdMesesEmprestimo = 0;
		double taxaDeJurosEmprestimo = 0;

		try{

			valorEmprestimo = solicitaValorReal("Digite o valor do emprestimo");
			qtdMesesEmprestimo = solicitaValorInteiro("Digite a quantidade de meses do emprestimo");
			taxaDeJurosEmprestimo = solicitaValorReal("Digite a taxa de juros");
		}
		catch(Exception e){
		}
		//Declarando objeto da classe emprestimo bancario
		//		EmprestimoBancario emprestimoBancario= new EmprestimoBancario();

		//Prenchendo os dados do objeto criado
		//		emprestimoBancario.realizarEmprestimo(valorEmprestimo, qtdMesesEmprestimo, taxaDeJurosEmprestimo);

		//Adicionando novo objeto Emprestimo bancario no Array de emprestimos
		//		emprestimos.add(emprestimoBancario);
	}

	public String retornacontasCorrentesXK(){
		ContaCorrente cc;
		String contas="";
		DecimalFormat doisDigitos = new DecimalFormat("0.00");
		for(int m=0; m<contasCorrente.size(); m++){
			System.out.println("\nDados da pessoa " + (m+1));
			cc = (ContaCorrente) contasCorrente.get(m);
			contas += "        cc:" + cc.getNumeroContaCorrente() +"(R$)"+ doisDigitos.format(cc.getSaldo());
		}
		return contas;		
	}

	public ContaCorrente retornaContaCorrente(int numeroDaConta){
		//caso encontre conta corrente com o numero indicado, retorna a mesma
		//caso contrario, retorna null
		ContaCorrente cc = new ContaCorrente();
		for(int m=0; m<contasCorrente.size(); m++){
			cc = (ContaCorrente) contasCorrente.get(m);
			if(cc.getNumeroContaCorrente() == numeroDaConta) 
				return cc;
		}
		return null;		
	}

	public void imprimeTodosOsDados() { 
		ContaCorrente cc;
		String result;
		result = "Dados cadastrais\nNome:" + nome
				+ "\nRG:" + RG; 
		System.out.println(result);
		for(int m=0; m<contasCorrente.size(); m++){
			System.out.println("\nContas correntes" + (m+1));
			cc = (ContaCorrente) contasCorrente.get(m);
			//			cc.mostraDadosDaConta();
		}  
	}
	
	public void imprimeContasCorrentes() {
		ContaCorrente cc;
		for(int m=0; m<contasCorrente.size(); m++){
			System.out.println("\nDados da pessoa " + (m+1));
			cc = (ContaCorrente) contasCorrente.get(m);
			cc.mostraDadosDaConta();
		}
	}

}