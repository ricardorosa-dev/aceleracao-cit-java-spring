package br.com.codenation.paymentmethods;

public enum PaymentMethod {

    CASH(new StrategyCash()), 
    DEBIT_CARD(new StrategyDebitCard()), 
    CREDIT_CARD(new StrategyCreditCard()), 
    TRANSFER(new StrategyTransfer());

    private PriceStrategy priceStrategy;

    PaymentMethod(PriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }

    public PriceStrategy getPaymentStrategy() {
        return priceStrategy;
    }
}