package report;

import car_components.ModelsParameters;
import car_types.Car;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Report {
    private String name;
    private ArrayList<Car> soldCars;

    public Report(String name) {
        this.name = name;
        soldCars = new ArrayList<>();
    }

    public void addCar(Car car) {
        soldCars.add(car);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Car> getSoldCars() {
        return soldCars;
    }

    public BigDecimal countIncome() {
        BigDecimal result = BigDecimal.ZERO;
        for (Car car : soldCars) {
            result = result.add(car.getCarPrice());
        }
        return result;
    }

    public BigDecimal countExpenses() {
        BigDecimal result = BigDecimal.ZERO;
        for (Car car : soldCars) {
            result = result.add(ModelsParameters.valueOf(car.getModel().toUpperCase()).getCostPrice());
        }
        return result;
    }

    public BigDecimal countProfit() {
        return countIncome().subtract(countExpenses());
    }

}
