package car_types;

import car_components.*;

import java.math.BigDecimal;

public abstract class CargoVan extends Car {

    private int loadCapacity;

    public CargoVan(String color, int maxSpeed, String transmission, Wheel firstWheel, Wheel secondWheel,
                    Wheel thirdWheel, Wheel fourthWheel, Electrics electrics, Engine engine, FuelTank fuelTank,
                    Headlight headlight, BigDecimal carPrice, int loadCapacity, String country) {
        super(color, maxSpeed, transmission, firstWheel, secondWheel, thirdWheel, fourthWheel, electrics,
                engine, fuelTank, headlight, carPrice, country);
        this.loadCapacity = loadCapacity;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

}
