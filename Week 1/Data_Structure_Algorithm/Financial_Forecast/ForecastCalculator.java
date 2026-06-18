
public class ForecastCalculator {

    // Recursive method to calculate future value
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        
        // Base case - 0 years
        if (years == 0) {
            return presentValue;
        }

        // Recursive case - grow value by one year, then call again for remaining years
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }
}