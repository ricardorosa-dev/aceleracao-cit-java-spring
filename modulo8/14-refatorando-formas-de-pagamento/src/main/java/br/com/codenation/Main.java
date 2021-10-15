package br.com.codenation;

import br.com.codenation.paymentmethods.PaymentMethod;

public class Main {

	public static void main(String[] args) {
//		PriceStrategy response = PaymentMethod.CASH.getPaymentStrategy();
		Order myOrder = new Order(100.0, PaymentMethod.CREDIT_CARD);
		System.out.println(myOrder.getPaymentMethod().getPaymentStrategy().calculate(100.0));
		
		
		
//		BillingProcessor processor = new BillingProcessor();
//		Double response = processor.calculate(myOrder);
		
//		System.out.println(response);

	}

}
