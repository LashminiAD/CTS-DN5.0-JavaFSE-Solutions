// Author: Lashmini A D
// CTS DN 5.0 - Week1 - Exercise07 - Financial Forecasting (Recursion)

public class Main {
    public static void main(String[] args) {

        double presentValue = 10000;   // starting investment ₹10,000
        double growthRate = 0.08;      // 8% growth per year
        int years = 5;                 // predict 5 years ahead

        double futureValue = ForecastCalculator.calculateFutureValue(presentValue, growthRate, years);

        System.out.println("Present Value: " + presentValue);
        System.out.println("Growth Rate: " + (growthRate * 100) + "%");
        System.out.println("Years: " + years);
        System.out.printf("Predicted Future Value: %.2f%n", futureValue);
    }
}