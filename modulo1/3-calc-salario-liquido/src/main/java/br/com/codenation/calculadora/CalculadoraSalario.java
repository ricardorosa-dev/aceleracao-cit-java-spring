package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		if (salarioBase < 1039.00) {
			return 0;
		}

		double salario = salarioBase;

		double INSS = calcINSS(salarioBase);
		salario -= INSS;

		double IRRF = calcIRRF(salario);
		salario -= IRRF;

		int result = (int) Math.round(salario);
		return result;
	}


	private static double calcINSS(double sBruto) {
		if (sBruto <= 1500.00) {
			return sBruto * 0.08;
		}
		if (sBruto <= 4000.00) {
			return sBruto * 0.09;
		}
		if (sBruto > 4000.00) {
			return sBruto * 0.11;
		}
		return sBruto;
	}

	private static double calcIRRF(double sLiq) {
		if (sLiq <= 3000.00) {
			return 0.00;
		}
		if (sLiq <= 6000.00) {
			return sLiq * 0.075;
		}
		if (sLiq > 6000.00) {
			return sLiq * 0.15;
		}
		return sLiq;
	}

}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/