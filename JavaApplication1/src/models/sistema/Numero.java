package models.sistema;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Numero {
    static String numeroReal;
	static String numeroInteiro;

	public static Double getNumeroReal(String mensagem) {
		try{ 
			//JAVA exige try-catch para a entrada de dados
//			Utilize scanner caso prefira. Neste caso, numeroReal deverá ser do tipo double e não string			
//			Scanner scan = new Scanner(System.in);
//			numeroReal = scan.nextDouble();
			
			BufferedReader in = new BufferedReader(new
					InputStreamReader(System.in));
			System.out.println(mensagem);
			numeroReal = in.readLine();
			//Saída dos dados na tela
		} catch (IOException e) { // Catch any IO exceptions.
			e.printStackTrace();
		}
		return Double.parseDouble(numeroReal);
	}

	public static int getNumeroInteiro(String mensagem) {
        try{ 
			//JAVA exige try-catch para a entrada de dados
//			Utilize scanner caso prefira. Neste caso, numeroReal deverá ser do tipo double e não string			
//			Scanner scan = new Scanner(System.in);
//			numeroReal = scan.nextDouble();
			
			BufferedReader in = new BufferedReader(new
					InputStreamReader(System.in));
			System.out.println(mensagem);
			numeroInteiro = in.readLine();
			//Saída dos dados na tela
		} catch (IOException e) { // Catch any IO exceptions.
			e.printStackTrace();
		}
		return Integer.parseInt(numeroInteiro);
	}
		//IMPLEMENTAR O MÉTODO
	}


