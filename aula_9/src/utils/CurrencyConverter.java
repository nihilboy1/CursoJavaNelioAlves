package utils;

public class CurrencyConverter{
    public static final double IOF = 6;

    public static double dollarToReal(double dollarPrice, double dollarToBeBought){
        double tax = dollarToBeBought * IOF / 100;
        return dollarToBeBought * dollarPrice + tax * dollarPrice; // price in reais
    }

    ;
}
