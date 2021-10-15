package br.com.codenation;

public class BillingProcessor {

    public Double calculate(Order order) {
    	try {
    		return order.getPaymentMethod().getPaymentStrategy().calculate(order.getPrice());
    	} catch (Exception e) {
    		throw new RuntimeException("Payment method not implemented");
    	}
//        switch (order.getPaymentMethod()) {
//            case CASH:
////                return order.getPrice() * 0.9;
//            	return cash.calculate(order.getPrice());
//            case TRANSFER:
//                return order.getPrice() * 0.92;
//            case CREDIT_CARD:
//                return order.getPrice() * 0.98;
//            case DEBIT_CARD:
////                return order.getPrice() * 0.95;
//            	PaymentMethod.DEBIT_CARD.getPaymentStrategy();
//        }
//        throw new RuntimeException("Payment method not implemented");
    }
}