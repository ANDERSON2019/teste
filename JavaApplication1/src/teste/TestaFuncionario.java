/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teste;

/**
 *
 * @author 8183548
 */
public class TestaFuncionario {
   
   public static void main(String[] args) {
     Funcionario f1 = new Funcionario();
   
     f1.nome = "Hugo";
     f1.salario = 100;
     f1.recebeAumento(50);
   
     System.out.println("salario atual:" + f1.salario);
     System.out.println("ganho anual:" + f1.calculaGanhoAnual());
   }
 }