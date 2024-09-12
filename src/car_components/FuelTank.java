package car_components;

import java.math.BigDecimal;

public class FuelTank extends CarComponent{
    private double amountOfFuel;

    public FuelTank(double amountOfFuel) {
        this.amountOfFuel = amountOfFuel;
    }

    public double getAmountOfFuel() {
        return amountOfFuel;
    }
}
