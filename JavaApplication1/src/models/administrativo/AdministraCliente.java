package models.administrativo;

import models.financeiro.ContaCorrente;
import models.sistema.ClasseString;
import models.sistema.Sistema;

//possui todos os metodos relacionados a objetos da classe Cliente
public class AdministraCliente {
	public static Cliente incluirCliente() {
		Cliente c = new Cliente();
		c.setNome(ClasseString.getString("Digite o nome do cliente"));
		c.setCoCliente(Sistema.codigoAtualCliente);
		c.adicionarCC();
		return c;
	}
	
	public static void imprimeClientesCadastrados() {
		Cliente cli = new Cliente();
		for(int m=0; m< Sistema.clientesArrayList.size(); m++){
			System.out.println("\nDados da pessoa " + (m+1));
			cli = (Cliente) Sistema.clientesArrayList.get(m);
			cli.imprimeTodosOsDados();
		}
	}

}

