package models.financeiro;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import models.sistema.Numero;

public class ContaCorrente {
	int numeroContaCorrente=0;
	public int getNumeroContaCorrente() {
		return numeroContaCorrente;
	}

	public void setNumeroContaCorrente(int numeroContaCorrente) {
		this.numeroContaCorrente = numeroContaCorrente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	double saldo = 1000;
	DecimalFormat doisDigitos = new DecimalFormat("0.00");

	int flagStatus=0;

	public void realizarDeposito() {
		double valorDeposito=0;
		valorDeposito = Numero.getNumeroReal("Digite o valor do depósito");
		if(valorDeposito>0)
			saldo += valorDeposito;
		else
			System.out.println("Nao e possivel realizar deposito de valores negativos");
		mostrarSaldo();
	}

	public void realizarSaque() {
		double valorSaque;
		valorSaque = Numero.getNumeroReal("Digite o valor do saque");
		if(valorSaque<0) {
			System.out.println("Nao e possivel realizar saque de valores negativos");
			return; //Interrompe a execução da função
		}
		if(valorSaque <= saldo)
			saldo -= valorSaque;
		else
			System.out.println("Saldo insuficiente");
		mostrarSaldo();
	}

	public void mostrarSaldo() {
		System.out.println(NumberFormat.getCurrencyInstance().format(saldo));
		//		System.out.println("Saldo da Conta Corrente: " + doisDigitos.format(saldo));
	}

	public void mostraDadosDaConta() {
		System.out.println("Dados da conta Corrente");
		System.out.println("Numero: " + numeroContaCorrente);
		System.out.println("Saldo: " + saldo);
	}
}



