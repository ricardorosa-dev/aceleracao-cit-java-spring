package br.com.codenation.paymentmethods;

public class StrategyCreditCard implements PriceStrategy{

	@Override
	public Double calculate(Double price) {
		return price * 0.98;
	}

}
